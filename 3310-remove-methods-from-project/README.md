# 3310. Remove Methods From Project

## Problem Statement

You are given an integer `n` representing the number of methods in a project, where methods are numbered from `0` to `n - 1`.

You are also given an integer `k` and a 2D integer array `invocations`, where `invocations[i] = [a, b]` indicates that method `a` invokes method `b`.

A method is considered **suspicious** if it is reachable from method `k` through one or more invocations (including `k` itself).

Remove all suspicious methods **only if no non-suspicious method invokes any suspicious method**.

Return the list of remaining methods after applying the rule.

## Constraints

- `1 <= n <= 10^5`
- `0 <= k < n`
- `0 <= invocations.length <= 2 × 10^5`
- `invocations[i].length == 2`
