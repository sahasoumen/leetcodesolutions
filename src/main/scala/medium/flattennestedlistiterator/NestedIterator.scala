package com.soumen.leetcodesolutions
package medium.flattennestedlistiterator

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * 341. Flatten Nested List Iterator
 * */
class NestedIterator(_nestedList: List[NestedInteger]) {
  val q = scala.collection.mutable.Queue.empty[Int]

  def flatten(list: List[NestedInteger] = _nestedList): Unit = list match {
    case Nil =>
    case head :: tail if head.isInteger => q.enqueue(head.getInteger)
      flatten(tail)
    case head :: tail => flatten(head.getList.toList)
      flatten(tail)
  }

  flatten()

  def next(): Int = q.dequeue()

  def hasNext(): Boolean = q.nonEmpty
}

//Runtime: 885 ms, faster than 50.00% of Scala online submissions for Flatten Nested List Iterator.
//Memory Usage: 81.2 MB, less than 16.67% of Scala online submissions for Flatten Nested List Iterator.