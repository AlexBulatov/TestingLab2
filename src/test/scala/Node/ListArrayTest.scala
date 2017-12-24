package Node

import org.scalatest.FunSuite

class ListArrayTest extends FunSuite {

  test("testAdd") {
    val l = new ListArray[Integer](3)
    l.add(4)
    assert(1 == l.getSize)
    assert(4 == l.getLast.asInstanceOf[Int])
    l.add(1)
    l.add(2)
    l.add(3)
    assert(4 == l.getSize)
    assert(3 == l.getLast.asInstanceOf[Int])
  }

  test("testNodeSize") {

  }

}
