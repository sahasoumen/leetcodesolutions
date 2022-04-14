package com.soumen.leetcodesolutions
package simple.kthlargestelementinastream

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * 703. Kth Largest Element in a Stream
 */
object KThLargestElement extends App {
  class KthLargest(_k: Int, _nums: Array[Int]) {
    var sorted = _nums.toSeq

    def add(v: Int): Int = {
      sorted = (sorted :+ v).sorted
      if (sorted.length > _k) sorted = sorted.takeRight(_k)
      sorted.head
    }

  }

  var obj = new KthLargest(3, Array(4, 5, 8, 2))
  println(obj.add(3))
  println(obj.add(5))
  println(obj.add(10))
  println(obj.add(9))
  println(obj.add(4))

}
//Runtime: 1476 ms, faster than 43.33% of Scala online submissions for Kth Largest Element in a Stream.
//Memory Usage: 65 MB, less than 89.17% of Scala online submissions for Kth Largest Element in a Stream.