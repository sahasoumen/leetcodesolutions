package com.soumen.leetcodesolutions
package simple.designhashmap

class MyHashMap2() {
  val keys = Array.fill(Math.pow(10, 6).toInt + 1)(-1)

  def put(key: Int, value: Int): Unit = keys(key) = value

  def get(key: Int): Int = keys(key)

  def remove(key: Int): Unit = keys(key) = -1
}


//Runtime: 1564 ms, faster than 50.00% of Scala online submissions for Design HashMap.
//Memory Usage: 129.9 MB, less than 25.00% of Scala online submissions for Design HashMap.