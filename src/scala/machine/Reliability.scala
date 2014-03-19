package scala.machine

/**
 * Created by Leo on 19/03/14.
 */

import math.exp
import math.pow

class Reliability(length: Double, sc: Schedule, sigma:Double,
                  beta: Double, m1: Double) {
  require(m1>=0 && m1<=1)

  val rel: Array[Double] = Array.fill(sc.intervals+1){1}

  update()

  def update() {
    for(i <- 1 until rel.size) {
      rel(i) = instRel(length,rel(i-1)) + repair(sc(i))*(1-instRel(length,rel(i-1)))
    }
  }

  def repair(i: Int): Double = i match {
    case 0 => 0
    case 1 => 0.5
    case 2 => 1
    case _ => throw new IndexOutOfBoundsException
  }

  def instRel(t: Double, init: Double): Double = {
    require(t>=0 && t<=length)

    val expoent = t/(m1*sigma)

    init*exp(-pow(expoent,beta))
  }

  override def toString() = rel.mkString("[",",","]")
}
