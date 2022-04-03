package com.soumen.leetcodesolutions
package medium.addtwonumbers

/** Complexity O(n) */
object AddTwoNumbersTailRec extends App {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x

    override def toString = s"ListNode($x, $next)"
  }


  def addTwoNumbers(l1: ListNode, l2: ListNode) = {
    val empty = new ListNode(0, null)

    def safeNext(l: ListNode) = if (l != null && l.next != null) l.next else empty

    @scala.annotation.tailrec
    def addTwoNumbers(l1: ListNode, l2: ListNode, cf: Int, head: ListNode, tail: ListNode): ListNode = {
      val sum = cf + l1.x + l2.x
      tail.x = sum % 10
      val nextCf = sum / 10
      if (safeNext(l1) == empty && safeNext(l2) == empty) {
        if (nextCf > 0) tail.next = new ListNode(nextCf)
        head
      } else {
        tail.next = new ListNode()
        addTwoNumbers(safeNext(l1), safeNext(l2), nextCf, head, tail.next)
      }
    }

    val result = new ListNode()
    addTwoNumbers(l1, l2, 0, result, result)
  }

  println(addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), l2 = new ListNode(5, new ListNode(6, new ListNode(4)))))
  println(addTwoNumbers(new ListNode(0), l2 = new ListNode(0)))
  println(addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))), l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))
}
