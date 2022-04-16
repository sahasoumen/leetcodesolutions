package com.soumen.leetcodesolutions
package medium.covertbsttogreatertree

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 538. Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 1038. Binary Search Tree to Greater Sum Tree
 * */
object BSTToGreater extends App {
  def convertBST(root: TreeNode): TreeNode = {
    def all(n: TreeNode): Seq[Int] = if (n != null) n.value +: (all(n.left) ++ all(n.right)) else Nil

    @scala.annotation.tailrec
    def toMap(seq: Seq[Int], m: Map[Int, Int] = Map.empty, sum: Int = 0): Map[Int, Int] = seq match {
      case Nil => m
      case head :: tail => toMap(tail, m + (head -> (head + sum)), head + sum)
    }

    def convert(node: TreeNode, mapped: Map[Int, Int]): Unit = if (node != null) {
      node.value = mapped(node.value)
      convert(node.left, mapped)
      convert(node.right, mapped)
    }

    convert(root, toMap(all(root).sorted(Ordering.Int.reverse)))
    root
  }

}

//Runtime: 2337 ms, faster than 100.00% of Scala online submissions for Convert BST to Greater Tree.
//Memory Usage: 736.1 MB, less than 100.00% of Scala online submissions for Convert BST to Greater Tree.