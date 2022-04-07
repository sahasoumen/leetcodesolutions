//package com.soumen.leetcodesolutions
//package medium.addtwonumbers
//
///** Complexity O(n) */
//object AddTwoNumbers extends App {
//
//  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
//    val empty = ListNode(0, null)
//
//    def safeNext(l: ListNode) = if (l != null && l.next != null) l.next else empty
//
//    def addTwoNumbers(l1: ListNode, l2: ListNode, cf: Int = 0): ListNode = if (l1 == empty && l2 == empty)
//      if (cf == 0) null else ListNode(cf, null)
//    else ListNode((cf + l1.x + l2.x) % 10, addTwoNumbers(safeNext(l1), safeNext(l2), (cf + l1.x + l2.x) / 10))
//
//    addTwoNumbers(l1, l2)
//  }
//
//  println(addTwoNumbers(ListNode(2, ListNode(4, ListNode(3))), l2 = ListNode(5, ListNode(6, ListNode(4)))))
//}
