# Algorithms-ProgrammingAssignment1

## Problem 1: Computing the Median

In this assignment, three methods are explored to compute the k-th smallest element of a given array and compare their performance. The three methods are as follows:

1. **Randomized Divide-and-Conquer Approach**: It employs a divide-and-conquer strategy to find the k-th smallest element with a random pivot.

2. **Deterministic Linear-Time Selection Algorithm using Median-of-Medians**: It aims to find the k-th smallest element in linear time.

3. **Naive Method using Sorting**: The naive approach involves sorting the entire array and returning the k-th smallest element.

The goal of this assignment is to compare the efficiency and runtime of the three methods in finding the k-th smallest element as the array size increases.

## Problem 2: Maximum Square Length around Points

In this problem, the goal is to compute the maximum side length of a square that can be drawn around each given two-dimensional point in such a way that no two squares intersect except at their sides. The following considerations apply:

- Each point serves as the center of the square surrounding it.
- The sides of the squares can only be horizontal and vertical.
