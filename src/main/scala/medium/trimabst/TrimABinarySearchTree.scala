package com.soumen.leetcodesolutions
package medium.trimabst

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * 669. Trim a Binary Search Tree
 * */
object TrimABinarySearchTree extends App {
  def trimBST(root: TreeNode, low: Int, high: Int): TreeNode =
    if (root == null) root
    else if (root.value < low) trimBST(root.right, low, high)
    else if (root.value > high) trimBST(root.left, low, high)
    else {
      root.left = trimBST(root.left, low, high)
      root.right = trimBST(root.right, low, high)
      root
    }
}
//Runtime: 595 ms, faster than 75.00% of Scala online submissions for Trim a Binary Search Tree.
//Memory Usage: 55.5 MB, less than 100.00% of Scala online submissions for Trim a Binary Search Tree.