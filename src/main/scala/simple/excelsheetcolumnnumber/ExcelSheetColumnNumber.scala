package com.soumen.leetcodesolutions
package simple.excelsheetcolumnnumber

object ExcelSheetColumnNumber extends App {
  @scala.annotation.tailrec
  def titleToNumber(columnTitle: String, n: Int = 0): Int = if (columnTitle.isEmpty) n else titleToNumber(columnTitle.tail, n + Math.pow('Z' - 'A' + 1, columnTitle.length - 1).toInt * (columnTitle.head - 'A' + 1))

  println(titleToNumber("A"))
  println(titleToNumber("AB"))
  println(titleToNumber("ZY"))
}

//Runtime: 851 ms, faster than 21.43% of Scala online submissions for Excel Sheet Column Number.
//Memory Usage: 66 MB, less than 85.71% of Scala online submissions for Excel Sheet Column Number.