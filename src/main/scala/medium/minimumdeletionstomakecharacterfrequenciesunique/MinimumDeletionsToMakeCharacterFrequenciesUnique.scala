package com.soumen.leetcodesolutions
package medium.minimumdeletionstomakecharacterfrequenciesunique

/**
 * <a href="https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/">
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * </a>
 * */
object MinimumDeletionsToMakeCharacterFrequenciesUnique extends App {
  def minDeletions(s: String): Int = {
    //Create a priority queue with the count of characters
    val q = scala.collection.mutable.PriorityQueue.from(s.groupBy(identity).map(_._2.length))

    @scala.annotation.tailrec
    def helper(count: Int = 0, frequency: Int = q.dequeue(), hasChanged: Boolean = false): Int =
      if (q.isEmpty) count
      else if (q.head == frequency) helper(count + 1, frequency - 1, hasChanged = true)
      else {
        if (hasChanged && frequency != 0) q.enqueue(frequency)
        helper(count, q.dequeue())
      }


    helper()
  }

  println(minDeletions("aab")) //0
  println(minDeletions("aaabbbcc")) //2
  println(minDeletions("ceabaacb")) //2
}
//Runtime: 1207 ms, faster than 66.67% of Scala online submissions for Minimum Deletions to Make Character Frequencies Unique.
//Memory Usage: 95.2 MB, less than 66.67% of Scala online submissions for Minimum Deletions to Make Character Frequencies Unique.