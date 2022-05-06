package com.soumen.leetcodesolutions
package medium.removekduplicates

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * 1209. Remove All Adjacent Duplicates in String II
 * */
object Solution extends App {
  @scala.annotation.tailrec
  def removeDuplicates(s: String, k: Int, pos: Int = 0, count: Int = 0, last: Char = 0): String =
    if (count == k) removeDuplicates(s.substring(0, pos - k) + s.substring(pos), k)
    else if (pos >= s.length) s
    else if (s.charAt(pos) == last) removeDuplicates(s, k, pos + 1, count + 1, last)
    else removeDuplicates(s, k, pos + 1, 1, s.charAt(pos))

  println(removeDuplicates("abcd", 2))
  println(removeDuplicates("deeedbbcccbdaa", 3))
  println(removeDuplicates("pbbcggttciiippooaais", 2))
  println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4))

}

//Runtime: 5305 ms, faster than 16.67% of Scala online submissions for Remove All Adjacent Duplicates in String II.
//Memory Usage: 731.2 MB, less than 16.67% of Scala online submissions for Remove All Adjacent Duplicates in String II.