package test

import org.junit.Test
import java.util.*

/**
 * Created by mwu on 2018/9/4
 */

class TestDemo {
  //  @Test
  fun testHashMap() {
    val hll: HashMap<String, LinkedList<Int>> = hashMapOf()
    hll["a"] = LinkedList()
    hll["a"]?.add(1)
    hll["a"]?.add(2)
    hll["a"]?.add(3)
    println(hll.containsKey("a"))
    val list = hll.getOrPut("a") {
      LinkedList()
    }
    list.add(4)
    list.add(5)
    list.add(6)
    println(hll["a"])
  }

  @Test
  fun testEnum() {
//    val state = MapObjectStateEnum.FIRE.value
//    val s = MapObjectStateEnum.NONE
//    println(state)
//    println(s.value)
//    println(state.or(s.value))
//    MapObjectStateEnum.values().forEach {
//      println("${MapObjectStateEnum.valueOf(it.name)} --> ${it.value}")
//    }

    println(TestDemo::class.java.simpleName)
  }
}

enum class MapObjectStateEnum(val value: Int = 0) {
  NONE(0),
  SHIELD(1), // 开盾
  FIRE(1.shl(1)), //冒火
  PRISON(1.shl(2)), //有囚犯
  PARK(1.shl(3)), //
  PEACE(1.shl(4)), //奇观状态，此位=1为和平期，=0为战争期
  SMOKE(1.shl(5)); //冒烟
}