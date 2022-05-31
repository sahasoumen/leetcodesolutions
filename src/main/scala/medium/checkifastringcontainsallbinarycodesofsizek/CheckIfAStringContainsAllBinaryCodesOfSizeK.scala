package com.soumen.leetcodesolutions
package medium.checkifastringcontainsallbinarycodesofsizek

/**
 * <a href = "https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/">
 * 1461. Check If a String Contains All Binary Codes of Size K
 * </a>
 * */
object CheckIfAStringContainsAllBinaryCodesOfSizeK extends App {
  def hasAllCodes(s: String, k: Int): Boolean = (0 until (1 << k)).forall(i => s.contains(i.toBinaryString.padTo(k, '0')))

  println(hasAllCodes(s = "00110110", k = 2))
  println(hasAllCodes(s = "00110110", k = 2))
  println(hasAllCodes(s = "0110", k = 2))
}

//Runtime: 6310 ms, faster than 100.00% of Scala online submissions for Check If a String Contains All Binary Codes of Size K.
//Memory Usage: 56.2 MB, less than 100.00% of Scala online submissions for Check If a String Contains All Binary Codes of Size K.