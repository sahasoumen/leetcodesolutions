package com.soumen.leetcodesolutions
package contest.biweeklycontest79

/**
 * <a href="https://leetcode.com/contest/biweekly-contest-79/problems/booking-concert-tickets-in-groups/">
 * 2286. Booking Concert Tickets in Groups
 * </a>
 * */

class BookMyShow(_n: Int, _m: Int) {
  var availableInHall = _n * _m
  var availableInRow = Array.fill[Int](_n)(_m)
  var allSeats = Array.ofDim[Int](_n, _m)

  private def isEmpty(seats: Array[Int], start: Int, k: Int) = seats(start) == 0 && seats(start + k - 1) == 0 &&
    (start + 1 until k - 1).forall(seats(_) == 0)

  @scala.annotation.tailrec
  private def firstEmptyInRow(seats: Array[Int], k: Int, start: Int = 0): Option[Int] =
    if (start == seats.length) None
    else if (isEmpty(seats, start, k)) Some(start)
    else firstEmptyInRow(seats, k, start + 1)

  @scala.annotation.tailrec
  private def firstEmptyRow(maxRow: Int, k: Int, row: Int = 0): Option[(Int, Int)] =
    if (row > maxRow) None
    else if (availableInRow(row) >= k) firstEmptyInRow(allSeats(row), k) match {
      case None => firstEmptyRow(maxRow, k, row + 1)
      case Some(startSeat) => Some(row -> startSeat)
    } else firstEmptyRow(maxRow, k, row + 1)

  def gather(k: Int, maxRow: Int): Array[Int] = if (k > availableInHall) Array.empty[Int] else firstEmptyRow(maxRow, k) match {
    case None => Array.empty[Int]
    case Some((row, start)) =>
      availableInHall -= k
      availableInRow(row) -= k
      (0 until k).foreach(i => allSeats(row)(start + i) = 1)
      Array(row, start)
  }

  @scala.annotation.tailrec
  private def calculateRemaining(maxRow: Int, remaining: Int, row: Int = 0): Unit =
    if (row <= maxRow && remaining > 0)
      remaining - availableInRow(row) match {
        case r if r > 0 => availableInRow(row) = 0
          for (i <- 0 until _m) allSeats(row)(i) = 1
          calculateRemaining(maxRow, r, row + 1)
        case _ => availableInRow(row) -= remaining
          var rr = remaining
          for (i <- 0 until _m) if (rr > 0 && allSeats(row)(i) == 0) {
            allSeats(row)(i) = 1
            rr -= 1
          }
      }

  def scatter(k: Int, maxRow: Int): Boolean =
    if (k > availableInHall) false
    else if ((0 to maxRow).map(availableInRow).sum >= k) {
      availableInHall -= k
      calculateRemaining(maxRow, k)
      true
    }
    else false
}

object BookingConcertTicketsInGroups extends App {
  val bms = new BookMyShow(19, 40)
  println(bms.scatter(34, 14))
  println(bms.scatter(5, 5))
  println(bms.gather(20, 6).toSeq)
  println(bms.gather(3, 3).toSeq)
  println(bms.gather(50, 7).toSeq)
  println(bms.gather(16, 5).toSeq)
  println(bms.gather(12, 0).toSeq)
  println(bms.scatter(23, 14))
  println(bms.scatter(36, 0))
  println(bms.scatter(25, 12))

  //  val bms = new BookMyShow(2, 5)
  //  println(bms.gather(4, 0).toSeq)
  //  println(bms.gather(2, 0).toSeq)
  //  println(bms.scatter(5, 1))
  //  println(bms.scatter(5, 1))

  //  val bms = new BookMyShow(2, 6)
  //  println(bms.scatter(2, 1))
  //  println(bms.scatter(8, 0))

  //  val bms = new BookMyShow(5, 9)
  //  println(bms.gather(10, 1).toSeq)
  //  println(bms.scatter(3, 3))
  //  println(bms.gather(9, 1).toSeq)
  //  println(bms.gather(10, 2).toSeq)
  //  println(bms.gather(0, 3).toSeq)

  //  val bms = new BookMyShow(2, 8)
  //  println(bms.scatter(3, 0))
  //  println(bms.gather(8, 0).toSeq)

  //  val bms = new BookMyShow(1, 2)
  //  println(bms.scatter(2, 0))
}
//Memory Limit Exceeded