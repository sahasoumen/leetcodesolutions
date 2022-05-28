package com.soumen.leetcodesolutions
package contest.biweeklycontest79

/**
 * <a href="https://leetcode.com/contest/biweekly-contest-79/problems/maximum-total-importance-of-roads/">
 * 6085. Maximum Total Importance of Roads
 * </a>
 * */
object MaximumTotalImportanceOfRoads extends App {
  def maximumImportance(n: Int, roads: Array[Array[Int]]): Long = {
    val sorted = roads.flatten.groupBy(identity).view.mapValues(_.length).toSeq.sortBy(identity) { (t1, t2) =>
      t2._2.compareTo(t1._2) match {
        case 0 => t2._1.compareTo(t1._1)
        case c => c
      }
    }.map(_._1).zipAll(n to 1 by -1, Int.MinValue, Int.MaxValue).toMap
    roads.foldLeft(0L)((sum, road) => sum + sorted(road(0)) + sorted(road(1)))
  }

  println(maximumImportance(5, Array(Array(0, 1), Array(1, 2), Array(2, 3), Array(0, 2), Array(1, 3), Array(2, 4))))
  println(maximumImportance(5, Array(Array(0, 3), Array(2, 4), Array(1, 3))))
  println(maximumImportance(5, Array(Array(0, 1))))
}
