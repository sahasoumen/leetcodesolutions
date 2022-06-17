package com.soumen.leetcodesolutions
package medium.binarytreecameras

/**
 * <a href="https://leetcode.com/problems/binary-tree-cameras/">
 * 968. Binary Tree Cameras
 * </a>
 * */
object BinaryTreeCameras extends App {

  def minCameraCover(root: TreeNode): Int = {
    object NodeState extends Enumeration {
      val HasCamera, Monitored, NotMonitored = Value
    }
    import NodeState._
    def dfs(node: TreeNode = root): (NodeState.Value, Int) =
      if (node == null) Monitored -> 0
      else dfs(node.left) -> dfs(node.right) match {
        case ((leftState, leftCount), (rightState, rightCount)) if leftState == NotMonitored || rightState == NotMonitored => HasCamera -> (leftCount + rightCount + 1)
        case ((leftState, leftCount), (rightState, rightCount)) if leftState == HasCamera || rightState == HasCamera => Monitored -> (leftCount + rightCount)
        case ((_, leftCount), (_, rightCount)) => NotMonitored -> (leftCount + rightCount)
      }

    if (root == null) 0 else dfs() match {
      case (NotMonitored, count) => count + 1
      case (_, count) => count
    }
  }

  val root = TreeNode(1, null, TreeNode(2, null, TreeNode(3, null, TreeNode(4))))
  println(minCameraCover(root))
}
//Runtime: 966 ms, faster than 50.00% of Scala online submissions for Binary Tree Cameras.
//Memory Usage: 70.1 MB, less than 100.00% of Scala online submissions for Binary Tree Cameras.