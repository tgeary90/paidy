import java.time.{DayOfWeek, LocalDate}
import java.time.format.DateTimeFormatter

object PaidyQuestions {

  /*
  Question 1
   */
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

  /*
  Question 2
   */
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

  /*
  Question 3
   */
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
      val Suffix          = ".*(\\d-\\d{3}$)".r
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

  /*
  Question 4
   */

  /*
  My proudest achievement in programming was early on at my time at Quantexa. We needed to provide a single-sign-on (SSO) solution
  for customers wishing to integrate their Quantexa Platform with a 3rd party identity provider. Our platform would then provide
  authorized access based on the privileges received back from this 3rd party provider.
  SAML v2 was chosen as the federated SSO authentication mechanism. We had some prototype code that an analyst had written
  on a project but there was one problem - you couldnt logout. And it was worse, the current design did not allow for it. At this point
  3 other projects had stated that they wanted our custom authentication scheme deployed on their project.
  This was the point at which I joined the project.
  I am proud that i didnt panic and had the presence of mind to go back to the drawing board and redesign the feature.
  By preserving session state at the authentication gateway I added the ability to login and logout.
  I learned that no how dire the situation looks there is always a solution and its never a bad idea to hit the pause
  button and search for it before proceeding.
   */
}
