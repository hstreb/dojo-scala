package com.example

import dispatch._, Defaults._

object Application {
  def main(args: Array[String]) = {
    val svc: Req = url("http://ilegra.com")
    val country: Future[String] = Http(svc OK as.String)
    for (c <- country) println(c)
  }
}