package com.soumen.leetcodesolutions
package medium.bstiterator

class BSTIterator3(_root: TreeNode) {
  val q = scala.collection.mutable.Queue[Int]()

  def all(node: TreeNode = _root): Unit = if (node != null) {
    all(node.left)
    q.enqueue(node.value)
    all(node.right)
  }

  def next = q.dequeue()

  def hasNext = q.nonEmpty

  all()
}

//Runtime: 1295 ms, faster than 37.04% of Scala online submissions for Binary Search Tree Iterator.
//Memory Usage: 86 MB, less than 62.96% of Scala online submissions for Binary Search Tree Iterator.