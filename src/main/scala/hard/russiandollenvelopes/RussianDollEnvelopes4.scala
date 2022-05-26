package com.soumen.leetcodesolutions
package hard.russiandollenvelopes

import java.time.Duration
import scala.collection.mutable.ArrayBuffer

/**
 * <a href = "https://leetcode.com/problems/russian-doll-envelopes/submissions/">
 * 354. Russian Doll Envelopes
 * </a>
 * */
object RussianDollEnvelopes4 extends App {

  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = envelopes.sortBy(e => e(0) -> -e(1)) match {
    case sorted =>
      @scala.annotation.tailrec
      def binarySearch(l: ArrayBuffer[Int], i: Int, left: Int, right: Int): Int =
        if (left > right) if (left == sorted.length) sorted.length - 1 else left else {
          val mid = left + (right - left) / 2
          if (sorted(i)(1) > l(mid))
            binarySearch(l, i, mid + 1, right)
          else
            binarySearch(l, i, left, mid - 1)
        }

      val dp = ArrayBuffer(sorted(0)(1))
      (1 until sorted.length).foreach(i =>
        if (sorted(i)(1) > dp(dp.length - 1))
          dp += sorted(i)(1)
        else
          dp(binarySearch(dp, i, 0, dp.length - 1)) = sorted(i)(1)
      )
      dp.length
  }

  println(maxEnvelopes(Array(Array(5, 4), Array(6, 4), Array(6, 7), Array(2, 3))))
  println(maxEnvelopes(Array(Array(1, 1), Array(1, 1), Array(1, 1), Array(1, 1))))
  println(maxEnvelopes(Array(Array(4, 5), Array(4, 6), Array(6, 7), Array(2, 3), Array(1, 1))))
  val envelopes = (1 to 100000).map(i => Array(i, i)).toArray
  val start = System.currentTimeMillis
  println(maxEnvelopes(envelopes))
  println(s"Time Taken: ${Duration.ofMillis(System.currentTimeMillis - start)}")
}
//Runtime: 2248 ms, faster than 100.00% of Scala online submissions for Russian Doll Envelopes.
//Memory Usage: 216.5 MB, less than 50.00% of Scala online submissions for Russian Doll Envelopes.