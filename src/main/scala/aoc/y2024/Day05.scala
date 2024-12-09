package aoc.y2024

object Day05 extends Puzzle2024[List[String], Int, Int] {
  override val input: List[String] = getInputFile

  private def isOrderedByRules(list: Array[Int]):List[Array[Int]] => Boolean = orderingRules => orderingRules.forall(x => {
    if(list.indexOf(x(0)) != -1 && list.indexOf(x(1)) != -1)
      list.indexOf(x(0)) < list.indexOf(x(1))
    else
      true
  })

  private def putInRightOrder(list: Array[Int], orderingRules: List[Array[Int]]): Array[Int] = {
    var flag = false
    while(!flag){
      flag = true
      orderingRules.foreach(rule => {
        if(list.indexOf(rule(0)) != -1 && list.indexOf(rule(1)) != -1 && list.indexOf(rule(0)) > list.indexOf(rule(1))){
          flag = false
          val tmp = list(list.indexOf(rule(0)))
          list(list.indexOf(rule(0))) = rule(1)
          list(list.indexOf(rule(1))) = tmp
        }
      })
    }
    list
  }

  override def part1(input: List[String]): Int = {
    val orderingRules: List[Array[Int]] = input.filter(_.contains("|")).map(_.split("\\|").map(_.toInt))
    val inputList: List[Array[Int]] = input.filter(_.contains(",")).map(_.split(",").map(_.toInt))

    inputList
      .filter(isOrderedByRules(_)(orderingRules))
      .map(list => list(math.ceil(list.length / 2).toInt))
      .sum
  }

  override def part2(input: List[String]): Int = {
    val orderingRules: List[Array[Int]] = input.filter(_.contains("|")).map(_.split("\\|").map(_.toInt))
    val inputList: List[Array[Int]] = input.filter(_.contains(",")).map(_.split(",").map(_.toInt))

    inputList
      .filter(!isOrderedByRules(_)(orderingRules))
      .map(putInRightOrder(_, orderingRules))
      .map(list => list(math.ceil(list.length / 2).toInt))
      .sum
  }
}
