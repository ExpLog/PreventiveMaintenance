package scala

import java.util.Random
import math.exp

abstract class SimulatedAnnealing[T]{
  val cooling: Double
  var temp: Double
  val initialSystem: T
  val maxTime: Double

  val rand = new Random

  def run(): T = {
    val time = System.currentTimeMillis
    var curSys: T = initialSystem

    while(System.currentTimeMillis - time <= maxTime){
      val nextSys: T = next(curSys)
      val delta = cost(nextSys) - cost(curSys)

      if(delta < 0) curSys = nextSys else {
        if(rand.nextDouble <= exp(-delta/temp)){
          curSys = nextSys
        }
      }
      temp = cooling*temp
    }
    curSys
  }

  def next(sys: T): T
  def cost(sys: T): Double
}
