package com.soumen.leetcodesolutions
package simple.countsquresumtriples

/**
 * https://leetcode.com/problems/count-square-sum-triples/submissions/
 * 1925. Count Square Sum Triples
 * */

object Solution4 extends App {
  def countTriples(n: Int): Int = (for (i <- 1 to n; j <- 1 to n if i != j) yield Math.sqrt(i * i + j * j)).count(s => s % 1 == 0 && s <= n)

  println(countTriples(5))
  println(countTriples(10))
  println(countTriples(18))

}
//Runtime: 1208 ms, faster than 50.00% of Scala online submissions for Count Square Sum Triples.
//Memory Usage: 84.8 MB, less than 50.00% of Scala online submissions for Count Square Sum Triples.