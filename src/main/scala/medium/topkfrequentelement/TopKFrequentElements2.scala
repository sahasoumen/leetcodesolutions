package com.soumen.leetcodesolutions
package medium.topkfrequentelement

object TopKFrequentElements2 extends App {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    @scala.annotation.tailrec
    def topKFrequent(pos: Int = 0, m: Map[Int, Int] = Map.empty): Array[Int] = if (pos == nums.length)
      m.toSeq.sortBy(-_._2).take(k).map(_._1).toArray
    else m get nums(pos) match {
      case Some(n) => topKFrequent(pos + 1, m + (nums(pos) -> (n + 1)))
      case None => topKFrequent(pos + 1, m + (nums(pos) -> 1))
    }

    topKFrequent()
  }
}
//Runtime: 716 ms, faster than 78.71% of Scala online submissions for Top K Frequent Elements.
//Memory Usage: 62.5 MB, less than 78.71% of Scala online submissions for Top K Frequent Elements.