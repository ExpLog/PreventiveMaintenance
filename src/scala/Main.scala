package scala

import scala.machine._

object Main {
  def main(args: Array[String]){
    val sa = new MySA
    val sys = sa.run()
    sys.sysEle.foreach{ x => println(x.sc)}
    sys.sysEle.foreach{ x => println(x)}
    println(sa.cost(sys))
  }
}
