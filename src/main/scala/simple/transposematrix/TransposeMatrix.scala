package com.soumen.leetcodesolutions
package simple.transposematrix

/**
 * <a href="https://leetcode.com/problems/transpose-matrix/">
 * 867. Transpose Matrix
 * </a>
 * */
object TransposeMatrix extends App {
  def transpose(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val t = Array.ofDim[Int](matrix(0).length, matrix.length)
    for (j <- matrix.indices; i <- matrix(0).indices) t(i)(j) = matrix(j)(i)
    t
  }

  println(transpose(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))).map(_.toSeq).toSeq)
  println(transpose(Array(Array(1, 2, 3), Array(4, 5, 6))).map(_.toSeq).toSeq)
}
//Runtime: 942 ms, faster than 33.33% of Scala online submissions for Transpose Matrix.
//Memory Usage: 82.3 MB, less than 44.44% of Scala online submissions for Transpose Matrix.