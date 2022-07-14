package com.soumen.leetcodesolutions
package binarytreelevelordertraversal

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">
 * 102. Binary Tree Level Order Traversal
 * </a>
 * */
object BinaryTreeLevelOrderTraversal2 extends App {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    def bfs(nodes: List[TreeNode] = Option(root).toList): List[List[Int]] =
      if (nodes.isEmpty) Nil
      else List(nodes.map(_.value)) ++ bfs(nodes.flatMap(node => List(Option(node.left), Option(node.right)).flatten))

    bfs()
  }

  println(levelOrder(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))))) //[[3],[9,20],[15,7]]
  println(levelOrder(TreeNode(1))) //[[1]]
  println(levelOrder(null)) //[]

}
//Runtime: 586 ms, faster than 92.86% of Scala online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 55.7 MB, less than 85.71% of Scala online submissions for Binary Tree Level Order Traversal.