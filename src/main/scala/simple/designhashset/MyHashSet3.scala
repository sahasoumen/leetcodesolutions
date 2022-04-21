package com.soumen.leetcodesolutions
package simple.designhashset

class MyHashSet3() {
  val keys = Array.fill(Math.pow(10, 6).toInt + 1)(false)

  def add(key: Int): Unit = keys(key) = true

  def remove(key: Int): Unit = keys(key) = false

  def contains(key: Int): Boolean = keys(key)
}


//Runtime: 1343 ms, faster than 63.33% of Scala online submissions for Design HashSet.
//Memory Usage: 130.3 MB, less than 13.33% of Scala online submissions for Design HashSet.