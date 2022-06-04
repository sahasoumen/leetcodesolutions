package com.soumen.leetcodesolutions
package hard.nqueens

/**
 * <a href="https://leetcode.com/problems/n-queens/">
 * 51. N-Queens
 * </a>
 * */
object NQueens2 extends App {
  def solveNQueens(n: Int): List[List[String]] = {
    def diagolanCheck(board: Iterator[Int]) = board.zipWithIndex.map { case (queenPosition, row) => queenPosition - row }.distinct.length == n

    (0 until n).permutations.filter(board => diagolanCheck(board.iterator) && diagolanCheck(board.reverseIterator))
      .map(_.map(queenPosition => ("." * n).updated(queenPosition, 'Q')).toList).toList
  }
}
//Runtime: 889 ms, faster than 57.14% of Scala online submissions for N-Queens.
//Memory Usage: 55.3 MB, less than 85.71% of Scala online submissions for N-Queens.