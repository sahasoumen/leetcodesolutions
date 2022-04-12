package com.soumen.leetcodesolutions
package simple.baseballgame

object BaseballGame3 extends App {
  def calPoints(ops: Array[String]): Int = {
    @scala.annotation.tailrec
    def calPoints(pos: Int = 0, result: Seq[Int] = Nil): Int = if (pos == ops.length) result.sum else ops(pos) match {
      case "+" => calPoints(pos + 1, (result.head + result.tail.head) +: result)
      case "C" => calPoints(pos + 1, result.tail)
      case "D" => calPoints(pos + 1, result.head * 2 +: result)
      case c => calPoints(pos + 1, c.toInt +: result)
    }

    calPoints()
  }
}

//Runtime: 456 ms, faster than 100.00% of Scala online submissions for Baseball Game.
//Memory Usage: 52.7 MB, less than 100.00% of Scala online submissions for Baseball Game.
