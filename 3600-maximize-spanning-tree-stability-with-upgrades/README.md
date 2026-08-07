# 3600. Maximize Spanning Tree Stability with Upgrades

## Problem

You are given an undirected graph with weighted edges. Some edges are mandatory, and a limited number of upgrades can be applied. Find the maximum possible stability of a spanning tree while satisfying all constraints.

## Approach

- Include all mandatory edges first using Disjoint Set Union (DSU).
- Sort the remaining edges by their stability values.
- Apply a modified Kruskal's algorithm to construct the spanning tree.
- Use upgrades optimally to maximize the minimum stability when allowed.

## Complexity Analysis

- Time Complexity: O(E log E)

- Space Complexity: O(V)
