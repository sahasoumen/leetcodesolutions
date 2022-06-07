package com.soumen.leetcodesolutions
package simple.mergetwosortedlists

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">
 * 21. Merge Two Sorted Lists
 * </a>
 * */
object MergeTwoSortedLists extends App {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    @scala.annotation.tailrec
    def helper(l1: ListNode, l2: ListNode, head: ListNode, tail: ListNode): ListNode =
      if (l1 == null) {
        tail.next = l2
        head
      } else if (l2 == null) {
        tail.next = l1
        head
      } else if (l1.x < l2.x) {
        tail.next = ListNode(l1.x)
        helper(l1.next, l2, head, tail.next)
      } else {
        tail.next = ListNode(l2.x)
        helper(l1, l2.next, head, tail.next)
      }

    if (list1 == null) list2
    else if (list2 == null) list1
    else if (list1.x <= list2.x) {
      val head = ListNode(list1.x)
      helper(list1.next, list2, head, head)
    } else {
      val head = ListNode(list2.x)
      helper(list1, list2.next, head, head)
    }
  }

  val list1 = ListNode(1, ListNode(2, ListNode(4)))
  val list2 = ListNode(1, ListNode(3, ListNode(4)))
  println(mergeTwoLists(list1, list2))
}
//Runtime: 893 ms, faster than 27.70% of Scala online submissions for Merge Two Sorted Lists.
//Memory Usage: 70.3 MB, less than 59.46% of Scala online submissions for Merge Two Sorted Lists.