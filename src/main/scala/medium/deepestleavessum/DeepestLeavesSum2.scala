package com.soumen.leetcodesolutions
package medium.deepestleavessum

/**
 * https://leetcode.com/problems/deepest-leaves-sum/submissions/
 * 1302. Deepest Leaves Sum
 * */
object DeepestLeavesSum2 extends App {
  case class Result(level: Int, sum: Int) {
    def add(l: Int, v: Int) = if (l < level) this else if (l > level) Result(l, v) else Result(l, sum + v)
  }

  def deepestLeavesSum(root: TreeNode): Int = {
    def dfs(node: TreeNode = root, level: Int = 0, result: Result = Result(-1, -1)): Result = if (Option(node).isEmpty) result
    else dfs(node.right, level + 1, dfs(node.left, level + 1, result.add(level, node.value)).add(level, node.value))

    dfs().sum / 2 //Each leve is counting itself twice (left + right)
  }
}

//Runtime: 717 ms, faster than 100.00% of Scala online submissions for Deepest Leaves Sum.
//Memory Usage: 57.8 MB, less than 85.71% of Scala online submissions for Deepest Leaves Sum.