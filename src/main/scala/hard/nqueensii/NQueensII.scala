package com.soumen.leetcodesolutions
package hard.nqueensii


/**
 * <a href="https://leetcode.com/problems/n-queens-ii/">
 * 52. N-Queens II
 * </a>
 * */
object NQueensII extends App {
  def totalNQueens(n: Int): Int = {
    def diagonalCheck(board: Iterator[Int]) = board.zipWithIndex.map { case (col, row) => col - row }.distinct.length == n

    (0 until n).permutations.count(board => diagonalCheck(board.iterator) && diagonalCheck(board.reverseIterator))
  }
}

//Runtime: 1593 ms, faster than 14.29% of Scala online submissions for N-Queens II.
//Memory Usage: 165.6 MB, less than 14.29% of Scala online submissions for N-Queens II.