package com.soumen.leetcodesolutions
package hard.prefixandsuffixsearch

/**
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/">
 * 745. Prefix and Suffix Search
 * </a>
 * */
class WordFilter(_words: Array[String]) {
  def merge(p: String, s: String) = s"$p#$s"

  def allCombinations(s: String): Seq[String] = s.tail.scanLeft(s.head.toString)(_ + _) match {
    case prefixes => s.init.scanRight(s.last.toString)(_ + _) match {
      case suffixes => prefixes.flatMap(p => suffixes.map(s => merge(p, s)))
    }
  }

  val dict = _words.zipWithIndex.flatMap { case (s, i) => allCombinations(s).map(_ -> (s -> i)) }.groupBy(_._1).view.mapValues(_.toSeq.map(_._2).sortBy(_._1)(Ordering.String.reverse).map(_._2))

  def f(prefix: String, suffix: String): Int = dict.getOrElse(merge(prefix, suffix), Seq(-1)).head

}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
object PrefixAndSuffixSearch extends App {
  val wordFilter = new WordFilter(Array("apple", "aple"))
  println(wordFilter.f("a", "e"))
}

//Time Limit Exceeded