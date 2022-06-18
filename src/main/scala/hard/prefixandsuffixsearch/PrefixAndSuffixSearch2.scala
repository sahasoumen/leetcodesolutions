package com.soumen.leetcodesolutions
package hard.prefixandsuffixsearch

/**
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/">
 * 745. Prefix and Suffix Search
 * </a>
 * */
class WordFilter2(_words: Array[String]) {
  val withIndex = _words.zipWithIndex
  def f(prefix: String, suffix: String): Int = withIndex.filter { case (s, _) => s.startsWith(prefix) && s.reverse.startsWith(suffix.reverse) }.sortBy(_._1)(Ordering.String.reverse).map(_._2).headOption.getOrElse(-1)
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
object PrefixAndSuffixSearch2 extends App {
  val wordFilter = new WordFilter2(Array("cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"))
  println(wordFilter.f("bccbacbcba", "a")) //9
  println(wordFilter.f("ab", "abcaccbcaa")) //4
  println(wordFilter.f("a", "aa")) //5
  println(wordFilter.f("cabaaba", "abaaaa")) //0
  println(wordFilter.f("cacc", "accbbcbab")) //8
  println(wordFilter.f("ccbcab", "bac")) //1
  println(wordFilter.f("bac", "cba")) //2
  println(wordFilter.f("ac", "accabaccaa")) //5
  println(wordFilter.f("bcbb", "aa")) //3
  println(wordFilter.f("ccbca", "cbcababac")) //1
}

//Time Limit Exceeded