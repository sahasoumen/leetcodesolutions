package com.soumen.leetcodesolutions
package simple.laststoneweight

/**
 * https://leetcode.com/problems/last-stone-weight/
 * 1046. Last Stone Weight
 * */
object LastStoneWeight3 extends App {
  def lastStoneWeight(stones: Array[Int]): Int = scala.collection.mutable.PriorityQueue.from(stones) match {
    case q => while (q.length > 1) q.enqueue(q.dequeue() - q.dequeue())
      if (q.isEmpty) 0 else q.dequeue()
  }

  println(lastStoneWeight(Array(2, 7, 4, 1, 8, 1)))
}
//Runtime: 593 ms, faster than 86.67% of Scala online submissions for Last Stone Weight.
//Memory Usage: 55.2 MB, less than 88.00% of Scala online submissions for Last Stone Weight.