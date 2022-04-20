package com.soumen.leetcodesolutions
package medium.recoverbst

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 99. Recover Binary Search Tree
 * */
object RecoverBinarySearchTree4 extends App {
  def recoverTree(root: TreeNode): Unit = {
    def swap(n1: TreeNode, n2: TreeNode): Boolean = n1.value match {
      case v => n1.value = n2.value
        n2.value = v
        true
    }

    def allNodes(node: TreeNode): Seq[TreeNode] = if (Option(node).isEmpty) Nil else node +: (allNodes(node.left) ++ allNodes(node.right))

    def isBST(node: TreeNode, min: Long = Long.MinValue, max: Long = Long.MaxValue): Boolean = node == null || (node.value > min && node.value < max && isBST(node.left, min, node.value) && isBST(node.right, node.value, max))

    def findProblem(node: TreeNode, min: Long = Long.MinValue, max: Long = Long.MaxValue): Option[TreeNode] = Option(node) match {
      case None => None
      case Some(n) if n.value < min || n.value > max => Some(n)
      case Some(n) => findProblem(n.left, min, n.value) match {
        case None => findProblem(n.right, n.value, max)
        case c => c
      }
    }

    def swapNCheck(n1: TreeNode, n2: TreeNode) = {
      swap(n1, n2)
      if (isBST(root)) true else {
        swap(n1, n2)
        false
      }
    }

    findProblem(root) match {
      case None =>
      case Some(n1) => allNodes(root).filterNot(n1 == _).find(n2 => swapNCheck(n1, n2))
    }
    if (!isBST(root)) allNodes(root) match {
      case all => all.find(n1 => all.filterNot(n1 == _).exists { n2 => swapNCheck(n1, n2) })
    }
  }

  val tree = TreeNode(4,
    TreeNode(2,
      TreeNode(1, null,
        TreeNode(3)
      )
    )
  )
  println(tree)
  recoverTree(tree)
  println(tree)
}
//Runtime: 1161 ms, faster than 14.29% of Scala online submissions for Recover Binary Search Tree.
//Memory Usage: 90.8 MB, less than 28.57% of Scala online submissions for Recover Binary Search Tree.