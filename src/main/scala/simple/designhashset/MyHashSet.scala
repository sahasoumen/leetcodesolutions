package com.soumen.leetcodesolutions
package simple.designhashset

import scala.collection.mutable.ArrayBuffer

class MyHashSet() {
  val hashLen = 100
  val hashKeys: Array[Option[ArrayBuffer[Int]]] = Array.fill(hashLen)(None)

  def bucket(key:Int) = (key.hashCode & Int.MaxValue) % hashLen
  def add(key: Int): Unit = hashKeys(bucket(key)) match {
    case None => hashKeys(bucket(key)) = Some(ArrayBuffer(key))
    case Some(l) => if (!l.contains(key)) l += key
  }

  def remove(key: Int): Unit = hashKeys(bucket(key)) match {
    case None =>
    case Some(l) => l -= key
  }

  def contains(key: Int): Boolean = hashKeys(bucket(key)) match {
    case None => false
    case Some(l) => l contains key
  }
}

//When hashLen = 100
//Runtime: 1589 ms, faster than 40.00% of Scala online submissions for Design HashSet.
//Memory Usage: 103.9 MB, less than 23.33% of Scala online submissions for Design HashSet.

//When hashLen = 10
//Runtime: 2347 ms, faster than 33.33% of Scala online submissions for Design HashSet.
//Memory Usage: 99.5 MB, less than 46.67% of Scala online submissions for Design HashSet.

//When hashLen = 1000
//Runtime: 872 ms, faster than 76.67% of Scala online submissions for Design HashSet.
//Memory Usage: 65.6 MB, less than 76.67% of Scala online submissions for Design HashSet.