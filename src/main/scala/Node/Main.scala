package Node

object Main {
  def main(args: Array[String]): Unit = {
    val integerList: ListArray[Int] = new ListArray[Int](10)
    integerList.add(10)
    integerList.add(21)
    integerList.add(1)
    integerList.add(2)
    integerList.add(0)
    integerList.add(9)
    integerList.add(-33)
    var i = 0
    for( i <- 0 to integerList.getSize()){
      System.out.print(integerList.getAt(i) + " ")
    }
    integerList.sort(false)
    //        integerList.removeLast();
    //        integerList.removeLast();
    //        integerList.removeLast();
    //        integerList.removeLast();
    //        integerList.removeLast();
    System.out.println()
    while (i < integerList.getSize()) {
      System.out.print(integerList.getAt(i) + " ")
      i+= 1; i - 1
    }
  }
}
