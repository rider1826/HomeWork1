import scala.io.Source
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import java.io.{FileOutputStream, PrintStream}

object Main extends App{

  case class NameCommon(common: String)

  case class InitialCountry(name: NameCommon,
                            capital: Seq[String],
                            region: String,
                            area: Double)

  case class ResultCountry(name: String,
                           capital: String,
                           area: Double)

  def source = Source.fromURL("https://raw.githubusercontent.com/mledoze/countries/master/countries.json")
    .getLines.mkString

  val res = decode[Seq[InitialCountry]](source)
    .map(c => c.filter(_.region.equals("Africa"))
      .map(i => ResultCountry(i.name.common, i.capital.iterator.next(), i.area))
      .sortWith(_.area > _.area)
      .take(10)
      .toList)

  val json = Encoder[List[ResultCountry]].apply(res.getOrElse(List()))
  val ps = new PrintStream(new FileOutputStream(args(0)))
  ps.println(json)
}
