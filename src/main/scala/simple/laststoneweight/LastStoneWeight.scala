package com.soumen.leetcodesolutions
package simple.laststoneweight

/**
 * https://leetcode.com/problems/last-stone-weight/
 * 1046. Last Stone Weight
 * */
object LastStoneWeight extends App {
  def lastStoneWeight(stones: Array[Int]): Int = {
    @scala.annotation.tailrec
    def lastStoneWeight(stones: Seq[Int]): Int = stones match {
      case Nil => 0
      case top :: Nil => top
      case top :: rest => rest match {
        case Nil => top
        case nextTop :: nextRest => top - nextTop match {
          case 0 => lastStoneWeight(nextRest)
          case w => lastStoneWeight((nextRest :+ w).sorted(Ordering.Int.reverse))
        }
      }
    }

    lastStoneWeight(stones.toList.sorted(Ordering.Int.reverse))
  }

  println(lastStoneWeight(Array(2, 7, 4, 1, 8, 1)))
}
//Runtime: 530 ms, faster than 86.30% of Scala online submissions for Last Stone Weight.
//Memory Usage: 53.3 MB, less than 97.26% of Scala online submissions for Last Stone Weight.