# 1009. Complement of Base 10 Integer

## Problem

Given a non-negative integer `n`, return its complement in base 10.

The complement of an integer is the integer obtained by flipping all the bits in its binary representation (excluding leading zeros).

## Approach

- Convert the number to its binary representation.
- Create a bitmask with all bits set to 1 for the length of the binary representation.
- XOR the number with the bitmask to obtain the complement.
- Handle the special case when `n = 0`.

## Complexity Analysis

- Time Complexity: O(log n)

- Space Complexity: O(1)
