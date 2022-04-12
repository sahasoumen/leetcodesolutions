package com.soumen.leetcodesolutions
package medium.topkfrequentelement

object TopKFrequentElements extends App {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = nums.map(_ -> 1).groupBy(_._1).view.mapValues(_.length).toSeq.sortBy(-_._2).map(_._1).take(k).toArray
}
//Runtime: 1295 ms, faster than 15.63% of Scala online submissions for Top K Frequent Elements.
//Memory Usage: 88.4 MB, less than 16.67% of Scala online submissions for Top K Frequent Elements.