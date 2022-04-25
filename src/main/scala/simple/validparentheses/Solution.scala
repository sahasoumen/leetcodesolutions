package com.soumen.leetcodesolutions
package simple.validparentheses

import scala.collection.mutable

object Solution extends App {

  def isValid(s: String): Boolean = {
    val stack: mutable.Stack[Char] = mutable.Stack()

    @scala.annotation.tailrec
    def isValid(s: Seq[Char]): Boolean = s match {
      case Nil => stack.isEmpty
      case head :: tail => head match {
        case '(' | '{' | '[' => stack.push(head)
          isValid(tail)
        case ')' => if (stack.nonEmpty && stack.pop() == '(') isValid(tail) else false
        case '}' => if (stack.nonEmpty && stack.pop() == '{') isValid(tail) else false
        case ']' => if (stack.nonEmpty && stack.pop() == '[') isValid(tail) else false
      }
    }

    isValid(s.toList)
  }
}

//Runtime: 715 ms, faster than 58.10% of Scala online submissions for Valid Parentheses.
//Memory Usage: 68.3 MB, less than 31.62% of Scala online submissions for Valid Parentheses.