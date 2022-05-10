package com.soumen.leetcodesolutions
package simple.countsquresumtriples

/**
 * https://leetcode.com/problems/count-square-sum-triples/submissions/
 * 1925. Count Square Sum Triples
 * */
object Solution extends App {
  def countTriples(n: Int): Int = {
    val l = 1 to n
    val m = l.map(i => i * i -> i).toMap
    l.map(i => l.filterNot(_ == i).count(j => m.contains(i * i + j * j))).sum
  }

  println(countTriples(5))
  println(countTriples(10))
  println(countTriples(18))

}
//Runtime: 693 ms, faster than 50.00% of Scala online submissions for Count Square Sum Triples.
//Memory Usage: 52.9 MB, less than 50.00% of Scala online submissions for Count Square Sum Triples.