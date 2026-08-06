import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int z = 1; z <= Math.min(zero, limit); z++) {
            dp[z][0][0] = 1;
        }
        for (int o = 1; o <= Math.min(one, limit); o++) {
            dp[0][o][1] = 1;
        }
        for (int z = 1; z <= zero; z++) {
            for (int o = 1; o <= one; o++) {
                dp[z][o][0] = dp[z - 1][o][0];
                dp[z][o][0] += dp[z - 1][o][1];
                if (z - limit - 1 >= 0) {
                    dp[z][o][0] -= dp[z - limit - 1][o][1];
                }
                dp[z][o][0] = (dp[z][o][0] + MOD) % MOD;
                dp[z][o][1] = dp[z][o - 1][1];
                dp[z][o][1] += dp[z][o - 1][0];
                if (o - limit - 1 >= 0) {
                    dp[z][o][1] -= dp[z][o - limit - 1][0];
                }

                dp[z][o][1] = (dp[z][o][1] + MOD) % MOD;
            }
        }

        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
