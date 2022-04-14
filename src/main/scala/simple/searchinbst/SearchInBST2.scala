package com.soumen.leetcodesolutions
package simple.searchinbst

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * 700. Search in a Binary Search Tree
 */
object SearchInBST2 extends App {
  @scala.annotation.tailrec
  def searchBST(root: TreeNode, `val`: Int, found: TreeNode = null): TreeNode = if (root == null || root.value == `val`) root
  else if (`val` < root.value) searchBST(root.left, `val`)
  else searchBST(root.right, `val`)

}

//Runtime: 626 ms, faster than 92.11% of Scala online submissions for Search in a Binary Search Tree.
//Memory Usage: 56.4 MB, less than 92.11% of Scala online submissions for Search in a Binary Search Tree.