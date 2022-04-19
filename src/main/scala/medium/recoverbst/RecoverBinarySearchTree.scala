package com.soumen.leetcodesolutions
package medium.recoverbst

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 99. Recover Binary Search Tree
 * */
object RecoverBinarySearchTree extends App {

  def recoverTree(root: TreeNode): Unit = {
    def swap(n1: TreeNode, n2: TreeNode): Boolean = n1.value match {
      case v => n1.value = n2.value
        n2.value = v
        true
    }

    def inorder(root: TreeNode, descendant: TreeNode, f: (Int, Int) => Boolean): Boolean = (root, descendant) match {
      case (_, null) => false
      case (r, d) if f(r.value, d.value) => swap(r, d)
      case (r, d) => inorder(r, d.left, f) || inorder(r, d.right, f)
    }

    def recover(root: TreeNode): Boolean = if (root == null) false else {
      inorder(root, root.left, (n1: Int, n2: Int) => n1 < n2) || inorder(root, root.right, (n1: Int, n2: Int) => n1 > n2) || recover(root.left) || recover(root.right)
    }

    recover(root)
  }

  val tree = TreeNode(1,
    TreeNode(3, null,
      TreeNode(2)
    )
  )
  println(tree)
  recoverTree(tree)
  println(tree)
}
//Wrong Answer
//1026 / 1919 test cases passed.
//Input [2,3,1]
//Output [3,2,1]
//Expected [2,1,3]