package com.soumen.leetcodesolutions
package medium.spiralmatrixii

object SpiralMatrixII2 extends App {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val arr = Array.fill(n, n)(0)

    @scala.annotation.tailrec
    def helper(layer: Int = 0, start: Int = 1): Unit = n - 1 - layer * 2 match {
      case x if x < 0 => // break the recursion
      case 0 => arr(layer)(layer) = start
      case c =>
        (0 until c).foreach { i =>
          arr(layer)(layer + i) = start + i
          arr(layer + i)(layer + c) = start + c + i
          arr(layer + c)(layer + c - i) = start + c * 2 + i
          arr(layer + c - i)(layer) = start + c * 3 + i
        }
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

//Runtime: 461 ms, faster than 100.00% of Scala online submissions for Spiral Matrix II.
//Memory Usage: 51.8 MB, less than 100.00% of Scala online submissions for Spiral Matrix II.