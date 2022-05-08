package com.soumen.leetcodesolutions
package medium.flattennestedlistiterator

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * 341. Flatten Nested List Iterator
 * */
class NestedIterator2(_nestedList: List[NestedInteger]) {

  def flatten(list: List[NestedInteger] = _nestedList, acc: LazyList[Int] = LazyList.empty): LazyList[Int] = list match {
    case Nil => acc
    case head :: tail if head.isInteger => flatten(tail, acc :+ head.getInteger)
    case head :: tail => flatten(tail, flatten(head.getList.toList, acc))
  }

  var l = flatten()

  def next(): Int = l.head match {
    case n => l = l.tail; n
  }

  def hasNext(): Boolean = l.nonEmpty
}

//Runtime: 5739 ms, faster than 16.67% of Scala online submissions for Flatten Nested List Iterator.
//Memory Usage: 731.6 MB, less than 16.67% of Scala online submissions for Flatten Nested List Iterator.