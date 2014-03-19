package scala.machine

/**
 * Created by Leo on 19/03/14.
 */
abstract class System {
  val sysEle: List[Reliability]
  def systemRel(period: Int) = Double
}
