package com.soumen.leetcodesolutions
package simple.excelsheetcolumntitle

object ExcelSheetColumnTitle2 extends App {

  def convertToTitle(columnNumber: Int): String = if (columnNumber == 0) "" else convertToTitle((columnNumber - 1) / 26) :+ ((columnNumber - 1) % 26 + 'A').toChar

  println(convertToTitle(1))
  println(convertToTitle(28))
  println(convertToTitle(701))
}
//Runtime: 751 ms, faster than 15.38% of Scala online submissions for Excel Sheet Column Title.
//Memory Usage: 62.5 MB, less than 100.00% of Scala online submissions for Excel Sheet Column Title.