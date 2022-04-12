package com.soumen.leetcodesolutions
package simple.baseballgame

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class BaseballGameTest extends AnyFreeSpec with should.Matchers {
  val baseballGame = BaseballGame
  "Baseball Game calculator" - {
    "calculate simple array" in {
      baseballGame.calPoints(Array("1")) should be(1)
    }
    "calculate array with positive integers" in {
      baseballGame.calPoints(Array("5", "2", "C", "D", "+")) should be(30)
    }
    "calculate array with negative integers" in {
      baseballGame.calPoints(Array("5", "-2", "4", "C", "D", "9", "+", "+")) should be(27)
    }
  }
}
