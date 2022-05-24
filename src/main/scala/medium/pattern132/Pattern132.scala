package com.soumen.leetcodesolutions
package medium.pattern132

/**
 * <a href="https://leetcode.com/problems/132-pattern/">
 * 456. 132 Pattern
 * </a>
 * */
object Pattern132 extends App {
  def find132pattern(nums: Array[Int]): Boolean = {
    val stack = scala.collection.mutable.Stack.empty[Int]

    @scala.annotation.tailrec
    def findPattern(i: Int = nums.length - 1, n2: Int = Int.MinValue): Boolean =
      if (i < 0) false
      else if (nums(i) < n2) true
      else if (stack.nonEmpty && nums(i) > stack.top) findPattern(i, stack.pop() max n2)
      else {
        stack.push(nums(i))
        findPattern(i - 1, n2)
      }

    findPattern()
  }

  println(find132pattern(Array(0, 1, 2, 3)))
  println(find132pattern(Array(3, 1, 4, 2)))
  println(find132pattern(Array(-1, 3, 2, 0)))
}
//Runtime: 1054 ms, faster than 54.24% of Scala online submissions for 132 Pattern.
//Memory Usage: 106 MB, less than 42.37% of Scala online submissions for 132 Pattern.