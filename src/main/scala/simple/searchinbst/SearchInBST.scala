package com.soumen.leetcodesolutions
package simple.searchinbst

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * 700. Search in a Binary Search Tree
 */
object SearchInBST extends App {
  def searchBST(root: TreeNode, `val`: Int): TreeNode = if (root == null || root.value == `val`) root else {
    searchBST(root.left, `val`) match {
      case null => searchBST(root.right, `val`)
      case found => found
    }
  }

}

//Runtime: 652 ms, faster than 92.11% of Scala online submissions for Search in a Binary Search Tree.
//Memory Usage: 55.8 MB, less than 94.74% of Scala online submissions for Search in a Binary Search Tree.