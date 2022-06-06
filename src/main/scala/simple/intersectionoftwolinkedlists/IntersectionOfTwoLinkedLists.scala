package com.soumen.leetcodesolutions
package simple.intersectionoftwolinkedlists

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">
 * 160. Intersection of Two Linked Lists
 * </a>
 * */
object IntersectionOfTwoLinkedLists extends App {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    @scala.annotation.tailrec
    def helper(a: ListNode = headA, b: ListNode = headB): ListNode =
      if (a == b) a //To work this, ListNode must be have overridden equals & hashCode with value x, or should be a case class
      //else if (a != null && b != null && a.x == b.x) a //Value comparison does not work due to some internal testing feature of leetcode
      else helper(if (a == null) headB else a.next, if (b == null) headA else b.next)

    helper()
  }

  //  val listA = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))))
  //  val listB = new ListNode(5, new ListNode(6, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))))
  val listA = ListNode(4, ListNode(1, ListNode(8, ListNode(4, ListNode(5)))))
  val listB = ListNode(5, ListNode(6, ListNode(1, ListNode(8, ListNode(4, ListNode(5))))))

  println(getIntersectionNode(listA, listB))

}
//Runtime: 705 ms, faster than 87.88% of Scala online submissions for Intersection of Two Linked Lists.
//Memory Usage: 57.5 MB, less than 81.82% of Scala online submissions for Intersection of Two Linked Lists.