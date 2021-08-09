object PaidyQuestions {

  def ordinalSuffix(x: Int): String = {
    def go(chars: List[Char]): String =
      chars match {
        case h :: Nil if h == '1' => x.toString + "st"
        case h :: Nil if h == '2' => x.toString + "nd"
        case h :: Nil if h == '3' => x.toString + "rd"
        case _ :: Nil             => x.toString + "th"
        case _ :: tail            => go(tail)
      }
    go(x.toString.toList)
  }
}
