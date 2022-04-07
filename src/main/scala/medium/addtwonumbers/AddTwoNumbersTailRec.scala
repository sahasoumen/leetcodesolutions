package com.soumen.leetcodesolutions
package medium.addtwonumbers

/** Complexity O(n) */
object AddTwoNumbersTailRec extends App {
  def addTwoNumbers(l1: ListNode, l2: ListNode) = {
    val empty = ListNode(0, null)

    def safeNext(l: ListNode) = if (l != null && l.next != null) l.next else empty

    @scala.annotation.tailrec
    def addTwoNumbers(l1: ListNode, l2: ListNode, cf: Int, head: ListNode, tail: ListNode): ListNode = {
      val sum = cf + l1.x + l2.x
      tail.x = sum % 10
      val nextCf = sum / 10
      if (safeNext(l1) == empty && safeNext(l2) == empty) {
        if (nextCf > 0) tail.next = ListNode(nextCf)
        head
      } else {
        tail.next = ListNode()
        addTwoNumbers(safeNext(l1), safeNext(l2), nextCf, head, tail.next)
      }
    }

    val result = ListNode()
    addTwoNumbers(l1, l2, 0, result, result)
  }
}
