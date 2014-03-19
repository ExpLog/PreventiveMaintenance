package scala

import scala.machine._

object Main {
  def main(args: Array[String]){
    val a = new MySA
    val sys = a.run()
    sys.sysEle.foreach{ x => println(x.sc)}
    sys.sysEle.foreach{ x => println(x)}
  }
}
