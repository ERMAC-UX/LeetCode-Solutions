class Solution {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        long max = 0;

        for (int[] e : edges) {
            max = Math.max(max, 2L * e[2]);
        }

        long low = 0, high = max;

        while (low < high) {
            long mid = low + (high - low + 1) / 2;

            if (canBuild(n, edges, k, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low == 0 ? -1 : (int) low;
    }

    private boolean canBuild(int n, int[][] edges, int k, long target) {
        DSU dsu = new DSU(n);
        int components = n;

        // Mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            long strength = e[2];
            int must = e[3];

            if (must == 1) {
                if (strength < target) return false;

                if (!dsu.union(u, v)) {
                    return false;
                }

                components--;
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            long strength = e[2];
            int must = e[3];

            if (must == 0 && strength >= target) {
                if (dsu.union(u, v)) {
                    components--;
                }
            }
        }
        int upgrades = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            long strength = e[2];
            int must = e[3];

            if (must == 0 &&
                strength < target &&
                2L * strength >= target) {

                if (dsu.union(u, v)) {
                    upgrades++;
                    components--;

                    if (upgrades > k) {
                        return false;
                    }

                    if (components == 1) {
                        return true;
                    }
                }
            }
        }

        return components == 1;
    }
}
