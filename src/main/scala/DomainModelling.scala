object DomainModelling {

  // case classes
  case class Person(name: String, age: Int)

  val anne: Person = Person("Anne", 35)
  val anneName = anne.name
  val anneAge = anne.age
  val anneWithAmendedAge = anne.copy(age = 36)

  def greeting(person: Person): String = s"hi ${person.name}"
  greeting(anne)

  //enumeration research - not actually used in the video
  //https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html#enums
  enum CrustSize:
    case Small, Medium, Large

  import CrustSize.*
  val currentCrustSize = Small

  // if/then
  if currentCrustSize == Large then println("You get a prize!")

  // match
  currentCrustSize match
    case Small => println("small")
    case Medium => println("medium")
    case Large => println("large")

//  enum Color(val rgb: Int):
//    case Red extends Color(0xFF0000)
//    case Green extends Color(0x00FF00)
//    case Blue extends Color(0x0000FF)
//
//  import Color.*
//  val c = Red

// this is the code I actually show in the video
  enum TrafficLight:
    case Red, Amber, Green

  import TrafficLight.*
  def drivingSignal(light: TrafficLight): String =
    if light == Red then "Stop"
    else if light == Amber then "Get Ready"
    else "Go"

  def drivingSignal2(trafficLight: TrafficLight): String = trafficLight match {
    case Red => "Stop"
    case Amber => "Get Ready"
    case Green => "Go"
  }

  enum Triathlon(val metres: Int):
    case Swim extends Triathlon(400)
    case Cycle extends Triathlon(5000)
    case Run extends Triathlon(2500)

  import Triathlon.*
  def howManyMetres(triathlon: Triathlon): Int = triathlon match {
    case s @ Swim => s.metres
    case c @ Cycle => c.metres
    case r @ Run => r.metres
  }

  // challenge
  case class Country(name: String, population: Int)
  def population(country: Country): Int = country.population

  enum UnitedKingdom:
    case England, NorthernIreland, Scotland, Wales

  import UnitedKingdom.*
  val country = England
  if country == Scotland then println("we're in scotland!")

  def whereAmI(country: UnitedKingdom) = country match {
    case England => "I'm in England!"
    case NorthernIreland => "I'm in Northern Ireland!"
    case Scotland => "I'm in Scotland!"
    case Wales => "I'm in Wales!"
  }

  // actual challenge used
  case class TicketPrice(standardTicketPrice: Int, firstClassTicketPrice: Option[Int])

  def getFirstClassTicketPrice(ticketPrice: Option[TicketPrice]): Option[Int] =
    ticketPrice.flatMap(_.firstClassTicketPrice)

  def getFirstClassTicketPrice2(ticketPrice: Option[TicketPrice]): Option[Int] =
    for
      t <- ticketPrice
      firstClassPrice <- t.firstClassTicketPrice
    yield firstClassPrice
  end getFirstClassTicketPrice2

  val londonToParis = TicketPrice(100, Some(200))
  println(getFirstClassTicketPrice2(Some(londonToParis)))

  //more code ideas that I'm not using
  enum Continent(val population: Int):
    case Africa extends Continent(000)
    case America extends Continent(000)
    case Antarctica extends Continent(000)
    case Asia extends Continent(000)
    case Europe extends Continent(000)

  import Continent.*
  def population2(c: Continent): String = c match
    case africa @ Africa => s"Africa has a population of ${africa.population}"
    case america @ America => s"America has a population of ${america.population}"
    case antarctica @ Antarctica => s"Antarctica has a population of ${antarctica.population}"
    case asia @ Asia => s"Asia has a population of ${asia.population}"
    case europe @ Europe => s"Europe has a population of ${europe.population}"
  end population2
}
