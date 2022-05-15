package com.soumen.leetcodesolutions
package medium.deepestleavessum

/**
 * https://leetcode.com/problems/deepest-leaves-sum/submissions/
 * 1302. Deepest Leaves Sum
 * */
object DeepestLeavesSum extends App {
  def deepestLeavesSum(root: TreeNode): Int = {
    var level = -1
    var sum = -1

    def add(l: Int, v: Int): Unit = if (l > level) {
      level = l
      sum = v
    } else if (l == level) sum += v

    def dfs(node: TreeNode = root, level: Int = 0): Unit = if (Option(node).isDefined) {
      add(level, node.value)
      dfs(node.left, level + 1)
      dfs(node.right, level + 1)
    }

    dfs()
    sum
  }
}

//Runtime: 907 ms, faster than 71.43% of Scala online submissions for Deepest Leaves Sum.
//Memory Usage: 86.6 MB, less than 42.86% of Scala online submissions for Deepest Leaves Sum.