package com.soumen.leetcodesolutions
package hard.prefixandsuffixsearch

/**
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/">
 * 745. Prefix and Suffix Search
 * </a>
 * <p>
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/discuss/527570/Trie-of-tries-add%3A-O(W2)-find%3A-O(W).-Beats-100-of-Scala-solutions-(the-another-one)!">
 * Copy of
 * </a>
 * */
class ReverseTrie() {
  val data = Array.fill[Option[ReverseTrie]](26)(None)
  var index: Int = -1

  def add(word: String, ind: Int, i: Int): Unit = {
    if (i >= 0) data(word(i) - 'a').getOrElse {
      val rt = new ReverseTrie
      data(word(i) - 'a') = Some(rt)
      rt
    }.add(word, ind, i - 1)
    this.index = ind
  }


  def find(suffix: String, i: Int): Int = if (i >= 0) data(suffix(i) - 'a').map(_.find(suffix, i - 1)).getOrElse(-1) else index
}

class Trie() {
  val data = Array.fill[Option[Trie]](26)(None)
  val reverse = new ReverseTrie

  def add(word: String, index: Int, i: Int = 0): Unit = {
    if (i < word.length) data(word(i) - 'a').getOrElse {
      val tr = new Trie
      data(word(i) - 'a') = Some(tr)
      tr
    }.add(word, index, i + 1)
    reverse.add(word, index, word.length - 1)
  }

  def find(prefix: String, suffix: String, i: Int = 0): Int =
    if (i == prefix.length) reverse.find(suffix, suffix.length - 1)
    else data(prefix(i) - 'a').map(_.find(prefix, suffix, i + 1)).getOrElse(-1)
}

class WordFilter4(_words: Array[String]) {
  val trie = new Trie
  _words.zipWithIndex.foreach { case (word, index) => trie.add(word, index) }

  def f(prefix: String, suffix: String): Int = trie.find(prefix, suffix)
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
object PrefixAndSuffixSearch4 extends App {
  val wordFilter = new WordFilter5(Array("cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"))
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

//Runtime: 1644 ms, faster than 100.00% of Scala online submissions for Prefix and Suffix Search.
//Memory Usage: 102.2 MB, less than 100.00% of Scala online submissions for Prefix and Suffix Search.