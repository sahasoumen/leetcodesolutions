package com.soumen.leetcodesolutions
package simple.validanagram

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">
 * 242. Valid Anagram
 * </a>
 * */
object ValidAnagram3 extends App {
    def isAnagram(s: String, t: String): Boolean = s.groupBy(identity) == t.groupBy(identity)

  println(isAnagram("abc", "bca"))
}
//Runtime: 850 ms, faster than 55.93% of Scala online submissions for Valid Anagram.
//Memory Usage: 74.5 MB, less than 23.73% of Scala online submissions for Valid Anagram.