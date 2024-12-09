package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day04Test extends AnyFlatSpec with Matchers {

  private val testInput = List(
    "MMMSXXMASM",
    "MSAMXMSMSA",
    "AMXSXMAAMM",
    "MSAMASMSMX",
    "XMASAMXAMM",
    "XXAMMXXAMA",
    "SMSMSASXSS",
    "SAXAMASAAA",
    "MAMMMXMMMM",
    "MXMXAXMASX"
  ).map(_.toList)

  "Day04 - 2024" should "solve first part" in {
    Day04.part1(testInput) should equal(18)
  }

  it should "solve second part" in {
    Day04.part2(testInput) should equal(9)
  }

}
