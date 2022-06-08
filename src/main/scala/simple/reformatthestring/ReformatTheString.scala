package com.soumen.leetcodesolutions
package simple.reformatthestring

object ReformatTheString extends App {
  def reformat(s: String): String = {
    s.foldLeft((0, 0)) { case ((a, d), c) => if (c.isDigit) (a, d + 1) else (a + 1, d) } match {
      case (a, d) if Math.abs(a - d) > 1 => ""
      case (a, d) if a >= d => s.filterNot(_.isDigit).map(_.toString).zipAll(s.filter(_.isDigit), "", "").foldLeft("")((s, t) => s + t._1 + t._2)
      case _ => s.filter(_.isDigit).map(_.toString).zipAll(s.filterNot(_.isDigit), "", "").foldLeft("")((s, t) => s + t._1 + t._2)
    }
  }

  println(reformat("covid2019"))
  println(reformat("covid201921"))
}
//Runtime: 985 ms, faster than 100.00% of Scala online submissions for Reformat The String.
//Memory Usage: 86.2 MB, less than 100.00% of Scala online submissions for Reformat The String.