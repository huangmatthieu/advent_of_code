package aoc.y2024

import scala.util.Try

object Day09 extends Puzzle2024[List[Int], Long, Long] {

  override val input: List[Int] = getInputFile.head.toList.map(_.toString.toInt)

  private def convertDiskMap(input: List[Int]): Array[Int] =
    input
      .zipWithIndex
      .flatMap{ case(ntimes, index) =>
        index % 2 match {
        case 0 => List.fill(ntimes)(index / 2)
        case 1 => List.fill(ntimes)(-1)
        }
      }
      .toArray

  override def part1(input:List[Int]): Long = {
    val convertedDiskMap = convertDiskMap(input)
    var fistDotIndex: Int = convertedDiskMap.indexOf(-1)
    var mostRightIndex: Int = convertedDiskMap.length - 1
    while(fistDotIndex < mostRightIndex){
      if(convertedDiskMap(mostRightIndex) != -1) {
        convertedDiskMap(fistDotIndex) = convertedDiskMap(mostRightIndex)
        convertedDiskMap(mostRightIndex) = -1
      }
      fistDotIndex = convertedDiskMap.indexOf(-1)
      mostRightIndex = mostRightIndex - 1
    }
    convertedDiskMap
      .filter(_ != -1)
      .zipWithIndex
      .map{ case (id, index) => id.toLong * index}
      .sum
  }

  override def part2(input: List[Int]): Long = 0
}
