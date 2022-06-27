package com.soumen.leetcodesolutions
package medium.partitioningintominimumnumberofdecibinarynumbers

/**
 * <a href="https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/">
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * </a>
 * <a href="https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/discuss/2204589/Scala-or-1-Liner-or-3-Approaches-or-100-faster-or-100-less-memory">
 *   Discussion
 * </a>
 * */
object PartitioningIntoMinimumNumberOfDeciBinaryNumbers2 extends App {
  def minPartitions(n: String): Int = ('9'.toInt to '0'.toInt by -1).find(n.contains(_)).get - '0'

  println(minPartitions("32")) //3
  println(minPartitions("82734")) //8
  println(minPartitions("27346209830709182346")) //9
}
//Runtime: 931 ms, faster than 33.33% of Scala online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
//Memory Usage: 83.5 MB, less than 66.67% of Scala online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
