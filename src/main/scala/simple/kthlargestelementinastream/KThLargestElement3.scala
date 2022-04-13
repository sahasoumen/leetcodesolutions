package com.soumen.leetcodesolutions
package simple.kthlargestelementinastream

object KThLargestElement3 extends App {
  class KthLargest(_k: Int, _nums: Array[Int]) {
    val sorted = scala.collection.mutable.PriorityQueue.from(_nums)(Ordering.Int.reverse)

    def add(v: Int): Int = {
      sorted enqueue v
      while (sorted.length > _k) sorted.dequeue()
      sorted.head
    }
  }

  //  var obj = new KthLargest(3, Array(4, 5, 8, 2))
  //  println(obj.add(3))
  //  println(obj.add(5))
  //  println(obj.add(10))
  //  println(obj.add(9))
  //  println(obj.add(4))
  var obj = new KthLargest(2, Array(0))
  println(obj.add(-1))
  println(obj.add(1))
  println(obj.add(-2))
  println(obj.add(-4))
  println(obj.add(3))

}
//Runtime: 748 ms, faster than 91.67% of Scala online submissions for Kth Largest Element in a Stream.
//Memory Usage: 63.5 MB, less than 98.33% of Scala online submissions for Kth Largest Element in a Stream.