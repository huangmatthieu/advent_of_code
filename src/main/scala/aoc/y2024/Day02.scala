package aoc.y2024

object Day02  extends Puzzle2024[List[String], Int, Int] {

  override val input: List[String] = getInputFile

  private def isSortedList(list: List[Int]): Boolean = list.sorted == list || list.sorted.reverse == list

  private def isSafeLevel(list: List[Int]): Boolean = list.dropRight(1).zip(list.tail).count { case (u, v) => math.abs(u - v) <= 3 && math.abs(u - v) >= 1 } == list.length - 1

  private def removeOneLevel(list: List[Int]): List[Int] = (list.indices.map(x => list.zipWithIndex.filter{case(_, i) => i != x}.map(_._1)).toList.filter(isSortedList).filter(isSafeLevel) ::: List(list)).head

  override def part1(input: List[String]): Int = input.map(x => x.split("\\s+").map(_.toInt).toList).filter(isSortedList).count(isSafeLevel)

  override def part2(input: List[String]): Int = input.map(x => x.split("\\s+").map(_.toInt).toList).map(removeOneLevel).filter(isSortedList).count(isSafeLevel)

}
