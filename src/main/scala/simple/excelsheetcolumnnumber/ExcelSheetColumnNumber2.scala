package com.soumen.leetcodesolutions
package simple.excelsheetcolumnnumber

/**
 * <a href="https://leetcode.com/problems/excel-sheet-column-number/">
 * 171. Excel Sheet Column Number
 * </a>
 * */
object ExcelSheetColumnNumber2 extends App {

  def titleToNumber(columnTitle: String): Int = columnTitle.map(_ - 'A' + 1).reduce(_ * 26 + _)

  println(titleToNumber("A"))
  println(titleToNumber("AB"))
  println(titleToNumber("ZY"))
}

//Runtime: 1014 ms, faster than 7.14% of Scala online submissions for Excel Sheet Column Number.
//Memory Usage: 66.3 MB, less than 50.00% of Scala online submissions for Excel Sheet Column Number.