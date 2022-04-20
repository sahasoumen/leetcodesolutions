package com.soumen.leetcodesolutions
package medium.bstiterator

class BSTIterator2(_root: TreeNode) {
  def all(node: TreeNode): Seq[TreeNode] = if (node == null) Nil else (all(node.left) :+ node) ++ all(node.right)

  var allNodes = all(_root)

  def next(): Int = allNodes match {
    case head :: tail =>
      allNodes = tail
      head.value
  }

  def hasNext: Boolean = allNodes.nonEmpty

}

//Runtime: 962 ms, faster than 85.19% of Scala online submissions for Binary Search Tree Iterator.
//Memory Usage: 91.9 MB, less than 25.93% of Scala online submissions for Binary Search Tree Iterator.