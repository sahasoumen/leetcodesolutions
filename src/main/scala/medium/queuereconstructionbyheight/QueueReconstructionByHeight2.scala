package com.soumen.leetcodesolutions
package medium.queuereconstructionbyheight

/**
 * <a href = "https://leetcode.com/problems/queue-reconstruction-by-height/">
 * 406. Queue Reconstruction by Height
 * </a>
 * */


object QueueReconstructionByHeight2 extends App {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] =
    people.sortBy(arr => -arr.head -> arr.last).foldLeft(scala.collection.mutable.ListBuffer[Array[Int]]()) { (res, p) =>
      res.insert(p.last, p)
      res
    }.toArray


  println(reconstructQueue(Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))).map(_.toSeq).toSeq) //[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
  println(reconstructQueue(Array(Array(6, 0), Array(5, 0), Array(4, 0), Array(3, 2), Array(2, 2), Array(1, 4))).map(_.toSeq).toSeq) //[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
}
//Runtime: 649 ms, faster than 100.00% of Scala online submissions for Queue Reconstruction by Height.
//Memory Usage: 55.5 MB, less than 100.00% of Scala online submissions for Queue Reconstruction by Height.