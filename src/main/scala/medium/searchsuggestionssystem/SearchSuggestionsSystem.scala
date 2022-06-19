package com.soumen.leetcodesolutions
package medium.searchsuggestionssystem

/**
 * <a href="https://leetcode.com/problems/search-suggestions-system/">
 * 1268. Search Suggestions System
 * </a>
 * */
object SearchSuggestionsSystem extends App {
  def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] = products.sorted match {
    case sorted => searchWord.scanLeft("")(_ + _).tail.map(word => sorted.filter(_ startsWith word).take(3).toList).toList
  }

  println(suggestedProducts(Array("mobile", "mouse", "moneypot", "monitor", "mousepad"), "mouse"))
  println(suggestedProducts(Array("havana"), "havana"))
  println(suggestedProducts(Array("bags", "baggage", "banner", "box", "cloths"), "bags"))
}
//Runtime: 1527 ms, faster than 100.00% of Scala online submissions for Search Suggestions System.
//Memory Usage: 124.4 MB, less than 100.00% of Scala online submissions for Search Suggestions System.