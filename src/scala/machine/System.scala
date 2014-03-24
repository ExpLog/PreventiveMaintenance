package scala.machine

abstract class System {
  val sysEle: Array[Reliability]
  val minRel: Double

  require(minRel >= 0 && minRel <= 1)

  def randomStep(): Unit
  def systemRel(period: Int): Double
  def validSystem(): Boolean
  def copy(): System
}