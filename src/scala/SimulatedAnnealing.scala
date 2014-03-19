package scala

/**
 * Created by Leo on 19/03/14.
 */

import java.util.Random
import math.exp

abstract class SimulatedAnnealing[T](cooling: Double, initialTemp: Double,
                                     initialSystem: T, maxTime: Double) {
  var temp = initialTemp
  val rand = new Random

  def run(): T = {
    val time = System.currentTimeMillis
    var curSys: T = initialSystem

    while(System.currentTimeMillis - time <= maxTime){
      val nextSys: T = next(curSys)
      val delta = cost(nextSys) - cost(curSys)
      if(rand.nextDouble <= exp(-delta/temp)){
        curSys = nextSys
      }
      temp = cooling*temp
    }
    curSys
  }

  def next(sys: T): T
  def cost(sys: T): Double
}
