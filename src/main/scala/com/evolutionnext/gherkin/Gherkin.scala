package com.evolutionnext.gherkin

case class Background(
    name: Option[String],
    steps: List[Step]
)

final case class Feature(
    tags: List[Tag],
    name: String,
    description: List[String],
    background: Option[Background],
    children: List[FeatureChild]
)

final case class Scenario(
    tags: List[Tag],
    name: String,
    steps: List[Step]
)

enum InterpolatedTextPart:
  case Literal(value: String)
  case Placeholder(name: String)

final case class InterpolatedText(parts: List[InterpolatedTextPart])

final case class InterpolatedStep(
    keyword: StepKeyword,
    text: InterpolatedText,
    table: Option[Table] = None
)

final case class Example(table: Table)

final case class ScenarioOutline(
    tags: List[Tag],
    name: String,
    steps: List[InterpolatedStep],
    examples: List[Example]
)

enum FeatureChild:
    case ScenarioCase(value: Scenario)
    case ScenarioOutlineCase(value: ScenarioOutline)

final case class Tag(value: String)

final case class Step(
    keyword: StepKeyword,
    text: String,
    table: Option[Table] = Option.empty[Table]
)

final case class Cell(
    string: String
)
final case class Row(
    cells: Cell*
)

final case class Header(
    cells: Cell*
)

final case class Table(
    row: Row*
)

enum StepKeyword {
  case Given, When, Then, And, But
}
