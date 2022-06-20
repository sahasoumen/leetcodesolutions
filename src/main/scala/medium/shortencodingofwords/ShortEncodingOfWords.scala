package com.soumen.leetcodesolutions
package medium.shortencodingofwords

/**
 * <a href="https://leetcode.com/problems/short-encoding-of-words/">
 * 820. Short Encoding of Words
 * </a>
 * */
object ShortEncodingOfWords extends App {
  def minimumLengthEncoding(words: Array[String]): Int = words.distinct match {
    case distinctWords => distinctWords.foldLeft(0)((len, word) => if (distinctWords.exists(w => w != word && w.endsWith(word))) len else len + word.length + 1)
  }

  println(minimumLengthEncoding(Array("time", "me", "bell")))
  println(minimumLengthEncoding(Array("t")))
  println(minimumLengthEncoding(Array("time", "time", "time", "time")))
}
//Runtime: 1768 ms, faster than 100.00% of Scala online submissions for Short Encoding of Words.
//Memory Usage: 75.2 MB, less than 100.00% of Scala online submissions for Short Encoding of Words.