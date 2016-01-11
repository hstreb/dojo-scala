import com.example.{LinkFilter, HtmlParser}
import org.scalatest._

class ApplicationSpec extends FlatSpec with Matchers {
  "HtmlParser" should "parse a link" in {
    //given a html with link
    val givenLink = "<a href='something'>content</a>"
    val expectedLinks = Seq("something")
    val parser = HtmlParser
    //parse the html
    val result = parser.parse(givenLink)
    //should return collection of links
    result should  === (expectedLinks)
  }

  "HtmlParser" should "parse more than one link" in {
    //given a html with link
    val givenLinks = "<a href='something'>content</a><a href='nothing'>content</a>"
    val expectedLinks = Seq("something", "nothing")
    val parser = HtmlParser
    //parse the html
    val result = parser.parse(givenLinks)
    //should return collection of links
    result should  === (expectedLinks)
  }

  "LinkFilter" should "filter links" in {
    //given a html with link
    val givenLinks = Seq("something", "nothing")
    val expectedLinks = Seq("something")
    val filter = LinkFilter
    //parse the html
    val result = filter.filter(givenLinks, "something")
    //should return collection of links
    result should  === (expectedLinks)
  }

}
