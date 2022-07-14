package com.soumen.leetcodesolutions
package binarytreelevelordertraversal


/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">
 * 102. Binary Tree Level Order Traversal
 * </a>
 * */
object BinaryTreeLevelOrderTraversal extends App {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    @scala.annotation.tailrec
    def bfs(nodes: List[TreeNode] = Option(root).toList, result: List[List[Int]] = Nil): List[List[Int]] =
      if (nodes.isEmpty) result
      else bfs(nodes.flatMap(node => List(Option(node.left), Option(node.right)).flatten), result ++ List(nodes.map(_.value)))

    bfs()
  }

  println(levelOrder(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))))) //[[3],[9,20],[15,7]]
  println(levelOrder(TreeNode(1))) //[[1]]
  println(levelOrder(null)) //[]

}
//Runtime: 829 ms, faster than 63.09% of Scala online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 78 MB, less than 15.48% of Scala online submissions for Binary Tree Level Order Traversal.