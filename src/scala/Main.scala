package scala

import java.io._


object Main {
  def main(args: Array[String]){
    println("Starting Simulated Annealing")
    val writer = new PrintWriter(new File("out.txt"))

    val sa = new MySA(5*1000)
    val sys = sa.run()

    sys.sysEle.foreach{ x => writer.write(x.sc.toString + "\n")}
    sys.sysEle.foreach{ x => writer.write(x.toString + "\n")}
    writer.write(sa.cost(sys).toString + "\n")
    writer.close()
  }
}
