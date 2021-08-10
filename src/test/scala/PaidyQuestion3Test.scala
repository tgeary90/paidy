class PaidyQuestion3Test extends org.scalatest.funsuite.AnyFunSuite {

  test("Should mask phone number") {
    assert(PaidyQuestions.mask("+44 123 456 789") === "+**-***-**6-789")
  }

  test("Should mask an email") {
    assert(PaidyQuestions.mask("tgeary90@hotmail.co.uk") === "t*****0@hotmail.co.uk")
  }
}
