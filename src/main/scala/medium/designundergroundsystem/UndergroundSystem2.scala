package com.soumen.leetcodesolutions
package medium.designundergroundsystem

/**
 * https://leetcode.com/problems/design-underground-system/
 * 1396. Design Underground System
 * */

import scala.collection.mutable

class UndergroundSystem2() {
  val travelingTime: mutable.Map[Int, Int] = mutable.Map()
  val travelingStation: mutable.Map[Int, String] = mutable.Map()
  val avgTime: mutable.Map[String, (Int, Int)] = mutable.Map()


  def checkIn(id: Int, stationName: String, t: Int): Unit = {
    travelingTime += id -> t
    travelingStation += id -> stationName
  }

  def checkOut(id: Int, stationName: String, t: Int): Unit = travelingStation(id) match {
    case startStation => s"$startStation|$stationName" match {
      case key => avgTime get key match {
        case Some((totalTime, count)) => avgTime += key -> (totalTime + t - travelingTime(id), count + 1)
        case None => avgTime += key -> (t - travelingTime(id), 1)
      }
    }
  }

  def getAverageTime(startStation: String, endStation: String): Double = avgTime(s"$startStation|$endStation") match {
    case (total, count) => total.toDouble / count
  }
}

object Solution2 extends App {
  val undergroundSystem = new UndergroundSystem2()
  undergroundSystem.checkIn(45, "Leyton", 3)
  undergroundSystem.checkIn(32, "Paradise", 8)
  undergroundSystem.checkIn(27, "Leyton", 10)
  undergroundSystem.checkOut(45, "Waterloo", 15)
  undergroundSystem.checkOut(27, "Waterloo", 20)
  undergroundSystem.checkOut(32, "Cambridge", 22)
  println(undergroundSystem.getAverageTime("Paradise", "Cambridge"))
  println(undergroundSystem.getAverageTime("Leyton", "Waterloo"))
}

//Runtime: 1084 ms, faster than 100.00% of Scala online submissions for Design Underground System.
//Memory Usage: 75.3 MB, less than 78.57% of Scala online submissions for Design Underground System.