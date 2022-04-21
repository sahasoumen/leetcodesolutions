package com.soumen.leetcodesolutions
package simple.designhashset

class MyHashSet2() {
  val hashLen = 10
  val hashKeys: Array[Seq[Int]] = Array.fill(hashLen)(Nil)

  def bucket(key: Int) = (key.hashCode & Int.MaxValue) % hashLen

  def add(key: Int): Unit = hashKeys(bucket(key)) match {
    case Nil => hashKeys(bucket(key)) = Seq(key)
    case s => if (!s.contains(key)) hashKeys(bucket(key)) = s :+ key
  }

  def remove(key: Int): Unit = hashKeys(bucket(key)) match {
    case Nil =>
    case s => hashKeys(bucket(key)) = s.filterNot(_ == key)
  }

  def contains(key: Int): Boolean = hashKeys(bucket(key)) match {
    case Nil => false
    case s => s contains key
  }
}


//When hashLen = 10
//Runtime: 1088 ms, faster than 73.33% of Scala online submissions for Design HashSet.
//Memory Usage: 65.5 MB, less than 76.67% of Scala online submissions for Design HashSet.

//When hashLen = 100
//Runtime: 1594 ms, faster than 40.00% of Scala online submissions for Design HashSet.
//Memory Usage: 123 MB, less than 16.67% of Scala online submissions for Design HashSet.

//When hashLen = 1000
//Runtime: 1729 ms, faster than 33.33% of Scala online submissions for Design HashSet.
//Memory Usage: 104.9 MB, less than 23.33% of Scala online submissions for Design HashSet.