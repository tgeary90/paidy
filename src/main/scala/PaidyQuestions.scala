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

  def mask(input: String): String = {
    val LocalPartPattern = "(\\w*)@\\w.*\\.*".r
    val PhoneNumPattern = "([\\d{9,} +]*)".r

    def obfuscateEmail(str: String): String = {
      if (str.length < 2) "*****"
      else {
        val startChar     = str.take(1)
        val endChar       = str.takeRight(1)
        List(startChar, "*****", endChar).mkString
      }
    }

    def obfuscatePhone(str: String): String = {
      val Suffix = ".*(\\d-\\d{3}$)".r
      val cleanedOfSpaces = str.replaceAll(" ", "-")
      val suffix = cleanedOfSpaces match {
        case Suffix(last4Digits) => last4Digits
      }
      val cleanedOfDigits = cleanedOfSpaces.replaceAll("\\d", "*")
      cleanedOfDigits.dropRight(5) + suffix
    }

    val masked = input match {
      case PhoneNumPattern(pn) => obfuscatePhone(pn)
      case LocalPartPattern(lpp) => input.replaceAll("\\w*@", obfuscateEmail(lpp) + "@")
    }
    masked
  }
}
