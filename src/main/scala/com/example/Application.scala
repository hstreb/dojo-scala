package com.example

import dispatch._, Defaults._

object Application {
  def main(args: Array[String]) = {
  }
}

object HtmlParser {

  def parse(text: String) = {
    val pattern = "(?<=href=[\"']).*?(?=[\"'])".r
    (pattern findAllIn text).toList
  }
}

object LinkFilter {
  def filter(links: Seq[String], word: String): Seq[String] = {
    links.filter(l => l.contains(word))
  }

}

object SearchFilter {
    def search(query: String, word: String): Future[Seq[String]] = {
      val svc: Req = url("http://google.com?q=" + query)
      val html: Future[String] = Http(svc OK as.String)
      html.map(s => HtmlParser.parse(s))
        .map(c => LinkFilter.filter(c, word))
    }

}
