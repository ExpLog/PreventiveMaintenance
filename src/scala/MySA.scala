package scala

import math.log

class MySA(maxTime: Double) extends SimulatedAnnealing(maxTime) {
  val cooling = 0.99
  var temp = 50000.0
  val initialSystem: MySystem = new MySystem

  def next(sys: MySystem): MySystem = {
    val nS: MySystem = sys.copy()
    nS.randomStep()

    if(nS.validSystem())
      nS
    else
      next(sys)
  }

  def cost(sys: MySystem): Double = {
    var c: Double = 0
    for{i <- 0 until sys.sysEle.size
        j <- 0 until sys.sysEle(i).sc.intervals} {
      val rp = sys.sysEle(i).sc.sched(j)
      val plus: Double = if( rp == 0) 0 else if ( rp == 1 ) repair(i) else replacement(i)
      c = c + plus
    }
    for(i <- 1 until sys.sysEle(1).rel.size) c = c - log(sys.systemRel(i)) + log(sys.systemRel(i-1))
    c
  }

  val repair: Map[Int,Double] = Map(0->20,1->15,2->25,3->30,4->18,5->35,6->30,7->20,
  8->25,9->15,10->20)
  val replacement: Map[Int,Double] = Map(0->40,1->30,2->50,3->60,4->36,5->70,6->60,7->40,
    8->35,9->30,10->45)
}
