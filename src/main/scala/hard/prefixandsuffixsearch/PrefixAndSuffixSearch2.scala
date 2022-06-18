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
  val wordFilter = new WordFilter2(Array("apple", "aple"))
  println(wordFilter.f("a", "e"))
}

//Time Limit Exceeded