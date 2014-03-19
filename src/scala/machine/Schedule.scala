/**
 * Created by Leo on 18/03/14.
 */
package scala.machine

import java.util.Random

class Schedule(val intervals: Int) {
  require(intervals > 0)

  val sched: Array[Int] = Array.fill(intervals){0}

  def apply(i: Int) = sched(i-1)

  def randomize() {for(i <- 0 until intervals) sched(i) = Schedule.rand.nextInt(3)}

  override def toString(): String = sched.mkString("[",",","]")
}

private object Schedule {
  val rand = new Random()
}
