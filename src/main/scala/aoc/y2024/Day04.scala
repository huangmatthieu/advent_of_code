package aoc.y2024

object Day04 extends Puzzle2024[List[List[Char]], Int, Int] {
  override val input: List[List[Char]] = getInputFile.map(_.toList)

  private def inputCoord(input: List[List[Char]], coord: (Int, Int)): Char = input(coord._2)(coord._1)

  private def allDirections(x: Int, y: Int, input: List[List[Char]]): Int = {
    val directions = List(
      List((x, y - 1), (x, y - 2), (x, y - 3)), //north
      List((x, y + 1), (x, y + 2), (x, y + 3)), //south
      List((x - 1, y), (x - 2, y), (x - 3, y)), //west
      List((x + 1, y), (x + 2, y), (x + 3, y)), //east
      List((x - 1, y - 1), (x - 2, y - 2), (x - 3, y - 3)), // south-west
      List((x + 1, y - 1), (x + 2, y - 2), (x + 3, y - 3)), // south-east
      List((x - 1, y + 1), (x - 2, y + 2), (x - 3, y + 3)), // north-west
      List((x + 1, y + 1), (x + 2, y + 2), (x + 3, y + 3)) // north-east
    )

    directions.map(direction => {
        direction.zip(List('M', 'A', 'S'))
          .forall { case (coord, letter) => coord._1 >= 0 && coord._1 < input.head.length && coord._2 >= 0 && coord._2 < input.length && inputCoord(input, coord) == letter }
      })
      .count(x => x)
  }

  private def isXShape(x: Int, y: Int, input: List[List[Char]]): Boolean =
    (input(y - 1)(x - 1) == 'M' && input(y + 1)(x + 1) == 'S' ||
      input(y - 1)(x - 1) == 'S' && input(y + 1)(x + 1) == 'M') &&
      (input(y + 1)(x - 1) == 'M' && input(y - 1)(x + 1) == 'S' ||
        input(y + 1)(x - 1) == 'S' && input(y - 1)(x + 1) == 'M')


  override def part1(input: List[List[Char]]): Int =
    input.zipWithIndex.map { case (line, indY) =>
      line.zipWithIndex.map { case (char, indX) =>
        if (char == 'X') allDirections(indX, indY, input) else 0
      }.sum
    }.sum

  override def part2(input: List[List[Char]]): Int =
    input.zipWithIndex.map { case (line, indY) =>
      line.zipWithIndex.map { case (char, indX) =>
          if (indX < (input.head.length - 1) && indY < (input.length - 1) &&  indX > 0 && indY > 0&& char == 'A')
              isXShape(indX, indY, input)
          else false
        }
        .count(x => x)
    }.sum

}
