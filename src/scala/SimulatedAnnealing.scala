package scala

import java.util.Random
import math.exp

abstract class SimulatedAnnealing(maxTime: Double){
  val cooling: Double
  var temp: Double
  val initialSystem: MySystem

  val rand = new Random

  def run(): MySystem = {
    val time = System.currentTimeMillis
    var curSys: MySystem = initialSystem

    while(System.currentTimeMillis - time <= maxTime){
      val nextSys: MySystem = next(curSys)
      val delta = cost(nextSys) - cost(curSys)

      if(delta < 0) curSys = nextSys else {
        if(rand.nextDouble <= exp(-delta/temp)){
          curSys = nextSys.copy()
        }
      }
      temp = cooling*temp
    }
    curSys
  }

  def next(sys: MySystem): MySystem
  def cost(sys: MySystem): Double
}
