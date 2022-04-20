package com.soumen.leetcodesolutions
package medium.bstiterator

class BSTIterator(_root: TreeNode) {
  def all(node: TreeNode): Seq[Int] = if (node == null) Nil else (all(node.left) :+ node.value) ++ all(node.right)

  var allNodes = all(_root)

  def next(): Int = allNodes match {
    case head :: tail =>
      allNodes = tail
      head
  }

  def hasNext: Boolean = allNodes.nonEmpty

}

//Runtime: 684 ms, faster than 85.19% of Scala online submissions for Binary Search Tree Iterator.
//Memory Usage: 61.5 MB, less than 85.19% of Scala online submissions for Binary Search Tree Iterator.