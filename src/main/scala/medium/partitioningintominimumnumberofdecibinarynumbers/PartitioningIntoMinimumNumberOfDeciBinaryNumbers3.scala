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
object PartitioningIntoMinimumNumberOfDeciBinaryNumbers3 extends App {
  def minPartitions(n: String): Int = {
    @scala.annotation.tailrec
    def helper(i: Int = 0, max: Int = 0): Int = if (i == n.length || max == 9) max - '0' else helper(i + 1, max max n(i))

    helper()
  }

  println(minPartitions("32")) //3
  println(minPartitions("82734")) //8
  println(minPartitions("27346209830709182346")) //9
}
//Runtime: 580 ms, faster than 100.00% of Scala online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
//Memory Usage: 53.2 MB, less than 100.00% of Scala online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.