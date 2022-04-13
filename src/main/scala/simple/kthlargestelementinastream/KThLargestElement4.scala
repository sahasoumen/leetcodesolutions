package com.soumen.leetcodesolutions
package simple.kthlargestelementinastream

object KThLargestElement4 extends App {
  class KthLargest(_k: Int, _nums: Array[Int]) {
    val q = scala.collection.mutable.PriorityQueue.from(_nums)(Ordering.Int.reverse)

    def add(v: Int): Int = if (q.length >= _k && v <= q.head) q.head else {
      q enqueue v
      while (q.length > _k) q.dequeue()
      q.head
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
//Runtime: 790 ms, faster than 89.17% of Scala online submissions for Kth Largest Element in a Stream.
//Memory Usage: 63.8 MB, less than 97.50% of Scala online submissions for Kth Largest Element in a Stream.