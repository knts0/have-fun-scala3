package exercise.chapter3

import Question1.given

/** Question: ExtensionMethods */
object Question3:

  extension [T](x: T)
    def < (y: T)(using ord: Ord[T]): Boolean = ord.compare(x, y) == -1
    def > (y: T)(using ord: Ord[T]): Boolean = ord.compare(x, y) == 1

  // これもOK
//  extension [T](x: T)
//    def < (y: T)(using Ord[T]): Boolean = summon[Ord[T]].compare(x, y) == -1
//    def > (y: T)(using Ord[T]): Boolean = summon[Ord[T]].compare(x, y) == 1

  extension [T](list: List[T])
    // 名前つけなくてもQuestion2のmaxに渡される
    def max(using Ord[T]): T = {
      Question2.max(list)
    }

end Question3
