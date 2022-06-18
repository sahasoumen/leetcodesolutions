package com.soumen.leetcodesolutions
package hard.prefixandsuffixsearch

/**
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/">
 * 745. Prefix and Suffix Search
 * </a>
 * */
class WordFilter3(_words: Array[String]) {
  val dict = _words.zipWithIndex.map { case (s, i) => s"${s.head}#${s.last}" -> (s -> i) }.groupBy(_._1).view.mapValues(_.map(_._2))

  def f(prefix: String, suffix: String): Int = dict get s"${prefix.head}#${suffix.last}" match {
    case Some(seq) => seq.filter { case (s, _) => s.startsWith(prefix) && s.substring(s.length-suffix.length) == suffix }.sortBy(_._1)(Ordering.String.reverse).headOption match {
      case Some((_, i)) => i
      case None => -1
    }
    case None => -1
  }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
object PrefixAndSuffixSearch3 extends App {
  val wordFilter = new WordFilter3(Array("apple", "aple"))
  println(wordFilter.f("a", "e"))
}

//Time Limit Exceeded