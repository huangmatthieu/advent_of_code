package aoc.y2024

object Day07 extends Puzzle2024[List[(Long, List[Long])], Long, Long] {

  override val input: List[(Long, List[Long])] = getInputFile
    .map(list => (list.split(":")(0).toLong, list.split(":")(1).trim.split(" ").map(_.toLong).toList))

  case class LongBetter(a: Long){
    def concat(b: Long): Long = s"$a$b".toLong
  }
  implicit def concatToLong(a: Long): LongBetter = LongBetter(a)

  private def isCalibrable(result: Long, listNumbers: List[Long], current: Long, opes: List[(Long, Long) => Long]): Boolean = {
    if(listNumbers.isEmpty)
      return result == current
    opes
      .map(f => isCalibrable(result, listNumbers.tail, f(current, listNumbers.head), opes))
      .foldLeft(false)(_ || _)
  }

  override def part1(input: List[(Long, List[Long])]): Long =
    input
      .filter{ case (result, listNumber) => isCalibrable(result, listNumber, 0, List(_ + _, _ * _))}
      .map{ case (result, _) => result}
      .sum

  override def part2(input: List[(Long, List[Long])]): Long = input
    .filter{ case (result, listNumber) => isCalibrable(result, listNumber, 0, List(_ + _, _ * _, _ concat _))}
    .map{ case (result, _) => result}
    .sum
}