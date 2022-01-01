object Option {
  val middleName: Option[String] = None
  val middleName2: Option[String] = Some("Muna")
  middleName2.getOrElse("").length

  middleName2.map(word => word.toUpperCase)

  case class Rating(googleRating: Option[Int], netflixRating: Option[Int])

  case class Film(name: String, rating: Option[Rating])

  val mulan: Film = Film("Mulan", Some(Rating(Some(2), Some(4))))

  mulan.rating.map(rating => rating.googleRating).flatten

  mulan.rating.flatMap(rating => rating.googleRating)

  val averageRating1 = for {
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    if googleRating > 3
    averageRating = (googleRating + netflixRating) / 2
  } yield netflixRating

  val averageRating2 = for
    rating <- mulan.rating
    googleRating <- rating.googleRating
    netflixRating <- rating.netflixRating
    averageRating = (googleRating + netflixRating) / 2
   yield averageRating
  end averageRating2

  // challenge
  case class TicketPrice(
     standardTicketPrice: Int, 
     firstClassTicketPrice: Option[Int]
  )
  def getFirstClassTicketPrice(ticket: Option[TicketPrice]): Option[Int] = 
    ticket.flatMap(_.firstClassTicketPrice)
  def getFirstClassTicketPrice2(ticket: Option[TicketPrice]): Option[Int] =
    for
      t <- ticket
      firstClassPrice <- t.firstClassTicketPrice
    yield firstClassPrice
  end getFirstClassTicketPrice2
  
  val londonToParis = TicketPrice(100, Some(200))
}
