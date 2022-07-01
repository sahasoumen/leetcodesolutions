package com.soumen.leetcodesolutions
package simple.maximumunitsonatruck

/**
 * <a href="https://leetcode.com/problems/maximum-units-on-a-truck/">
 * 1710. Maximum Units on a Truck
 * </a>
 * */
object MaximumUnitsOnATruck extends App {
  def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int): Int = {
    val sorted = boxTypes.sortBy(-_ (1))

    @scala.annotation.tailrec
    def helper(i: Int = 0, spaceRemaining: Int = truckSize, totalUnits: Int = 0): Int =
      if (i == boxTypes.length || spaceRemaining == 0) totalUnits
      else if (spaceRemaining > sorted(i)(0)) helper(i + 1, spaceRemaining - sorted(i)(0), totalUnits + sorted(i)(0) * sorted(i)(1))
      else helper(i + 1, 0, totalUnits + spaceRemaining * sorted(i)(1))

    helper()
  }

  println(maximumUnits(Array(Array(1, 3), Array(2, 2), Array(3, 1)), 4)) //8
  println(maximumUnits(Array(Array(5, 10), Array(2, 5), Array(4, 7), Array(3, 9)), 10)) //91
}
//Runtime: 824 ms, faster than 100.00% of Scala online submissions for Maximum Units on a Truck.
//Memory Usage: 86.9 MB, less than 88.89% of Scala online submissions for Maximum Units on a Truck.