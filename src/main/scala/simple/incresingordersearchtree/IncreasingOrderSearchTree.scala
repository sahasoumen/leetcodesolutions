package com.soumen.leetcodesolutions
package simple.incresingordersearchtree

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 * 897. Increasing Order Search Tree
 * */
object IncreasingOrderSearchTree extends App {

  def increasingBST(root: TreeNode): TreeNode = {
    def allNodes(node: TreeNode): Seq[TreeNode] = if (node == null) Nil else (allNodes(node.left) :+ node) ++ allNodes(node.right)

    def convert(all: Seq[TreeNode]): TreeNode = all match {
      case head :: Nil => head
      case head :: tail =>
        head.left = null
        head.right = convert(tail)
        head
    }
    //    println(allNodes(root).map(_.value))
    convert(allNodes(root))
  }

  val root = TreeNode(2,
    TreeNode(1),
    TreeNode(4,
      TreeNode(3)
    )
  )
  println(increasingBST(root))
}
//Memory Limit Exceeded