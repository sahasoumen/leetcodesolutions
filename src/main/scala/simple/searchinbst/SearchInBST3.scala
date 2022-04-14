package com.soumen.leetcodesolutions
package simple.searchinbst

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * 700. Search in a Binary Search Tree
 */
object SearchInBST3 extends App {
  @scala.annotation.tailrec
  def searchBST(root: TreeNode, `val`: Int, found: TreeNode = null): TreeNode = (root, `val`) match {
    case (null, _) => null
    case (r, v) if v == r.value => r
    case (r, v) if v < r.value => searchBST(root.left, `val`)
    case (r, v) if v > r.value => searchBST(root.right, `val`)
  }

}

//Runtime: 654 ms, faster than 92.11% of Scala online submissions for Search in a Binary Search Tree.
//Memory Usage: 56.4 MB, less than 92.11% of Scala online submissions for Search in a Binary Search Tree.