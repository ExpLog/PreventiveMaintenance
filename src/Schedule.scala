/**
 * Created by Leo on 18/03/14.
 */
class Schedule(intervals: Int, length: Double) {
  require(intervals > 0)
  require(length > 0)

  val sched: Array[Int] = Array.fill(intervals){0}

  override def toString(): String = sched.toString
}
