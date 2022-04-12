package com.soumen.leetcodesolutions
package simple.baseballgame

object BaseballGame extends App {
  def calPoints(ops: Array[String]): Int = {
    @scala.annotation.tailrec
    def calPoints(ops: Seq[String], result: Seq[Int] = Nil): Int = ops.toList match {
      case Nil => result.sum
      case head :: tail => head match {
        case "+" => calPoints(tail, result :+ (result.last + result.init.last))
        case "C" => calPoints(tail, result.init)
        case "D" => calPoints(tail, result :+ result.last * 2)
        case c => calPoints(tail, result :+ c.toInt)
      }
    }

    calPoints(ops.toList)
  }
}
//Runtime: 1025 ms
//Memory Usage: 84.5 MB