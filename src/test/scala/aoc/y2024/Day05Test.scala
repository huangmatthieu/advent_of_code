package aoc.y2024

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day05Test extends AnyFlatSpec with Matchers {

  private val testInput = List("47|53",
    "97|13",
    "97|61",
    "97|47",
    "75|29",
    "61|13",
    "75|53",
    "29|13",
    "97|29",
    "53|29",
    "61|53",
    "97|53",
    "61|29",
    "47|13",
    "75|47",
    "97|75",
    "47|61",
    "75|61",
    "47|29",
    "75|13",
    "53|13",
    "",
    "75,47,61,53,29",
    "97,61,53,29,13",
    "75,29,13",
    "75,97,47,61,53",
    "61,13,29",
    "97,13,75,29,47")

  "Day05 - 2024" should "solve first part" in {
    Day05.part1(testInput) should equal(143)
  }

  it should "solve second part" in {
    Day05.part2(testInput) should equal(123)
  }

}
