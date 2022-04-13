package com.soumen.leetcodesolutions
package simple.laststoneweight

object LastStoneWeight2 extends App {
  def lastStoneWeight(stones: Array[Int]): Int = {
    @scala.annotation.tailrec
    def lastStoneWeight(stones: scala.collection.mutable.PriorityQueue[Int]): Int = if (stones.isEmpty) 0 else stones.dequeue() match {
      case top => if (stones.isEmpty) top else stones.dequeue() match {
        case nextTop => top - nextTop match {
          case 0 => lastStoneWeight(stones)
          case w => lastStoneWeight(stones += w)
        }
      }
    }

    lastStoneWeight(scala.collection.mutable.PriorityQueue.from(stones))
  }

  println(lastStoneWeight(Array(2, 7, 4, 1, 8, 1)))
}
//Runtime: 546 ms, faster than 86.67% of Scala online submissions for Last Stone Weight.
//Memory Usage: 55.1 MB, less than 90.67% of Scala online submissions for Last Stone Weight.