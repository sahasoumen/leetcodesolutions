package com.soumen.leetcodesolutions
package medium.peekingiterator

// Scala Iterator reference:
// https://www.scala-lang.org/api/2.12.2/scala/collection/Iterator.html

class PeekingIterator(_iterator: Iterator[Int]) {
  var pointer: Option[Int] = if (_iterator.hasNext) Some(_iterator.next()) else None

  def peek(): Int = pointer.get

  def next(): Int = pointer match {
    case None => _iterator.next() //Just to throw same Exception
    case Some(v) => pointer = if (_iterator.hasNext) Some(_iterator.next()) else None
      v
  }

  def hasNext: Boolean = pointer.isDefined
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = new PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */

//Runtime: 799 ms, faster than 33.33% of Scala online submissions for Peeking Iterator.
//Memory Usage: 67.9 MB, less than 66.67% of Scala online submissions for Peeking Iterator.