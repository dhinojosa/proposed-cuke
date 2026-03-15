package com.evolutionnext.gherkin

final case class Feature(
                          tags: List[Tag],
                          name: String,
                          description: List[String],
                          scenarios: List[Scenario]
                        )

final case class Scenario(
                           tags: List[Tag],
                           name: String,
                           steps: List[Step]
                         )

final case class Tag(value: String)

final case class Step(
                       keyword: StepKeyword,
                       text: String
                     )

enum StepKeyword:
  case Given, When, Then, And, But