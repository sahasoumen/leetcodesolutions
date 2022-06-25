package com.soumen.leetcodesolutions
package hard.coursescheduleiii

/**
 * <a href="https://leetcode.com/problems/course-schedule-iii/">
 * 630. Course Schedule III
 * </a>
 * */


object CourseScheduleIII2 extends App {
  def scheduleCourse(courses: Array[Array[Int]]): Int = {
    val q = scala.collection.mutable.PriorityQueue.empty[Int]
    courses.sortBy(_ (1)).foldLeft(0) { case (totalDuration, Array(duration, lastDay)) =>
      q.enqueue(duration)
      if (totalDuration + duration > lastDay) totalDuration + duration - q.dequeue() else totalDuration + duration
    }
    q.size
  }


  println(scheduleCourse(Array(Array(100, 200), Array(200, 1300), Array(1000, 1250), Array(2000, 3200)))) //3
  println(scheduleCourse(Array(Array(1, 2)))) //1
  println(scheduleCourse(Array(Array(3, 2), Array(4, 3)))) //0
}
//Runtime: 1250 ms, faster than 88.89% of Scala online submissions for Course Schedule III.
//Memory Usage: 66.5 MB, less than 88.89% of Scala online submissions for Course Schedule III.