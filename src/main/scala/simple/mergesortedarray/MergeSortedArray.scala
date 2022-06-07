package com.soumen.leetcodesolutions
package simple.mergesortedarray

/**
 * <a href = "https://leetcode.com/problems/merge-sorted-array/">
 * 88. Merge Sorted Array
 * </a>
 * */
object MergeSortedArray extends App {
  @scala.annotation.tailrec
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = if (n > 0) {
    if (m > 0 && nums1(m - 1) >= nums2(n - 1)) {
      nums1(m + n - 1) = nums1(m - 1)
      merge(nums1, m - 1, nums2, n)
    } else {
      nums1(m + n - 1) = nums2(n - 1)
      merge(nums1, m, nums2, n - 1)
    }
  }

  val nums1 = Array(1, 2, 3, 0, 0, 0)
  val nums2 = Array(2, 5, 6)
  merge(nums1, 3, nums2, 3)
  println(nums1.toSeq)
}
//Runtime: 785 ms, faster than 38.35% of Scala online submissions for Merge Sorted Array.
//Memory Usage: 66.9 MB, less than 57.53% of Scala online submissions for Merge Sorted Array.