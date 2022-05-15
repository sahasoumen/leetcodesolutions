package com.soumen.leetcodesolutions
package medium.populatingnextrightpointersineachnodeII

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
 * 117. Populating Next Right Pointers in Each Node II
 * */
object PopulatingNextRightPointersInEachNodeII extends App {
  def connect(root: Node): Node = {
    def findNext(node: Node, value: Int, level: Int, orig: Node, l: Int = 0): Node = if (node == null || l > level) null
    else if (l == level && node != orig && Option(node.next).isEmpty) node
    else findNext(node.left, value, level, orig, l + 1) match {
      case null => findNext(node.right, value, level, orig, l + 1)
      case n => n
    }

    def dfs(node: Node = root, level: Int = 0): Unit = if (node != null) {
      node.next = findNext(root, node.value, level, node)
      println(s"Level:$level, Node: $node, next: ${node.next}")
      dfs(node.left, level + 1)
      dfs(node.right, level + 1)
    }

    dfs()
    root
  }

  val root = Node(1,
    Node(2, Node(4), Node(5)),
    Node(3, null, Node(7))
  )
  val r = connect(root)
  //  println(r)
  println(r)
}

//Runtime: 795 ms, faster than 60.00% of Scala online submissions for Populating Next Right Pointers in Each Node II.
//Memory Usage: 60 MB, less than 88.57% of Scala online submissions for Populating Next Right Pointers in Each Node II.