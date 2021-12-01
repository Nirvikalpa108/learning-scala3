import DomainModelling.TriathlonDistance

@main def hello: Unit =
  println(DomainModelling.triathlon(TriathlonDistance.Run))
  println(DomainModelling.population2(DomainModelling.Continent.Africa))

object Example {
  case class Rating(googleRating: Option[Int], netflixRating: Option[Int])

  case class Film(name: String, rating: Option[Rating])

  val mulan: Film = Film("Mulan", Some(Rating(Some(2), Some(4))))

  val averageRating = for {
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    if googleRating > 1
    averageRating = (googleRating + netflixRating) / 2
  } yield averageRating
}



















