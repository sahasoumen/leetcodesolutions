package com.soumen.leetcodesolutions
package hard.constructtargetarraywithmultiplesums

/**
 * <a href="https://leetcode.com/problems/construct-target-array-with-multiple-sums/">
 * 1354. Construct Target Array With Multiple Sums
 * </a>
 * Scala version of <a href="https://leetcode.com/problems/construct-target-array-with-multiple-sums/discuss/2189445/Visual-Explanation-or-JAVA-Max-Heap">Visual Explanation | JAVA Max-Heap</a>
 * */
object ConstructTargetArrayWithMultipleSums extends App {

  def isPossible(target: Array[Int]): Boolean = {
    val q = scala.collection.mutable.PriorityQueue(target: _*)

    @scala.annotation.tailrec
    def helper(sum: Int = q.sum): Boolean = q.dequeue() match {
      case max if max == 1 || sum - max == 1 => true
      case max => max % (sum - max) match {
        case next if next == 0 || next == max => false
        case next => q.enqueue(next)
          helper(sum - max + next)
      }
    }

    if (target.length == 1) target.head == 1 else helper()
  }

  //  println(isPossible(Array(9, 3, 5)))
  //  println(isPossible(Array(1, 1, 1, 2)))
  //  println(isPossible(Array(8, 5)))
  println(isPossible(Array(2)))
}

//Runtime: 1547 ms, faster than 100.00% of Scala online submissions for Construct Target Array With Multiple Sums.
//Memory Usage: 87.6 MB, less than 100.00% of Scala online submissions for Construct Target Array With Multiple Sums.