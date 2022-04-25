package com.soumen.leetcodesolutions
package medium.designundergroundsystem

/**
 * https://leetcode.com/problems/design-underground-system/
 * 1396. Design Underground System
 * */

import scala.collection.mutable

class UndergroundSystem3() {
  val travelingTime: mutable.Map[Int, Int] = mutable.Map()
  val travelingStation: mutable.Map[Int, String] = mutable.Map()
  val tripTime: mutable.Map[String, Int] = mutable.Map()
  val tripCount: mutable.Map[String, Int] = mutable.Map()


  def checkIn(id: Int, stationName: String, t: Int): Unit = {
    travelingTime += id -> t
    travelingStation += id -> stationName
  }

  def checkOut(id: Int, stationName: String, t: Int): Unit = {
    travelingStation(id) match {
      case startStation => s"$startStation|$stationName" match {
        case key => tripTime get key match {
          case Some(totalTime) =>
            tripTime += key -> (totalTime + t - travelingTime(id))
            tripCount += key -> (tripCount(key) + 1)
          case None =>
            tripTime += key -> (t - travelingTime(id))
            tripCount += key -> 1
        }
      }
    }
    travelingTime -= id
    travelingStation -= id
  }

  def getAverageTime(startStation: String, endStation: String): Double = s"$startStation|$endStation" match {
    case key => tripTime(key).toDouble / tripCount(key)
  }
}

object Solution3 extends App {
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

//Runtime: 2419 ms, faster than 50.00% of Scala online submissions for Design Underground System.
//Memory Usage: 141.6 MB, less than 35.71% of Scala online submissions for Design Underground System.