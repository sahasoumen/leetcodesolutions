package com.soumen.leetcodesolutions
package simple.designhashmap

import scala.collection.mutable.ArrayBuffer

class MyHashMap() {
  val hashLen = 10
  val hashKeys: Array[Option[ArrayBuffer[(Int, Int)]]] = Array.fill(hashLen)(None)

  def bucket(key: Int) = (key.hashCode & Int.MaxValue) % hashLen

  def put(key: Int, value: Int): Unit = hashKeys(bucket(key)) match {
    case None => hashKeys(bucket(key)) = Some(ArrayBuffer(key -> value))
    case Some(l) => l.find(_._1 == key) match {
      case None => l += (key -> value)
      case Some(t) => (l -= t) += (key -> value)
    }
  }

  def get(key: Int): Int = hashKeys(bucket(key)) match {
    case None => -1
    case Some(l) => l.find(_._1 == key) match {
      case None => -1
      case Some((_, v)) => v
    }
  }

  def remove(key: Int): Unit = hashKeys(bucket(key)) match {
    case None =>
    case Some(l) => l.find(_._1 == key) match {
      case None =>
      case Some(t) => l -= t
    }
  }
}

object Main extends App {
  val myMap = new MyHashMap()
  val ops = Seq("remove", "put", "remove", "remove", "get", "remove", "put", "get", "remove", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "remove", "put", "put", "get", "put", "get", "put", "put", "get", "put", "remove", "remove", "put", "put", "get", "remove", "put", "put", "put", "get", "put", "put", "remove", "put", "remove", "remove", "remove", "put", "remove", "get", "put", "put", "put", "put", "remove", "put", "get", "put", "put", "get", "put", "remove", "get", "get", "remove", "put", "put", "put", "put", "put", "put", "get", "get", "remove", "put", "put", "put", "put", "get", "remove", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "remove", "remove", "get", "remove", "put", "put", "remove", "get", "put", "put")
  val values = Seq(Seq(27), Seq(65, 65), Seq(19), Seq(0), Seq(18), Seq(3), Seq(42, 0), Seq(19), Seq(42), Seq(17, 90), Seq(31, 76), Seq(48, 71), Seq(5, 50), Seq(7, 68), Seq(73, 74), Seq(85, 18), Seq(74, 95), Seq(84, 82), Seq(59, 29), Seq(71, 71), Seq(42), Seq(51, 40), Seq(33, 76), Seq(17), Seq(89, 95), Seq(95), Seq(30, 31), Seq(37, 99), Seq(51), Seq(95, 35), Seq(65), Seq(81), Seq(61, 46), Seq(50, 33), Seq(59), Seq(5), Seq(75, 89), Seq(80, 17), Seq(35, 94), Seq(80), Seq(19, 68), Seq(13, 17), Seq(70), Seq(28, 35), Seq(99), Seq(37), Seq(13), Seq(90, 83), Seq(41), Seq(50), Seq(29, 98), Seq(54, 72), Seq(6, 8), Seq(51, 88), Seq(13), Seq(8, 22), Seq(85), Seq(31, 22), Seq(60, 9), Seq(96), Seq(6, 35), Seq(54), Seq(15), Seq(28), Seq(51), Seq(80, 69), Seq(58, 92), Seq(13, 12), Seq(91, 56), Seq(83, 52), Seq(8, 48), Seq(62), Seq(54), Seq(25), Seq(36, 4), Seq(67, 68), Seq(83, 36), Seq(47, 58), Seq(82), Seq(36), Seq(30, 85), Seq(33, 87), Seq(42, 18), Seq(68, 83), Seq(50, 53), Seq(32, 78), Seq(48, 90), Seq(97, 95), Seq(13, 8), Seq(15, 7), Seq(5), Seq(42), Seq(20), Seq(65), Seq(57, 9), Seq(2, 41), Seq(6), Seq(33), Seq(16, 44), Seq(95, 30))
  ops.zip(values).map {
    case (op, v) => op match {
      case "remove" => (op -> v) -> myMap.remove(v.head)
      case "put" => (op -> v) -> myMap.put(v.head, v.tail.head)
      case "get" => (op -> v) -> myMap.get(v.head)
    }
  }.foreach(println)
}

//hashLen = 10
//Runtime: 1087 ms, faster than 75.00% of Scala online submissions for Design HashMap.
//Memory Usage: 65.5 MB, less than 75.00% of Scala online submissions for Design HashMap.

//hashLen = 100
//Runtime: 1663 ms, faster than 25.00% of Scala online submissions for Design HashMap.
//Memory Usage: 132 MB, less than 25.00% of Scala online submissions for Design HashMap.