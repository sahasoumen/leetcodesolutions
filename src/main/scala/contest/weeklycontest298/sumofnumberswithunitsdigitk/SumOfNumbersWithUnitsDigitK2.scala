package com.soumen.leetcodesolutions
package contest.weeklycontest298.sumofnumberswithunitsdigitk

/**
 * <a href="https://leetcode.com/contest/weekly-contest-298/problems/sum-of-numbers-with-units-digit-k/">
 * 5218. Sum of Numbers With Units Digit K
 * </a>
 * */
object SumOfNumbersWithUnitsDigitK2 extends App {
  def minimumNumbers(num: Int, k: Int): Int = if (num == 0) 0 else {
    val dp = Array.fill(num + 1)(Int.MaxValue)
    dp(0) = 0
    val validNumbers = (1 to num).filter(_ % 10 == k)
    for (i <- 1 to num; n <- validNumbers if n <= i && dp(i - n) != Int.MaxValue)
      dp(i) = (dp(i - n) + 1) min dp(i)

    if (dp(num) == Int.MaxValue) -1 else dp(num)
  }

  println(minimumNumbers(58, 9)) //2
  println(minimumNumbers(37, 2)) //-1
  println(minimumNumbers(0, 7)) //0
  println(minimumNumbers(1, 1)) //1
  println(minimumNumbers(5, 1)) //5
  println(minimumNumbers(19, 3)) //3
  println(minimumNumbers(2, 8)) //-1
}
//Runtime: 1068 ms, faster than 100.00% of Scala online submissions for Sum of Numbers With Units Digit K.
//Memory Usage: 84.1 MB, less than 100.00% of Scala online submissions for Sum of Numbers With Units Digit K.