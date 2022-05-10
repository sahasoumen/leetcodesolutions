package com.soumen.leetcodesolutions
package simple.countsquresumtriples

/**
 * https://leetcode.com/problems/count-square-sum-triples/submissions/
 * 1925. Count Square Sum Triples
 * */

object Solution2 extends App {
  def countTriples(n: Int): Int = {
    val l = 1 to n
    val m1 = l.map(i => i * i -> i).toMap
    val m2 = m1.map(_.swap)
    l.map(i => l.filterNot(_ == i).count(j => m1.contains(m2(i) + m2(j)))).sum
  }

  println(countTriples(5))
  println(countTriples(10))
  println(countTriples(18))

}
//Runtime: 1615 ms, faster than 50.00% of Scala online submissions for Count Square Sum Triples.
//Memory Usage: 86.9 MB, less than 50.00% of Scala online submissions for Count Square Sum Triples.