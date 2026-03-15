package com.evolutionnext.parser

import com.evolutionnext.gherkin.{Feature, Scenario, Step, StepKeyword}
import cats.parse.{Parser as P, Parser0 as P0}
import cats.*
import cats.implicits.*

val newline: P[Unit] = P.char('\n').void
val ws: P0[Unit] = P.charIn(" \t").rep0.void
val textLine: P0[String] = P.charsWhile0(_ != '\n')

val tag: P[String] =
    (P.char('@') *> P.charsWhile(c => !c.isWhitespace)).string

val featureHeader: P[String] =
    P.string("Feature:") *> ws *> textLine

val scenarioHeader: P[String] =
    P.string("Scenario:") *> ws *> textLine

val givenStep: P[Step] =
    (P.string("Given") *> ws *> textLine).map(s => Step(StepKeyword.Given, s))

val whenStep: P[Step] =
    (P.string("When") *> ws *> textLine).map(s => Step(StepKeyword.When, s))

val thenStep: P[Step] =
    (P.string("Then") *> ws *> textLine).map(s => Step(StepKeyword.Then, s))

val andStep: P[Step] =
    (P.string("And") *> ws *> textLine).map(s => Step(StepKeyword.And, s))

val butStep: P[Step] =
    (P.string("But") *> ws *> textLine).map(s => Step(StepKeyword.But, s))

val step: P[Step] =
    givenStep.orElse(whenStep).orElse(thenStep).orElse(andStep).orElse(butStep)

val scenario: P[Scenario] =
    ((scenarioHeader <* newline), (step <* newline).rep).mapN { (name, steps) =>
        //Scenario(name, steps.toList, Nil)
        ???
    }

val feature: P[Feature] =
    ((featureHeader <* newline), scenario.rep).mapN { (name, scenarios) =>
        //Feature(name, Nil, Nil, scenarios.toList)
        ???    
    }

object FeatureParser {
  def parse(content:String):Feature = {
     ???
  }
}
