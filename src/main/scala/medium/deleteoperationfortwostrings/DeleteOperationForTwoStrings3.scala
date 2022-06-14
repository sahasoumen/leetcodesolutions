package com.soumen.leetcodesolutions
package medium.deleteoperationfortwostrings

/**
 * <a href="https://leetcode.com/problems/delete-operation-for-two-strings/">
 * 583. Delete Operation for Two Strings
 * </a>
 * */
object DeleteOperationForTwoStrings3 extends App {
  def minDistance(word1: String, word2: String): Int = {
    val dp: Array[Array[Int]] = Array.ofDim(word1.length + 1, word2.length + 1)
    for (i <- word1.indices; j <- word2.indices)
      dp(i + 1)(j + 1) = if (word1(i) == word2(j)) 1 + dp(i)(j) else dp(i)(j + 1) max dp(i + 1)(j)

    word1.length + word2.length - 2 * dp(word1.length)(word2.length)
  }

  println(minDistance("sea", "eat"))
  println(minDistance("leetcode", "etco"))
}
//Runtime: 972 ms, faster than 50.00% of Scala online submissions for Delete Operation for Two Strings.
//Memory Usage: 73.9 MB, less than 80.00% of Scala online submissions for Delete Operation for Two Strings.