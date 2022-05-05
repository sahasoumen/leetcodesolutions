package com.soumen.leetcodesolutions
package simple.implementstackusingqueues

import scala.collection.mutable

/**
 * https://leetcode.com/problems/implement-stack-using-queues/submissions/
 * 225. Implement Stack using Queues
 * */
class MyStack {
  val q1: mutable.Queue[Int] = mutable.Queue.empty
  val q2: mutable.Queue[Int] = mutable.Queue.empty
  var active = q1
  var inactive = q2
  var t: Int = 0

  def push(x: Int): Unit = {
    active.enqueue(x)
    t = x
  }


  private def swapActive(): Unit = active match {
    case tmp => active = inactive; inactive = tmp
  }

  def pop(): Int = active.size match {
    case 1 => t = 0
      swapActive()
      inactive.dequeue()
    case _ => while (active.size > 2) inactive.enqueue(active.dequeue())
      t = active.dequeue()
      inactive.enqueue(t)
      swapActive()
      inactive.dequeue()
  }

  def top(): Int = t

  def empty(): Boolean = active.isEmpty

}

object Test extends App {
  val s = new MyStack
  s.push(1)
  s.push(2)
  println(s.pop())
  println(s.top())
}

//Runtime: 598 ms, faster than 50.00% of Scala online submissions for Implement Stack using Queues.
//Memory Usage: 68 MB, less than 50.00% of Scala online submissions for Implement Stack using Queues.