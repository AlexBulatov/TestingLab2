package Node

import scala.collection.mutable.ArrayBuffer


class Node[T <% Ordered[T]](val size: Int) {

  private var arr: ArrayBuffer[T] = new ArrayBuffer[T]()
  private var next: Node[T] = null
  private var prev: Node[T] = null
  next = null

  def this(){
    this(10)
  }

  def setNext(_next: Node[T]): Unit = {
    next = _next
  }

  def getNext: Node[T] = next

  @throws[ArrayStoreException]
  def add(value: T): T = {
    if (arr.size == size) throw new ArrayStoreException
    arr+=value
    value
  }

  @throws[ArrayIndexOutOfBoundsException]
  def getAt(index: Int): T = arr(index)

  @throws[ArrayIndexOutOfBoundsException]
  def setAt(value: T, index: Int): T = {
    arr(index)=value
    value
  }

  @throws[ArrayIndexOutOfBoundsException]
  def removeLast(): Unit = {
    removeAt(size - 1)
  }

  @throws[ArrayIndexOutOfBoundsException]
  def removeAt(index: Int): T = arr.remove(index)

  def getSize: Int = arr.size

  def getPrev: Node[T] = prev

  def setPrev(prev: Node[T]): Unit = {
    this.prev = prev
  }
}