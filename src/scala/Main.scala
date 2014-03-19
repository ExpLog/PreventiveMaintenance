package scala

/**
 * Created by Leo on 18/03/14.
 */
import scala.machine._

object Main {
  def main(args: Array[String]){
    println("First step.")

    val mach1 = new Schedule(10,1.0)
    println(mach1)

    val mach2 = mach1.randomize()
    println(mach2)
  }
}
