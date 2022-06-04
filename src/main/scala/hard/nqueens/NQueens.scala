package com.soumen.leetcodesolutions
package hard.nqueens

/**
 * <a href="https://leetcode.com/problems/n-queens/">
 * 51. N-Queens
 * </a>
 * */
object NQueens extends App {
  def solveNQueens(n: Int): List[List[String]] = {
    def diagolanCheck(board: Seq[Int]) = board.zipWithIndex.map { case (queenPosition, row) => queenPosition - row }.distinct.length == n

    (0 until n).permutations.filter(board => diagolanCheck(board) && diagolanCheck(board.reverse))
      .map(_.map(queenPosition => ("." * n).updated(queenPosition, 'Q')).toList).toList
  }
}
//Runtime: 1332 ms, faster than 28.57% of Scala online submissions for N-Queens.
//Memory Usage: 187.3 MB, less than 7.14% of Scala online submissions for N-Queens.