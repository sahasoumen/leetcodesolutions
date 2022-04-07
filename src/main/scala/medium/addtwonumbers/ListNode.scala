package com.soumen.leetcodesolutions
package medium.addtwonumbers

case class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def toString = s"ListNode($x, $next)"

  override def equals(obj: Any): Boolean = obj match {
    case ListNode(x_, next_) => x == x_ && (if (next == null) next_ == null else next.equals(next_))
    case _ => false
  }

  override def hashCode() = _x.hashCode() * 31 + (if (_next == null) 0 else _next.hashCode())
}

