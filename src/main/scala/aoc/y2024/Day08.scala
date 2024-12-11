package aoc.y2024

object Day08 extends Puzzle2024[List[List[Char]], Int, Int] {

  override val input: List[List[Char]] = getInputFile.map(_.toList)

  case class Point(x: Int, y: Int, frequency: Char){
    def distance(b: Point): (Int, Int) = (this.x - b.x, this.y - b.y)
    def isInside(in: List[List[Char]]): Boolean = x >= 0 && x < in.head.length && y >= 0 && y < in.length
  }

  private def getAllFrequency(in: List[List[Char]]): List[(Point, Point)] =
    in.zipWithIndex
      .flatMap { case (list, indY) => list.zipWithIndex
        .filter { case (char, _) => char != '.' }
        .map { case (char, indX) => Point(indX, indY, char) }
      }
      .groupBy(point => point.frequency)
      .mapValues(_.toSet[Point].subsets.filter(_.toList.length == 2).map(_.toList).toList)
      .values
      .toList
      .flatten
      .map(t => (t.head, t(1)))

  override def part1(input: List[List[Char]]): Int = {
    val inputTab = input.map(_.toArray).toArray
    val pairList = getAllFrequency(input)
    pairList.foreach{
      case (p1, p2) =>
        val (deltaX, deltaY) = p1.distance(p2)
        val antinodeP1 = Point(p1.x + deltaX, p1.y + deltaY, '#')
        val antinodeP2 = Point(p2.x - deltaX, p2.y - deltaY, '#')
        if(antinodeP1.isInside(input))
          inputTab(antinodeP1.y)(antinodeP1.x) = antinodeP1.frequency
        if(antinodeP2.isInside(input))
          inputTab(antinodeP2.y)(antinodeP2.x) = antinodeP2.frequency
    }
    inputTab.map(list => list.count(_ == '#')).sum
  }

  override def part2(input: List[List[Char]]): Int = {
    val inputTab = input.map(_.toArray).toArray
    val pairList = getAllFrequency(input)
    pairList.foreach{
      case (p1, p2) =>
        val (deltaX, deltaY) = p1.distance(p2)
        var antinodeP1 = Point(p1.x + deltaX, p1.y + deltaY, '#')
        while(antinodeP1.isInside(input)){
          inputTab(antinodeP1.y)(antinodeP1.x) = antinodeP1.frequency
          antinodeP1 = Point(antinodeP1.x + deltaX, antinodeP1.y + deltaY, '#')
        }
        var antinodeP2 = Point(p2.x - deltaX, p2.y - deltaY, '#')
        while(antinodeP2.isInside(input)){
          inputTab(antinodeP2.y)(antinodeP2.x) = antinodeP2.frequency
          antinodeP2 = Point(antinodeP2.x - deltaX, antinodeP2.y - deltaY, '#')
        }

    }
    inputTab.map(list => list.count(_ != '.')).sum
  }
}
