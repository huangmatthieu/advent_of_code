package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day01Test extends AnyFlatSpec with Matchers {
  private val testInput = List(
    "3   4",
    "4   3",
    "2   5",
    "1   3",
    "3   9",
    "3   3"
  )
    .map(x => (x.split("\\s+")(0).toInt,  x.split("\\s+")(1).toInt))

  "Day01 - 2024" should "solve first part" in {
    Day01.part1(testInput) should equal(11)
  }

  it should "solve second part" in {
    Day01.part2(testInput) should equal(31)
  }
}
