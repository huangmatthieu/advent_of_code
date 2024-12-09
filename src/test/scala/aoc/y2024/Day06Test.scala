package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day06Test extends AnyFlatSpec with Matchers {

  private val testInput =
    List("....#.....",
      ".........#",
      "..........",
      "..#.......",
      ".......#..",
      "..........",
      ".#..^.....",
      "........#.",
      "#.........",
      "......#..."
  ).map(_.toList)

  "Day06 - 2024" should "solve first part" in {
    Day06.part1(testInput) should equal(41)
  }


}
