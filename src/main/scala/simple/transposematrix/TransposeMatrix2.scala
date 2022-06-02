package com.soumen.leetcodesolutions
package simple.transposematrix

/**
 * <a href="https://leetcode.com/problems/transpose-matrix/">
 * 867. Transpose Matrix
 * </a>
 * */
object TransposeMatrix2 extends App {
  def transpose(matrix: Array[Array[Int]]): Array[Array[Int]] = matrix(0).indices.map(r=> matrix.map(_(r))).toArray

  println(transpose(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))).map(_.toSeq).toSeq)
  println(transpose(Array(Array(1, 2, 3), Array(4, 5, 6))).map(_.toSeq).toSeq)
}
//Runtime: 605 ms, faster than 88.89% of Scala online submissions for Transpose Matrix.
//Memory Usage: 54.3 MB, less than 88.89% of Scala online submissions for Transpose Matrix.