package com.soumen.leetcodesolutions
package simple.baseballgame

/**
 * https://leetcode.com/problems/baseball-game/
 * 682. Baseball Game
 */
object BaseballGame2 extends App {
  def calPoints(ops: Array[String]): Int = {
    @scala.annotation.tailrec
    def calPoints(pos: Int = 0, result: Seq[Int] = Nil): Int = if (pos == ops.length) result.sum else ops(pos) match {
      case "+" => calPoints(pos + 1, result :+ (result.last + result.init.last))
      case "C" => calPoints(pos + 1, result.init)
      case "D" => calPoints(pos + 1, result :+ result.last * 2)
      case c => calPoints(pos + 1, result :+ c.toInt)
    }

    calPoints()
  }
}

//Runtime: 1020 ms, faster than 6.38% of Scala online submissions for Baseball Game.
//Memory Usage: 85 MB, less than 6.38% of Scala online submissions for Baseball Game.
