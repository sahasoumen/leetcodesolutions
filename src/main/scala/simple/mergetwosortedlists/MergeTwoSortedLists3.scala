package com.soumen.leetcodesolutions
package simple.mergetwosortedlists

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">
 * 21. Merge Two Sorted Lists
 * </a>
 * */
object MergeTwoSortedLists3 extends App {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode =
    if (list1 == null) list2
    else if (list2 == null) list1
    else if (list1.x <= list2.x) ListNode(list1.x, mergeTwoLists(list1.next, list2))
    else ListNode(list2.x, mergeTwoLists(list1, list2.next))

  val list1 = ListNode(1, ListNode(2, ListNode(4)))
  val list2 = ListNode(1, ListNode(3, ListNode(4)))
  println(mergeTwoLists(list1, list2))
}
//Runtime: 885 ms, faster than 29.05% of Scala online submissions for Merge Two Sorted Lists.
//Memory Usage: 71 MB, less than 11.49% of Scala online submissions for Merge Two Sorted Lists.