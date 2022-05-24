package com.soumen.leetcodesolutions
package medium.pattern132

/**
 * <a href="https://leetcode.com/problems/132-pattern/">
 * 456. 132 Pattern
 * </a>
 * */
object Pattern132_2 extends App {
  def find132pattern(nums: Array[Int]): Boolean = {

    @scala.annotation.tailrec
    def findPattern(i: Int = nums.length - 1, n2: Int = Int.MinValue, stack: scala.collection.mutable.Stack[Int] = scala.collection.mutable.Stack.empty[Int]): Boolean =
      if (i < 0) false
      else if (nums(i) < n2) true
      else if (stack.nonEmpty && nums(i) > stack.top) findPattern(i, stack.pop() max n2, stack)
      else findPattern(i - 1, n2, stack.push(nums(i)))

    findPattern()
  }

  println(find132pattern(Array(0, 1, 2, 3)))
  println(find132pattern(Array(3, 1, 4, 2)))
  println(find132pattern(Array(-1, 3, 2, 0)))
}
//Runtime: 826 ms, faster than 76.27% of Scala online submissions for 132 Pattern.
//Memory Usage: 85.1 MB, less than 71.19% of Scala online submissions for 132 Pattern.