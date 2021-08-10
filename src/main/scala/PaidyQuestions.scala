import java.time.{DayOfWeek, LocalDate}
import java.time.format.DateTimeFormatter

object PaidyQuestions {

  def ordinalSuffix(x: Int): String = {
    def go(chars: List[Char]): String =
      chars match {
        case h :: Nil if h == '1'         => x.toString + "st"
        case h :: Nil if h == '2'         => x.toString + "nd"
        case h :: Nil if h == '3'         => x.toString + "rd"
        case h :: _ :: Nil if h == '1'    => x.toString + "th"
        case _ :: Nil                     => x.toString + "th"
        case _ :: tail                    => go(tail)
      }
    go(x.toString.toList)
  }

  def sundays(start: String, end: String): Int = {
    val df: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val startDt: LocalDate    = LocalDate.parse(start, df)
    val endDt: LocalDate      = LocalDate.parse(end, df)

    def go(dt: LocalDate): Int = {
      if (dt.isBefore(endDt) || dt.isEqual(endDt)) {
        if (dt.getDayOfWeek == DayOfWeek.SUNDAY) go(dt.plusDays(1)) + 1
        else go(dt.plusDays(1)) + 0
      } else 0
    }
    go(startDt)
  }
}
