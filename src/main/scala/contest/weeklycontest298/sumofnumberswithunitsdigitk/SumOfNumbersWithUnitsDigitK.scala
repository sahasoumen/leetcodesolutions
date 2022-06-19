package com.soumen.leetcodesolutions
package contest.weeklycontest298.sumofnumberswithunitsdigitk

/**
 * <a href="https://leetcode.com/contest/weekly-contest-298/problems/sum-of-numbers-with-units-digit-k/">
 * 5218. Sum of Numbers With Units Digit K
 * </a>
 * */
object SumOfNumbersWithUnitsDigitK extends App {
  def minimumNumbers(num: Int, k: Int): Int = if (num == 0) 0 else (1 to 10).find(i => i * k % 10 == num % 10 && i * k <= num).getOrElse(-1)

  println(minimumNumbers(58, 9)) //2
  println(minimumNumbers(37, 2)) //-1
  println(minimumNumbers(0, 7)) //0
  println(minimumNumbers(1, 1)) //1
  println(minimumNumbers(5, 1)) //5
  println(minimumNumbers(19, 3)) //3
  println(minimumNumbers(2, 8)) //-1
}
//Runtime: 763 ms, faster than 100.00% of Scala online submissions for Sum of Numbers With Units Digit K.
//Memory Usage: 63.2 MB, less than 100.00% of Scala online submissions for Sum of Numbers With Units Digit K.