package com.soumen.leetcodesolutions
package medium.addtwonumbers

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class AddTwoNumbersTailRecTest extends AnyFreeSpec with should.Matchers {
  val addTwoNumbers = AddTwoNumbersTailRec
  "Add Two Number" - {
    "should add two array of digits" in {
      addTwoNumbers.addTwoNumbers(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4)))) should be(ListNode(7, ListNode(0, ListNode(8))))
      addTwoNumbers.addTwoNumbers(ListNode(0), ListNode(0)) should be(ListNode(0))
      addTwoNumbers.addTwoNumbers(ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9))))))), ListNode(9, ListNode(9, ListNode(9, ListNode(9))))) should be(ListNode(8, ListNode(9, ListNode(9, ListNode(9, ListNode(0, ListNode(0, ListNode(0, ListNode(1)))))))))
    }
  }
}
