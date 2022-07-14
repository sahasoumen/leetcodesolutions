package com.soumen.leetcodesolutions
package binarytreelevelordertraversal

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">
 * 102. Binary Tree Level Order Traversal
 * </a>
 * */
object BinaryTreeLevelOrderTraversal3 extends App {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    def bfs(nodes: List[TreeNode] = Option(root).toList): List[List[Int]] =
      if (nodes.isEmpty) Nil
      else List(nodes.foldLeft(Nil: List[Int])(_ :+ _.value)) ++ bfs(nodes.foldLeft(Nil: List[TreeNode])((l, n) => l ++ List(Option(n.left), Option(n.right)).flatten))

    bfs()
  }

  println(levelOrder(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))))) //[[3],[9,20],[15,7]]
  println(levelOrder(TreeNode(1))) //[[1]]
  println(levelOrder(null)) //[]

}
//Runtime: 1190 ms, faster than 5.95% of Scala online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 73.7 MB, less than 22.62% of Scala online submissions for Binary Tree Level Order Traversal.