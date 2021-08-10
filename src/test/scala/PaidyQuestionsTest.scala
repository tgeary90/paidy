class PaidyQuestionsTest extends org.scalatest.funsuite.AnyFunSuite {

  test("SuffixTest_1st") {
    assert(PaidyQuestions.ordinalSuffix(1)        === "1st")
    assert(PaidyQuestions.ordinalSuffix(101)      === "101st")
    assert(PaidyQuestions.ordinalSuffix(23412341) === "23412341st")
    assert(PaidyQuestions.ordinalSuffix(11)       === "11th")
    assert(PaidyQuestions.ordinalSuffix(11010101) === "11010101st")
  }

  test("SuffixTest_2nd") {
    assert(PaidyQuestions.ordinalSuffix(2)        === "2nd")
    assert(PaidyQuestions.ordinalSuffix(22)       === "22nd")
    assert(PaidyQuestions.ordinalSuffix(20202)    === "20202nd")
    assert(PaidyQuestions.ordinalSuffix(12)       === "12th")
    assert(PaidyQuestions.ordinalSuffix(2)        === "2nd")

  }

  test("SuffixTest_3rd") {
    assert(PaidyQuestions.ordinalSuffix(3)        === "3rd")
    assert(PaidyQuestions.ordinalSuffix(13)       === "13th")
    assert(PaidyQuestions.ordinalSuffix(333)      === "333rd")
    assert(PaidyQuestions.ordinalSuffix(123)      === "123rd")
    assert(PaidyQuestions.ordinalSuffix(303033)   === "303033rd")
  }

  test("SuffixTest_4th_and_up") {
    assert(PaidyQuestions.ordinalSuffix(4)        === "4th")
    assert(PaidyQuestions.ordinalSuffix(5)        === "5th")
    assert(PaidyQuestions.ordinalSuffix(2349)     === "2349th")
  }

  test("SuffixTest_negative_and_zero") {
    assert(PaidyQuestions.ordinalSuffix(-1)       === "-1st")
    assert(PaidyQuestions.ordinalSuffix(-22)      === "-22nd")
    assert(PaidyQuestions.ordinalSuffix(0)        === "0th")
  }
}
