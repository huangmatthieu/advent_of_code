package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.annotation.tailrec

class Day09Test  extends AnyFlatSpec with Matchers {

  val inputTest: List[Int] = "2333133121414131402".toList.map(_.toString.toInt)

  "Day08 - 2024" should "solve first part" in {
    println(Day09.part1(inputTest))
  }

}
