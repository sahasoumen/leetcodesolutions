package com.soumen.leetcodesolutions
package medium.peekingiterator

// Scala Iterator reference:
// https://www.scala-lang.org/api/2.12.2/scala/collection/Iterator.html

class PeekingIterator2(_iterator: Iterator[Int]) {
  var pointer: Int = if (_iterator.hasNext) _iterator.next() else Int.MinValue

  def peek(): Int = pointer

  def next(): Int = pointer match {
    case v => pointer = if (_iterator.hasNext) _iterator.next() else Int.MinValue
      v
  }

  def hasNext: Boolean = pointer != Int.MinValue
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = new PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */

//Runtime: 748 ms, faster than 33.33% of Scala online submissions for Peeking Iterator.
//Memory Usage: 68 MB, less than 66.67% of Scala online submissions for Peeking Iterator.