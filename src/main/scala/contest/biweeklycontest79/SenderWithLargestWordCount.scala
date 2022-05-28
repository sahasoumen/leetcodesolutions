package com.soumen.leetcodesolutions
package contest.biweeklycontest79

import scala.math

/**
 * <a href = "https://leetcode.com/contest/biweekly-contest-79/problems/sender-with-largest-word-count/">
 * 6084. Sender With Largest Word Count
 * </a>
 * */
object SenderWithLargestWordCount extends App {
  def largestWordCount(messages: Array[String], senders: Array[String]): String = {
    senders.zip(messages).groupBy(_._1).toSeq.sortBy { case (name, messages) => messages.flatMap(_._2.split(' ')).length -> name } { (t1, t2) =>
      t2._1.compareTo(t1._1) match {
        case 0 => t2._2.compareTo(t1._2)
        case c => c
      }
    }.head._1
  }

  println(largestWordCount(Array("Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"), Array("Alice", "userTwo", "userThree", "Alice")))
  println(largestWordCount(Array("How is leetcode for everyone", "Leetcode is useful for practice"), Array("Bob", "Charlie")))
}
