package scala

import machine._
import math.min

class MySystem extends System {
  val minRel: Double = 0.9

  val sysEle: Array[Reliability] = Array.ofDim(11)
  for(i <- 0 to 6) sysEle(i) = new Reliability(24*31,helper.schedule(i),2500,2.5,1)
  for(i <- 7 to 9) sysEle(i) = new Reliability(24*31,helper.schedule(i),2400,2.6,1)
  sysEle(10) = new Reliability(24*31,helper.schedule(10),2400,2.4,1)

  val numPeriods = sysEle(0).sc.intervals

  def systemRel(period: Int): Double = {
    val rels: Array[Double] = for(i <- sysEle) yield i.rel(period)
    rels.min
  }

  def validSystem(): Boolean = {
    val relPeriods = for(i <- 0 to numPeriods) yield systemRel(i)
    relPeriods forall{_ >= minRel}
  }

  def copy(): MySystem = {
    val newSys: MySystem = new MySystem
    for(i <- 0 until 11) {
      newSys.sysEle(i) = sysEle(i).copy
    }
    newSys
  }

  def :=(that: System) = {
    for(i <- 0 until 11){
      sysEle(i) = that.sysEle(i).copy
    }
  }

  def randomStep(){
    val r = rand.nextInt(11)
    val i = rand.nextInt(sysEle(r).sc.intervals)
    val j = rand.nextInt(3)

    if(sysEle(r).sc.sched(i) == j) randomStep() else {
      sysEle(r).sc.sched.update(i,j)
      sysEle(r).update()
    }
  }
}

object helper {
  val schedule: Array[Schedule] = Array.fill(11)(new Schedule(24))
}