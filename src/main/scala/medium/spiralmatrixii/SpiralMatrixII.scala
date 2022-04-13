package com.soumen.leetcodesolutions
package medium.spiralmatrixii

object SpiralMatrixII extends App {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val arr = Array.fill(n, n)(0)

    @scala.annotation.tailrec
    def helper(layer: Int = 0, start: Int = 1): Unit = n - 1 - layer * 2 match {
      case x if x < 0 => // break the recursion
      case 0 => arr(layer)(layer) = start
      case c =>
        for {i <- 0 until c} yield arr(layer)(layer + i) = start + i
        for {j <- 0 until c} yield arr(layer + j)(layer + c) = start + c + j
        for {k <- 0 until c} yield arr(layer + c)(layer + c - k) = start + c * 2 + k
        for {l <- 0 until c} yield arr(layer + c - l)(layer) = start + c * 3 + l
        helper(layer + 1, start + c * 4)
    }

    helper()
    arr
  }

  for (x <- generateMatrix(6)) {
    x.foreach(n => print(s"$n\t"))
    println
  }
}

//Runtime: 489 ms, faster than 100.00% of Scala online submissions for Spiral Matrix II.
//Memory Usage: 52.1 MB, less than 100.00% of Scala online submissions for Spiral Matrix II.