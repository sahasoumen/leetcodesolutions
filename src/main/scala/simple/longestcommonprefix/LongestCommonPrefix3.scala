package com.soumen.leetcodesolutions
package simple.longestcommonprefix

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">
 * 14. Longest Common Prefix
 * </a>
 * */
object LongestCommonPrefix3 extends App {
  def longestCommonPrefix(strs: Array[String]): String = if(strs.length==1)strs.head else strs.max.zip(strs.min).takeWhile(t => t._1 == t._2).map(_._1).mkString

  println(longestCommonPrefix(Array("flower", "flow", "flight")))
  println(longestCommonPrefix(Array("dog", "racecar", "car")))
}
//Runtime: 647 ms, faster than 83.03% of Scala online submissions for Longest Common Prefix.
//Memory Usage: 53.8 MB, less than 84.24% of Scala online submissions for Longest Common Prefix.