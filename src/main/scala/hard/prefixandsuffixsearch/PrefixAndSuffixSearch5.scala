package com.soumen.leetcodesolutions
package hard.prefixandsuffixsearch

/**
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/">
 * 745. Prefix and Suffix Search
 * </a>
 * <p>
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/discuss/527570/Trie-of-tries-add%3A-O(W2)-find%3A-O(W).-Beats-100-of-Scala-solutions-(the-another-one)!">
 * Same as
 * </a>
 * */
class WordFilter5(_words: Array[String]) {
  val data = new Trie5() // create the trie
  _words.zipWithIndex.foreach(w => data.add(w._1, w._2)) // populate the trie

  def f(prefix: String, suffix: String): Int = data.find(prefix, 0, suffix) // find in the trie
}

// the main, prefix based, trie
class Trie5() {
  private val reverse = new TrieReversed() // suffix based trie containing all words in the node
  private val data = Array.fill[Option[Trie5]](26)(None)

  def add(s: String, w: Int, i: Int = 0): Unit = {
    if (i < s.length)
      data(s(i) - 'a').getOrElse {
        val tr = new Trie5
        data(s(i) - 'a') = Some(tr)
        tr
      }.add(s, w, i + 1)

    reverse.add(s, w, s.length - 1) // for every node - add the word to the suffix based trie
  }

  def find(p: String, i: Int, s: String): Int =
    if (i == p.length) reverse.find(s, s.length - 1) // we found all words with the prefix, now filter them by suffix
    else data(p(i) - 'a').map(_.find(p, i + 1, s)).getOrElse(-1)
}

// suffix based trie
class TrieReversed() {
  private val data = Array.fill[Option[TrieReversed]](26)(None)
  private var w: Int = -1 // for every node we store the best weight

  def add(s: String, _w: Int, i: Int): Unit = {
    if (i >= 0)
      data(s(i) - 'a').getOrElse {
        val tr = new TrieReversed()
        data(s(i) - 'a') = Some(tr)
        tr
      }.add(s, _w, i - 1)

    w = _w // actually, there should be `w = w max _w`, but we add the words in the succession, so _w > w always
  }

  def find(s: String, i: Int): Int =
    if (i >= 0) data(s(i) - 'a').map(_.find(s, i - 1)).getOrElse(-1)
    else w
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
object PrefixAndSuffixSearch5 extends App {
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

//Runtime: 3106 ms, faster than 50.00% of Scala online submissions for Prefix and Suffix Search.
//Memory Usage: 235.8 MB, less than 50.00% of Scala online submissions for Prefix and Suffix Search.