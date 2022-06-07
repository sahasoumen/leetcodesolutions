package com.soumen.leetcodesolutions
package simple.mergetwosortedlists

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">
 * 21. Merge Two Sorted Lists
 * </a>
 * */
object MergeTwoSortedLists2 extends App {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    if (list1 == null) list2
    else if (list2 == null) list1
    else if (list1.x <= list2.x) {
      list1.next = mergeTwoLists(list1.next, list2)
      list1
    } else {
      list2.next = mergeTwoLists(list1, list2.next)
      list2
    }
  }

  val list1 = ListNode(1, ListNode(2, ListNode(4)))
  val list2 = ListNode(1, ListNode(3, ListNode(4)))
  println(mergeTwoLists(list1, list2))
}
//Runtime: 880 ms, faster than 33.11% of Scala online submissions for Merge Two Sorted Lists.
//Memory Usage: 71.1 MB, less than 9.46% of Scala online submissions for Merge Two Sorted Lists.