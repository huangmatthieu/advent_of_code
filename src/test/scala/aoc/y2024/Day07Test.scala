package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day07Test extends AnyFlatSpec with Matchers {

  private val testInput = List(
    "190: 10 19",
    "3267: 81 40 27",
    "83: 17 5",
    "156: 15 6",
    "7290: 6 8 6 15",
    "161011: 16 10 13",
    "192: 17 8 14",
    "21037: 9 7 18 13",
    "292: 11 6 16 20"
  )
    .map(list => (list.split(":")(0).toLong, list.split(":")(1).trim.split(" ").map(_.toLong).toList))

  "Day07 - 2024" should "solve first part" in {
    Day07.part1(testInput) should equal(3749)
  }

  it should "solve second part" in {
    Day07.part2(testInput) should equal(11387)
  }

}
