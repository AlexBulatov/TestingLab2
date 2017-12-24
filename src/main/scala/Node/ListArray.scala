package Node

import scala.collection.mutable.ArrayBuffer

class ListArray[T <% Ordered[T]](val nodeSize: Int) {

  private var head: Node[T] = null
  private var tail: Node[T] = null
  private var size: Int = 0
  head = new Node[T](nodeSize)
  tail = head
  def this() {
    this(10)
  }

  def fill(values: Array[T]): Unit = {
    values.foreach(this.add(_))
  }

  def add(value: T): Unit = {
    try {
      tail.add(value)
      size += 1
    } catch {
      case e: ArrayStoreException =>
        val newNode = new Node[T](nodeSize)
        connectNodes(tail, newNode)
        tail = newNode
        this.add(value)
    }
  }

  @throws[ArrayIndexOutOfBoundsException]
  def removeLast(): Unit = {
    try {
      tail.removeLast()
      size -= 1
    } catch {
      case e: ArrayIndexOutOfBoundsException =>
        val newTail = tail.getPrev
        if (newTail == null) throw e
        newTail.setNext(null)
        tail.setPrev(null)
        tail = newTail
        this.removeLast()
    }
    if (tail.size == 0 && tail.getPrev != null) {
      val newTail = tail.getPrev
      newTail.setNext(null)
      tail = newTail
    }
  }

  @throws[ArrayIndexOutOfBoundsException]
  def getAt(index: Int): T = {
    if (index >= size) throw new ArrayIndexOutOfBoundsException
    val nodeNumber = index / nodeSize
    var node = head
    var i = 0
    while (i < nodeNumber) {
      node = node.getNext
      i += 1
    }
    node.getAt(index % nodeSize)
  }

  @throws[ArrayIndexOutOfBoundsException]
  def getLast: T = getAt(size - 1)

  @throws[ArrayIndexOutOfBoundsException]
  def setAt(value: T, index: Int): Unit = {
    if (index >= size) throw new ArrayIndexOutOfBoundsException
    val nodeNumber = index / nodeSize
    var node = head
    var i = 0
    while (i < nodeNumber) {
      node = node.getNext
      i += 1
    }
    node.setAt(value, index % nodeSize)
  }

  def getSize(): Int = size

  def clear(): Unit = {
    head = new Node[T](nodeSize)
    tail = head
    size = 0
  }

  def sort(desc: Boolean): Unit = {
    val asArr = this.toArray
    this.clear()
    asArr.sortWith(if (desc) _.compareTo(_)>0 else _.compareTo(_)<0)
      .foreach(this.add(_))
  }

  private def connectNodes(left: Node[T], right: Node[T]): Unit = {
    left.setNext(right)
    right.setPrev(left)
  }

  private def toArray: ArrayBuffer[T] = {
    val allValues = new ArrayBuffer[T](size)
    var node = head
    while ( node != null ) {
      var i = 0
      while ( i < node.getSize ) {
        allValues+= node.getAt(i)
        i += 1
      }
      node = node.getNext
    }
    allValues
  }
}
