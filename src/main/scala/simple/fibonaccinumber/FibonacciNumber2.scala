package com.soumen.leetcodesolutions
package simple.fibonaccinumber

/**
 * <a href = "https://leetcode.com/problems/fibonacci-number/">
 * 509. Fibonacci Number
 * </a>
 * */
object FibonacciNumber2 extends App {
  @scala.annotation.tailrec
  def fib(n: Int, last: Int = 1, secondLast: Int = 0): Int = if (n == 0) secondLast else fib(n - 1, last + secondLast, last)

  println(fib(0)) //0
  println(fib(1)) //1
  println(fib(2)) //1
  println(fib(3)) //2
  println(fib(4)) //3
  println(fib(5)) //5
  println(fib(6)) //8
  println(fib(7)) //13
  println(fib(8)) //21
}
//Runtime: 468 ms, faster than 93.55% of Scala online submissions for Fibonacci Number.
//Memory Usage: 51.4 MB, less than 86.02% of Scala online submissions for Fibonacci Number.