package scala

/**
 * Created by Leo on 18/03/14.
 */
import scala.machine._

object Main {
  def main(args: Array[String]){
    println("First step.")

    val mach1 = new Schedule(24)
    println(mach1)

    mach1.randomize()
    println(mach1)

    val r = new Reliability(24*31,mach1,2500,2.5,1)
    assert(r.rel forall {x => x<=1 && x>=0})
    println(r)

    mach1.randomStep()
    r.update()
    println(mach1)
    println(r)
  }
}
