package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day02Test extends AnyFlatSpec with Matchers {

  private val testInput = List(
    "7 6 4 2 1", // safe
    "1 2 7 8 9", // unsafe
    "9 7 6 2 1", // unsafe
    "1 3 2 4 5", // safe
    "8 6 4 4 1", // safe
    "1 3 6 7 9" // safe
  )

  "Day02 - 2024" should "solve first part" in {
    Day02.part1(testInput) should equal(2)
  }

  it should "solve second part" in {
    Day02.part2(testInput) should equal(4)
  }

}