package com.soumen.leetcodesolutions
package simple.implementstackusingqueues

import scala.collection.mutable

/**
 * https://leetcode.com/problems/implement-stack-using-queues/submissions/
 * 225. Implement Stack using Queues
 * */
class MyStack2 {
  val q = mutable.Queue.empty[Int]

  def push(x: Int): Unit = {
    q.enqueue(x)
    (0 until q.size - 1).foreach(_ => q.enqueue(q.dequeue()))
  }

  def pop(): Int = q.dequeue()

  def top(): Int = q.front

  def empty(): Boolean = q.isEmpty

}

object Test2 extends App {
  val s = new MyStack2
  s.push(1)
  s.push(2)
  s.push(3)
  println(s.top())
  println(s.pop())
  println(s.top())
}

//Runtime: 724 ms, faster than 10.00% of Scala online submissions for Implement Stack using Queues.
//Memory Usage: 68.2 MB, less than 30.00% of Scala online submissions for Implement Stack using Queues.