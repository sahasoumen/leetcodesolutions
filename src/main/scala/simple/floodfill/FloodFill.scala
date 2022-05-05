package com.soumen.leetcodesolutions
package simple.floodfill

/**
 * https://leetcode.com/problems/flood-fill/
 * 733. Flood Fill
 * */
object FloodFill extends App {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = image(sr)(sc) match {
    case originalColor =>
      if (originalColor != newColor) {
        image(sr)(sc) = newColor
        Seq((sc - 1, sr), (sc + 1, sr), (sc, sr - 1), (sc, sr + 1))
          .filter { case (x, y) => x >= 0 && x < image(0).length && y >= 0 && y < image.length && image(y)(x) == originalColor }
          .foreach { case (x, y) => floodFill(image, y, x, newColor) }
      }
      image
  }

  //  println(floodFill(Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1)), 1, 1, 2).toSeq.map(_.toSeq))
  println(floodFill(Array(Array(0, 0, 0), Array(0, 1, 0)), 0, 0, 2).toSeq.map(_.toSeq))
}
//Runtime: 796 ms, faster than 65.71% of Scala online submissions for Flood Fill.
//Memory Usage: 76.6 MB, less than 34.29% of Scala online submissions for Flood Fill.