package aoc.y2024

object Day01 extends Puzzle2024[List[(Int, Int)], Int, Int] {

  override val input: List[(Int, Int)] = getInputFile
    .map(x => (x.split("\\s+")(0).toInt,  x.split("\\s+")(1).toInt))

  override def part1(input: List[(Int, Int)]): Int = input.map(_._1).sortWith(_<_).zip(input.map(_._2).sortWith(_<_)).map { case (u, v) => math.abs(u - v) }.sum

  override def part2(input: List[(Int, Int)]): Int = {
    val countOccRightList: Map[Int, Int] = input.map(_._2).groupBy(number => number).mapValues(_.length)
    input.map(_._1).map(x => x * countOccRightList.getOrElse(x, 0)).sum
  }
  
}
