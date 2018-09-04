package test

import org.junit.Test
import java.util.*

/**
 * Created by mwu on 2018/9/4
 */

class TestDemo {
  @Test
  fun test() {
    val ll = LinkedList<String>()
    ll.add("a")
    ll.add("b")
    ll.add("e")
    ll.add("d")
    ll.sort()
    println(ll)
  }
}