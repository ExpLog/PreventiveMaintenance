/**
 * Created by Leo on 18/03/14.
 */
package scala.machine

import java.util.Random

class Schedule(intervals: Int, length: Double) {
  require(intervals > 0)
  require(length > 0)

  val sched: Array[Int] = Array.fill(intervals){0}

  def randomize(): Schedule = {
    val newSched = new Schedule(intervals, length)
    for(i <- 0 until intervals) newSched.sched(i) = Schedule.rand.nextInt(3)
    newSched
  }

  override def toString(): String = sched.mkString("[",",","]")
}

object Schedule {
  val rand = new Random()
}
