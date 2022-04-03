package com.soumen.leetcodesolutions
package medium.addtwonumbers

/** Complexity O(n) */
object AddTwoNumbers extends App {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x

    override def toString = s"ListNode($x, $next)"
  }


  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val empty = new ListNode(0, null)

    def safeNext(l: ListNode) = if (l != null && l.next != null) l.next else empty

    def addTwoNumbers(l1: ListNode, l2: ListNode, cf: Int = 0): ListNode = if (l1 == empty && l2 == empty)
      if (cf == 0) null else new ListNode(cf, null)
    else new ListNode((cf + l1.x + l2.x) % 10, addTwoNumbers(safeNext(l1), safeNext(l2), (cf + l1.x + l2.x) / 10))

    addTwoNumbers(l1, l2)
  }

  println(addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), l2 = new ListNode(5, new ListNode(6, new ListNode(4)))))
}
