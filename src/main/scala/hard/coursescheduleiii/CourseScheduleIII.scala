package com.soumen.leetcodesolutions
package hard.coursescheduleiii

/**
 * <a href="https://leetcode.com/problems/course-schedule-iii/">
 * 630. Course Schedule III
 * </a>
 * */

//Approach 1: Brute Force
object CourseScheduleIII extends App {
  def scheduleCourse(courses: Array[Array[Int]]): Int =
    courses.permutations.map(_.foldLeft((0, 0)) { case ((count, start), Array(dur, last)) => if (start + dur <= last) (count + 1, start + dur) else (count, start) }._1).max


  println(scheduleCourse(Array(Array(100, 200), Array(200, 1300), Array(1000, 1250), Array(2000, 3200))))
  println(scheduleCourse(Array(Array(1, 2))))
  println(scheduleCourse(Array(Array(3, 2), Array(4, 3))))
}
//Memory Limit Exceeded