package com.soumen.leetcodesolutions
package simple.transposematrix

/**
 * <a href="https://leetcode.com/problems/transpose-matrix/">
 * 867. Transpose Matrix
 * </a>
 * */
object TransposeMatrix3 extends App {
  def transpose(matrix: Array[Array[Int]]): Array[Array[Int]] = matrix.transpose

  println(transpose(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))).map(_.toSeq).toSeq)
  println(transpose(Array(Array(1, 2, 3), Array(4, 5, 6))).map(_.toSeq).toSeq)
}
//Runtime: 611 ms, faster than 88.89% of Scala online submissions for Transpose Matrix.
//Memory Usage: 54.2 MB, less than 100.00% of Scala online submissions for Transpose Matrix.