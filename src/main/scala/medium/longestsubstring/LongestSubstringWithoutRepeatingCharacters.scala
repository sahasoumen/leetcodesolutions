package com.soumen.leetcodesolutions
package medium.longestsubstring

object LongestSubstringWithoutRepeatingCharacters extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    @scala.annotation.tailrec
    def containsDuplicate(s: Seq[_]): Boolean = s match {
      case _ :: Nil => false
      case head :: tail => if (tail.contains(head)) true else containsDuplicate(tail)
    }

    def safeMax(s: Seq[Int]) = if (s.isEmpty) 0 else s.max

    @scala.annotation.tailrec
    def partSubStrings(s: Seq[_], result: Seq[Int] = Nil): Int = s match {
      case Nil => safeMax(result)
      case _ => partSubStrings(s.init, if (containsDuplicate(s)) result else result :+ s.size)
    }

    @scala.annotation.tailrec
    def allSubstrings(s: Seq[_], result: Seq[Int] = Nil): Int = s match {
      case Nil => safeMax(result)
      case _ => allSubstrings(s.tail, result :+ partSubStrings(s))
    }

    allSubstrings(s.toList)
  }
}

/** Memory Limit Exceeded */