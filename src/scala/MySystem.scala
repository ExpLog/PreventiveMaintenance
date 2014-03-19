package scala

import machine._
import math.min

class MySystem extends System {
  val minRel: Double = 0.9

  val sysEle: Array[Reliability] = Array.ofDim(11)
  for(i <- 0 to 6) sysEle(i) = new Reliability(24*31,helper.schedule(i),2500,2.5,1)
  for(i <- 7 to 9) sysEle(i) = new Reliability(24*31,helper.schedule(i),2400,2.6,1)
  sysEle(10) = new Reliability(24*31,helper.schedule(10),2400,2.4,1)

  def systemRel(period: Int): Double = {
    val rels: Array[Double] = for(i <- sysEle) yield i.rel.apply(period)
    rels.min
  }

  def copy(): MySystem = {
    val newSys: MySystem = new MySystem
    for(i <- 0 until 11) {
      newSys.sysEle(i) = sysEle(i).copy
    }
    newSys
  }

  def =:() = copy()
}

object helper {
  val schedule: Array[Schedule] = Array.fill(11)(new Schedule(24))
}