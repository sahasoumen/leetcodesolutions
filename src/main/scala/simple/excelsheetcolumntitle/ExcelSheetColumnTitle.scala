package com.soumen.leetcodesolutions
package simple.excelsheetcolumntitle

object ExcelSheetColumnTitle extends App {
  @scala.annotation.tailrec
  def convertToTitle(columnNumber: Int, title: String = ""): String = if (columnNumber == 0) title else convertToTitle((columnNumber - 1) / 26, ((columnNumber - 1) % 26 + 'A').toChar +: title)

  println(convertToTitle(1))
  println(convertToTitle(28))
  println(convertToTitle(701))
}
//Runtime: 656 ms, faster than 61.54% of Scala online submissions for Excel Sheet Column Title.
//Memory Usage: 62.8 MB, less than 84.62% of Scala online submissions for Excel Sheet Column Title.