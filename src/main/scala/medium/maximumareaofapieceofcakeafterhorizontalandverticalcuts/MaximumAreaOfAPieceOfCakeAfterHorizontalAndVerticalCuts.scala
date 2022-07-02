package com.soumen.leetcodesolutions
package medium.maximumareaofapieceofcakeafterhorizontalandverticalcuts

/**
 * <a href="https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/">
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * </a>
 * */
object MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts extends App {
  def maxArea(h: Int, w: Int, horizontalCuts: Array[Int], verticalCuts: Array[Int]): Int = {
    def maxPiece(cuts: Array[Int], last: Int): Long = (cuts.sorted :+ last).foldLeft((0, 0)) { case ((start, max), nextCut) => (nextCut, max max (nextCut - start)) }._2

    (maxPiece(horizontalCuts, h) * maxPiece(verticalCuts, w) % 1_000_000_007).toInt
  }

  println(maxArea(h = 5, w = 4, horizontalCuts = Array(1, 2, 4), verticalCuts = Array(1, 3))) //4
  println(maxArea(h = 5, w = 4, horizontalCuts = Array(3, 1), verticalCuts = Array(1))) //6
  println(maxArea(h = 5, w = 4, horizontalCuts = Array(3), verticalCuts = Array(3))) //9
  println(maxArea(h = 1000000000, w = 1000000000, horizontalCuts = Array(2), verticalCuts = Array(2))) //81
}
//Runtime: 1038 ms, faster than 100.00% of Scala online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
//Memory Usage: 93.1 MB, less than 100.00% of Scala online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.