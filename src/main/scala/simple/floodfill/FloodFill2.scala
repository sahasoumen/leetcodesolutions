package com.soumen.leetcodesolutions
package simple.floodfill

/**
 * https://leetcode.com/problems/flood-fill/
 * 733. Flood Fill
 * */
object FloodFill2 extends App {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = image(sr)(sc) match {
    case originalColor =>
      def isValid(x: Int, y: Int) = x >= 0 && x < image(0).length && y >= 0 && y < image.length && image(y)(x) == originalColor

      if (originalColor != newColor) {
        image(sr)(sc) = newColor
        if (isValid(sc - 1, sr)) floodFill(image, sr, sc - 1, newColor)
        if (isValid(sc + 1, sr)) floodFill(image, sr, sc + 1, newColor)
        if (isValid(sc, sr - 1)) floodFill(image, sr - 1, sc, newColor)
        if (isValid(sc, sr + 1)) floodFill(image, sr + 1, sc, newColor)
      }
      image
  }

  println(floodFill(Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1)), 1, 1, 2).toSeq.map(_.toSeq))
  println(floodFill(Array(Array(0, 0, 0), Array(0, 1, 0)), 0, 0, 2).toSeq.map(_.toSeq))
}
//Runtime: 846 ms, faster than 55.71% of Scala online submissions for Flood Fill.
//Memory Usage: 78.6 MB, less than 8.57% of Scala online submissions for Flood Fill.