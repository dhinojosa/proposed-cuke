package com.evolutionnext.parser

import cats.effect.*
import cats.effect.unsafe.implicits.global
import com.evolutionnext.gherkin.Feature

import scala.io.{BufferedSource, Source}

class FeatureParserSuite extends munit.FunSuite {
    test("canary test") {
        assert(true)
    }
    test("read in 000-basic-scenario.feature content") {
        val io:IO[String] = {
            Resource.make(IO(Source.fromResource("000-basic-scenario.feature")))(source =>
                    IO(source.close()))
                .use(source => IO(source.mkString))
        }

        val content = io.unsafeRunSync()
        assert(content.nonEmpty)
        assert(content.contains("Feature: Basic arithmetic"))
    }
    test("read in 000-basic-scenario.feature") {
        val io: IO[String] = {
            Resource.make(IO(Source.fromResource("000-basic-scenario.feature")))(source =>
                    IO(source.close()))
                .use(source => IO(source.mkString))
        }

        val content = io.unsafeRunSync()
        val feature:Feature = FeatureParser.parse(content)

        assert(feature.name == "Basic arithmetic")
    }
}
