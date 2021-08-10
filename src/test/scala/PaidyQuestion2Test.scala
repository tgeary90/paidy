class PaidyQuestion2Test extends org.scalatest.funsuite.AnyFunSuite {

  test("SundaysCountTest_5_sundays_between_1st_may_and_30th_may") {
    assert(PaidyQuestions.sundays("01-05-2021", "30-05-2021") === 5)
  }

  test("SundaysCountTest_1_sunday_between_now_and_next_monday") {
    assert(PaidyQuestions.sundays("10-08-2021", "17-08-2021") === 1)
  }

  test("SundaysCountTest_4_sundays_in_June_2021") {
    assert(PaidyQuestions.sundays("01-06-2021", "30-06-2021") === 4)
  }

  test("SundaysCountTest_53_sundays_in_2021") {
    assert(PaidyQuestions.sundays("01-01-2021", "31-12-2021") === 52)
  }
}
