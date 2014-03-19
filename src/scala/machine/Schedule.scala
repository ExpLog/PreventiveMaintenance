/**
 * Created by Leo on 18/03/14.
 */
package scala.machine

import java.util.Random

class Schedule(val intervals: Int) {
  require(intervals > 0)

  val sched: Array[Int] = Array.fill(intervals){0}

  def apply(i: Int) = sched(i-1)

  def randomize() {for(i <- 0 until intervals) sched(i) = rand.nextInt(3)}

  def randomStep() {
    val i = rand.nextInt(intervals+1)
    sched(i) = rand.nextInt(3)
  }

  override def toString(): String = sched.mkString("[",",","]")
}
