package aoc.y2024

object Day06 extends Puzzle2024[List[List[Char]], Int, Int] {

  override val input: List[List[Char]] = getInputFile.map(_.toList)

  case class Guard(posX: Int, posY: Int, direction: Int, map: List[List[Char]]){
    private def isObstable(x: Int, y: Int): Boolean = {
      map(y)(x) == '#'
    }
    
    def isInside(x: Int, y: Int): Boolean = x >= 0 && x < map.head.length && y >= 0 && y < map.length

    def move: Guard =
      direction match {
        case 0 => if(isInside(posX, posY - 1) && isObstable(posX, posY - 1)) Guard(posX, posY, (direction + 1) % 4, map) else Guard(posX, posY - 1, direction, map)
        case 1 => if(isInside(posX + 1, posY) && isObstable(posX + 1, posY)) Guard(posX, posY, (direction + 1) % 4, map) else Guard(posX + 1, posY, direction, map)
        case 2 => if(isInside(posX, posY + 1) && isObstable(posX, posY + 1)) Guard(posX, posY, (direction + 1) % 4, map) else Guard(posX, posY + 1, direction, map)
        case 3 => if(isInside(posX - 1, posY) && isObstable(posX - 1, posY)) Guard(posX, posY, (direction + 1) % 4, map) else Guard(posX - 1, posY, direction, map)
      }
  }

  override def part1(input: List[List[Char]]): Int = {
    val (x, y): (Int, Int) = input.zipWithIndex.flatMap{
      case (list, indY) => list.zipWithIndex.filter { case (char, _) => char == '^' }.map{case (_, indX) => (indX, indY)}
    }.head
    var guard = Guard(x, y, 0, input)
    val inputTab = input.map(_.toArray).toArray

    while(guard.isInside(guard.posX, guard.posY)){
      inputTab(guard.posY)(guard.posX) = 'X'
      guard = guard.move
    }

    inputTab.map(list => list.count(_ == 'X')).sum
  }

  override def part2(input: List[List[Char]]): Int = ???
}
