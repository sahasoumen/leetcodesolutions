package com.soumen.leetcodesolutions
package medium.binarytreerightsideview

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">
 * 199. Binary Tree Right Side View
 * </a>
 * */
object BinaryTreeRightSideView extends App {

  def rightSideView(root: TreeNode): List[Int] = {
    @scala.annotation.tailrec
    def bfs(breadth: Array[TreeNode], rsv: List[Int] = Nil): List[Int] =
      if (breadth.isEmpty) rsv
      else bfs(breadth.foldLeft(Array.empty[TreeNode])((children, p) => children ++ Array(Option(p.left), Option(p.right)).flatten), rsv :+ breadth.last.value)

    bfs(Option(root).toArray)
  }

  println(rightSideView(TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3)))) //1,3,4
  println(rightSideView(TreeNode(1, TreeNode(2, null, TreeNode(5)), TreeNode(3, null, TreeNode(4))))) //1,3,4
  println(rightSideView(TreeNode(1, TreeNode(3)))) //1,3
  println(rightSideView(null)) //Nil
}
//Runtime: 548 ms, faster than 100.00% of Scala online submissions for Binary Tree Right Side View.
//Memory Usage: 55.5 MB, less than 92.86% of Scala online submissions for Binary Tree Right Side View.