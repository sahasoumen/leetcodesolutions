package com.soumen.leetcodesolutions
package hard.medianof2sortedarrays

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 4. Median of Two Sorted Arrays
 * */
object MedianOfTwoSortedArrays extends App {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    def next(num1: Seq[Int], num2: Seq[Int]) = num1 match {
      case Nil => num2.head
      case head1 :: _ => num2 match {
        case Nil => head1
        case head2 :: _ => if (head1 < head2) head1 else head2
      }
    }

    @scala.annotation.tailrec
    def findMedianSortedArrays(num1: Seq[Int], num2: Seq[Int], target: Int, even: Boolean, median: Double = 0.0): Double = {
      if (target == 0) if (even) (median + next(num1, num2)) / 2 else next(num1, num2)
      else num1 match {
        case Nil => findMedianSortedArrays(num1, num2.tail, target - 1, even, num2.head)
        case head1 :: tail1 => num2 match {
          case Nil => findMedianSortedArrays(tail1, num2, target - 1, even, head1)
          case head2 :: tail2 => if (head1 < head2) findMedianSortedArrays(tail1, num2, target - 1, even, head1) else findMedianSortedArrays(num1, tail2, target - 1, even, head2)
        }
      }
    }

    findMedianSortedArrays(nums1.toList, nums2.toList, (nums1.length + nums2.length) / 2, (nums1.length + nums2.length) % 2 == 0)
  }
}
