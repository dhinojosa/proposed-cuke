package com.evolutionnext.dsl

import cats.Applicative
import cats.data.StateT

type Step[F[_], Context] = StateT[F, Context, Unit]

object Step:

    def modify[F[_]: Applicative, C](f: C => C): Step[F, C] =
        StateT.modify(f)

    def inspect[F[_]: Applicative, C](f: C => Unit): Step[F, C] =
        StateT.inspect(f)

    def liftF[F[_]: Applicative, C](fa: F[Unit]): Step[F, C] =
        StateT.liftF(fa)
