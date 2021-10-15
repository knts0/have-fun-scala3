package exercise.chapter3

/** Question: Using Ord */
object Question2:
  def max[T: Ord](list: List[T])(using ev: Ord[T]): T =
    if list.isEmpty then throw new IllegalArgumentException()
    list.reduce { (acc, item) =>
      val cmp = ev.compare(acc, item)
      if cmp < 0 then item
      else acc
    }
end Question2
