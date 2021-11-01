object DomainModelling {
  //https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html#enums
  //https://www.47deg.com/blog/scala-3-enumerations/
  //https://alvinalexander.com/scala/example-enums-in-scala-3-dotty-match-expression/
  enum PartyVenue:
    case Home extends PartyVenue
    case Restaurant extends PartyVenue
    case Hall extends PartyVenue


  // why isn't the compiler happy?
  // It could auto complete the match statement for me, so what went wrong??
//  def tmp(venue: PartyVenue): String = venue match {
//    case h: Home => "???"
//    case r: Restaurant => "???"
//    case h: Hall => "???"
//  }

}
