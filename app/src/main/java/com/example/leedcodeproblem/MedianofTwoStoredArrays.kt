package com.example.leedcodeproblem

// Jitendra Created this class on 26-06-2025
// Explanation : To find the median of two sorted arrays in O(log(min(m,n))) time complexity,
// we can use a binary search approach. The key idea is to partition both arrays such that the combined left
// half contains the smaller elements and the combined right half contains the larger ones.

// This approach runs in O(log(min(m, n))) time and uses constant space.
// It handles edge cases like empty arrays and odd/even total lengths correctly.


class MedianofTwoStoredArrays {

    fun FourthProblem(){
        val nums1 = intArrayOf(1, 3)
        val nums2 = intArrayOf(2)
        val median = findMedianSortedArrays(nums1, nums2)
        println("Median: ${String.format("%.5f", median)}")  // Output: 2.00000

    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Ensure nums1 is the smaller array
        val A = if (nums1.size <= nums2.size) nums1 else nums2
        val B = if (nums1.size > nums2.size) nums1 else nums2
        val m = A.size
        val n = B.size

        var low = 0
        var high = m

        while (low <= high) {
            val partitionA = (low + high) / 2
            val partitionB = (m + n + 1) / 2 - partitionA

            val maxLeftA = if (partitionA == 0) Int.MIN_VALUE else A[partitionA - 1]
            val minRightA = if (partitionA == m) Int.MAX_VALUE else A[partitionA]

            val maxLeftB = if (partitionB == 0) Int.MIN_VALUE else B[partitionB - 1]
            val minRightB = if (partitionB == n) Int.MAX_VALUE else B[partitionB]

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                return if ((m + n) % 2 == 0) {
                    (maxOf(maxLeftA, maxLeftB) + minOf(minRightA, minRightB)) / 2.0
                } else {
                    maxOf(maxLeftA, maxLeftB).toDouble()
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1
            } else {
                low = partitionA + 1
            }
        }

        throw IllegalArgumentException("Input arrays are not sorted")
    }

}