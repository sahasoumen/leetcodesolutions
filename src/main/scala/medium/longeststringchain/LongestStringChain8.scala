package com.soumen.leetcodesolutions
package medium.longeststringchain

import scala.collection.mutable

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">
 * 1048. Longest String Chain
 * </a>
 * */
object LongestStringChain8 extends App {
  def longestStrChain(words: Array[String]): Int = {

    def isSuccessor(p: String, s: String) = p.length + 1 == s.length && s.indices.exists(i => new mutable.StringBuilder(s).deleteCharAt(i).toString == p)

    words.sortBy(_.length).foldLeft((0, Map.empty[String, Int], Map.empty[Int, Seq[String]])) { case ((max, dp, wordLenMap), word) =>
      val m = wordLenMap.getOrElse(word.length - 1, Nil).filter(isSuccessor(_, word)).map(dp(_)).maxOption.getOrElse(0) + 1
      (m max max, dp + (word -> m), wordLenMap.filter(_._1 >= word.length - 1) + (word.length -> (wordLenMap.getOrElse(word.length, Nil) :+ word)))
    }._1
  }

  println(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")))
  println(longestStrChain(Array("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
  println(longestStrChain(Array("abcd", "dbqca")))
  println(longestStrChain(Array("a", "ab", "ac", "bd", "abc", "abd", "abdd")))
}
//Runtime: 2469 ms, faster than 7.14% of Scala online submissions for Longest String Chain.
//Memory Usage: 214.3 MB, less than 14.29% of Scala online submissions for Longest String Chain.