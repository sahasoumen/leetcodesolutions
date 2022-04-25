package com.soumen.leetcodesolutions
package medium.peekingiterator

// Scala Iterator reference:
// https://www.scala-lang.org/api/2.12.2/scala/collection/Iterator.html

class PeekingIteratorGeneric[A](_iterator: Iterator[A]) {
  var pointer: Option[A] = if (_iterator.hasNext) Some(_iterator.next()) else None

  def peek(): A = pointer.get

  def next(): A = {
    val v = pointer.get
    pointer = if (_iterator.hasNext) Some(_iterator.next()) else None
    v
  }

  def hasNext: Boolean = pointer.isDefined
}

//class PeekingIterator(_iterator: Iterator[Int]) extends PeekingIteratorGeneric[Int](_iterator)

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = new PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */

//Runtime: 817 ms, faster than 33.33% of Scala online submissions for Peeking Iterator.
//Memory Usage: 68.1 MB, less than 66.67% of Scala online submissions for Peeking Iterator.