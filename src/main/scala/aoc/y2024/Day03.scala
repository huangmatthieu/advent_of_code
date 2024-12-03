package aoc.y2024

object Day03 extends Puzzle2024[List[String], Int, Int] {

  override val input: List[String] = getInputFile

  private val extractMul: String => Int = line => """mul\((\d+),(\d+)\)""".r.findAllMatchIn(line).toList.map(x => x.group(1).toInt  * x.group(2).toInt).sum

  override def part1(input: List[String]): Int = input.map(extractMul).sum

  override def part2(input: List[String]): Int = extractMul("""don't\(\)(?:(?!do\(\)).)*do\(\)|don't\(\)(?:(?!do\(\)).)*$""".r.replaceAllIn(input.mkString, ""))
}
