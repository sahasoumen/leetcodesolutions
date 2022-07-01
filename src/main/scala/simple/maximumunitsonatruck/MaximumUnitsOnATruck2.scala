package com.soumen.leetcodesolutions
package simple.maximumunitsonatruck

/**
 * <a href="https://leetcode.com/problems/maximum-units-on-a-truck/">
 * 1710. Maximum Units on a Truck
 * </a>
 * */
object MaximumUnitsOnATruck2 extends App {
  def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int): Int = {
    val numberOfBoxes = Array.ofDim[Int](1001)
    for (box <- boxTypes) numberOfBoxes(box(1)) += box(0)

    @scala.annotation.tailrec
    def helper(i: Int = 1000, spaceRemaining: Int = truckSize, totalUnits: Int = 0): Int =
      if (i == 0 || spaceRemaining == 0) totalUnits
      else if (numberOfBoxes(i) == 0) helper(i - 1, spaceRemaining, totalUnits)
      else if (spaceRemaining > numberOfBoxes(i)) helper(i - 1, spaceRemaining - numberOfBoxes(i), totalUnits + i * numberOfBoxes(i))
      else helper(i - 1, 0, totalUnits + spaceRemaining * i)

    helper()
  }

  println(maximumUnits(Array(Array(1, 3), Array(2, 2), Array(3, 1)), 4)) //8
  println(maximumUnits(Array(Array(5, 10), Array(2, 5), Array(4, 7), Array(3, 9)), 10)) //91
}
//Runtime: 917 ms, faster than 100.00% of Scala online submissions for Maximum Units on a Truck.
//Memory Usage: 87.8 MB, less than 44.44% of Scala online submissions for Maximum Units on a Truck.