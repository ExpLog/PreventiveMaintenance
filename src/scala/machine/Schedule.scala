/**
 * Created by Leo on 18/03/14.
 */
package scala.machine

class Schedule(val intervals: Int) {
  require(intervals > 0)

  val sched: Array[Int] = Array.fill(intervals){2}

  def apply(i: Int) = sched(i-1)

  def randomize() {for(i <- 0 until intervals) sched.update(i,rand.nextInt(3))}

  def copy(): Schedule = {
    val newSc: Schedule = new Schedule(intervals)
    for(i <- 0 until intervals) {
      val k: Int = sched(i)
      newSc.sched.update(i,k)
    }
    newSc
  }

  override def toString(): String = sched.mkString("[",",","]")
}
