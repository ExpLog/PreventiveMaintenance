package scala.machine

import math.exp
import math.pow

class Reliability(length: Double, val sc: Schedule, sigma:Double,
                  beta: Double, m1: Double) {
  require(m1>=0 && m1<=1)

  //this is the reliability of a machine at the beginning of an interval
  val rel: Array[Double] = Array.fill(sc.intervals+1){1.0}
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

  def copy(): Reliability = {
    val newRel: Reliability = new Reliability(length,sc.copy,sigma,beta,m1)
    newRel.update()
    newRel
  }

  override def toString() = rel.mkString("[",",","]")
}
