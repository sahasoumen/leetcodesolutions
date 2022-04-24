package com.soumen.leetcodesolutions
package medium.designundergroundsystem

/**
 * https://leetcode.com/problems/design-underground-system/
 * 1396. Design Underground System
 * */

import scala.collection.mutable

class UndergroundSystem() {
  val avgTime: mutable.Map[(String, String), (Int, Int)] = mutable.Map()

  val traveling: mutable.Map[Int, (String, Int)] = mutable.Map()

  def checkIn(id: Int, stationName: String, t: Int): Unit = traveling += id -> (stationName, t)

  def checkOut(id: Int, stationName: String, t: Int): Unit = traveling get id match {
    case None =>
    case Some((startStationName, startTime)) => avgTime get(startStationName, stationName) match {
      case None => avgTime += ((startStationName, stationName) -> (t - startTime, 1))
      case Some((total, c)) => avgTime += ((startStationName, stationName) -> (total + t - startTime, c + 1))
        traveling -= id
    }
  }

  def getAverageTime(startStation: String, endStation: String): Double = avgTime get (startStation -> endStation) match {
    case None => 0.0
    case Some((total, count)) => total.toDouble / count
  }
}

//Runtime: 2861 ms, faster than 28.57% of Scala online submissions for Design Underground System.
//Memory Usage: 140.8 MB, less than 50.00% of Scala online submissions for Design Underground System.