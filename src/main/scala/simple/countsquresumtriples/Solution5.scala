package com.soumen.leetcodesolutions
package simple.countsquresumtriples

/**
 * https://leetcode.com/problems/count-square-sum-triples/submissions/
 * 1925. Count Square Sum Triples
 * */

object Solution5 extends App {
  def countTriples(n: Int): Int = {
    val l = 1 to n
    val m = l.map(i => i * i -> i).toMap
    (for (i <- l; j <- l if i != j) yield m.get(i * i + j * j)).flatten.size
  }

  println(countTriples(5))
  println(countTriples(10))
  println(countTriples(18))

}
//Runtime: 825 ms, faster than 50.00% of Scala online submissions for Count Square Sum Triples.
//Memory Usage: 53.4 MB, less than 50.00% of Scala online submissions for Count Square Sum Triples.