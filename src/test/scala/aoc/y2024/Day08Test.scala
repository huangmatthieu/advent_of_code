package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day08Test extends AnyFlatSpec with Matchers {

  val testInput = List(
    "............",
    "........0...",
    ".....0......",
    ".......0....",
    "....0.......",
    "......A.....",
    "............",
    "............",
    "........A...",
    ".........A..",
    "............",
    "............").map(_.toList)

  "Day08 - 2024" should "solve first part" in {
    Day08.part1(testInput) should equal(14)
  }

  it should "solve second part" in {
    Day08.part2(testInput) should equal(34)
  }

}
