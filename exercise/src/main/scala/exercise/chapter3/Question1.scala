package exercise.chapter3

/** Question: Ord instance */
object Question1:
  given Ord[Int] with
    def compare(x: Int, y: Int): Int =
      if (x < y)
        -1
      else if (x > y)
        1
      else
        0

//  given Max[Int] with
//    def max(x: Int, y: Int): Int =
//      if (x <= y)
//        y
//      else
//        x

// こういう感じでもOK
//      if x < y then -1
//      else if x == y then 0
//      else 1

  given [T: Ord]: Ord[Option[T]] with
    def compare(xOpt: Option[T], yOpt: Option[T]): Int =
      (xOpt, yOpt) match {
        case (Some(x), Some(y)) => summon[Ord[T]].compare(x, y)
        case (Some(x), None) => 1
        case (None, Some(y)) => -1
        case (None, None) => 0
      }

  // usingパターン使った版
//  given [T: Ord](using ord: Ord[T]): Ord[Option[T]] with
//    def compare(xOpt: Option[T], yOpt: Option[T]): Int =
//      (xOpt, yOpt) match {
//        case (Some(x), Some(y)) => ord.compare(x, y)
//        case (Some(x), None   ) => 1
//        case (None,    Some(y)) => -1
//        case (None,    None)    => 0
//      }
end Question1
