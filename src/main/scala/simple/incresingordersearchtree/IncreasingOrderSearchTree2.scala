package com.soumen.leetcodesolutions
package simple.incresingordersearchtree

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 * 897. Increasing Order Search Tree
 * */
object IncreasingOrderSearchTree2 extends App {

  def increasingBST(root: TreeNode): TreeNode = {
    var last = new TreeNode

    def helper(node: TreeNode): Unit = if (node != null) {
      helper(node.left)
      node.left = null
      last.right = node
      last = node
      helper(node.right)
    }

    val ans = last
    helper(root)
    ans.right
  }


  val root = TreeNode(2,
    TreeNode(1),
    TreeNode(4,
      TreeNode(3)
    )
  )
  println(increasingBST(root))
}
//Runtime: 554 ms, faster than 75.00% of Scala online submissions for Increasing Order Search Tree.
//Memory Usage: 55.2 MB, less than 75.00% of Scala online submissions for Increasing Order Search Tree.