package com.soumen.leetcodesolutions
package simple.fibonaccinumber

/**
 * <a href = "https://leetcode.com/problems/fibonacci-number/">
 * 509. Fibonacci Number
 * </a>
 * */
object FibonacciNumber extends App {
  def fib(n: Int): Int = if (n == 0) 0 else if (n == 1) 1 else fib(n - 1) + fib(n - 2)

  println(fib(0)) //0
  println(fib(1)) //1
  println(fib(2)) //1
  println(fib(3)) //2
  println(fib(4)) //3
  println(fib(5)) //5
}
  //Runtime: 683 ms, faster than 35.48% of Scala online submissions for Fibonacci Number.
  //Memory Usage: 62.9 MB, less than 35.48% of Scala online submissions for Fibonacci Number.