package com.soumen.leetcodesolutions
package medium.btreezigzagtraversal

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. Binary Tree Zigzag Level Order Traversal
 */
object BTreeZigZagTraversal extends App {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    def getAllByDepth(parent: TreeNode = root, depth: Int = 0): List[(Int, Int)] = if (parent == null) Nil else (parent.value, depth) +: (getAllByDepth(parent.left, depth + 1) ++ getAllByDepth(parent.right, depth + 1))

    getAllByDepth().groupBy(_._2).toList.sortBy(_._1).map { case (level, list) => if (level % 2 == 0) list.map(_._1) else list.map(_._1).reverse }
  }

  println(zigzagLevelOrder(
    TreeNode(1,
      TreeNode(2,
        TreeNode(4, null, null), null),
      TreeNode(3, null,
        TreeNode(5, null, null)))
  ))

}
//Runtime: 531 ms, faster than 87.50% of Scala online submissions for Binary Tree Zigzag Level Order Traversal.
//Memory Usage: 55.4 MB, less than 93.75% of Scala online submissions for Binary Tree Zigzag Level Order Traversal.