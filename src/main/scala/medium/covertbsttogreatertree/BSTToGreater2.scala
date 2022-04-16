package com.soumen.leetcodesolutions
package medium.covertbsttogreatertree

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 538. Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 1038. Binary Search Tree to Greater Sum Tree
 * */
object BSTToGreater2 extends App {

  def convertBST(root: TreeNode): TreeNode = {
    var sum: Int = 0

    def convert(node: TreeNode): Unit = if (node != null) {
      convert(node.right)
      sum += node.value
      node.value = sum
      convert(node.left)
    }

    convert(root)
    root
  }
}

//Runtime: 1387 ms, faster than 100.00% of Scala online submissions for Convert BST to Greater Tree.
//Memory Usage: 62.7 MB, less than 100.00% of Scala online submissions for Convert BST to Greater Tree.