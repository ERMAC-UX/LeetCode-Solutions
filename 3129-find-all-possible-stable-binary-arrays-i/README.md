# 3129. Find All Possible Stable Binary Arrays I

## Problem
Given the number of zeros, ones, and a limit, find the number of stable binary arrays possible.

An array is stable if every subarray with length greater than limit contains both 0 and 1.

## Approach
- Use Dynamic Programming to count possible arrangements.
- Track the number of zeros and ones used.
- Maintain the last placed element and consecutive count.
- Apply modulo to avoid overflow.

## Complexity Analysis

Time Complexity: O(num_zeros * num_ones * limit)

Space Complexity: O(num_zeros * num_ones * limit)
