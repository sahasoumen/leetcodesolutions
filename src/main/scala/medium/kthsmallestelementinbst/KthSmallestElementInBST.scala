package com.soumen.leetcodesolutions
package medium.kthsmallestelementinbst

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 230. Kth Smallest Element in a BST
 * */
object KthSmallestElementInBST extends App {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    def inorder(node: TreeNode): Seq[TreeNode] = if (node == null) Nil else (inorder(node.left) :+ node) ++ inorder(node.right)

    inorder(root)(k - 1).value
  }
}
//Runtime: 660 ms, faster than 75.76% of Scala online submissions for Kth Smallest Element in a BST.
//Memory Usage: 57 MB, less than 84.85% of Scala online submissions for Kth Smallest Element in a BST.