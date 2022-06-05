package com.soumen.leetcodesolutions
package hard.nqueensii

/**
 * <a href="https://leetcode.com/problems/n-queens-ii/">
 * 52. N-Queens II
 * </a>
 * */
object NQueensII2 extends App {
  def totalNQueens(n: Int): Int = {
    def diagonalCheck(board: Seq[Int]) = board.zipWithIndex.map { case (col, row) => col - row }.distinct.length == n

    (0 until n).permutations.count(board => diagonalCheck(board) && diagonalCheck(board.reverse))
  }
}

//Runtime: 1207 ms, faster than 28.57% of Scala online submissions for N-Queens II.
//Memory Usage: 186.2 MB, less than 14.29% of Scala online submissions for N-Queens II.