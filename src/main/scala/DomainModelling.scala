import DomainModelling.TriathlonDistance.Swim

object DomainModelling {

  // case classes
  case class Person(name: String, age: Int)

  val anne: Person = Person("Anne", 35)
  val anneName = anne.name
  val anneAge = anne.age
  val anneWithAmendedAge = anne.copy(age = 36)

  def greeting(person: Person): String = s"hi ${person.name}"
  greeting(anne)

  //enumeration
  //https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html#enums
  enum CrustSize:
    case Small, Medium, Large

  import CrustSize.*
  val currentCrustSize = Small

  // if/then
  if (currentCrustSize == Large)
    println("You get a prize!")

  // match
  currentCrustSize match
    case Small => println("small")
    case Medium => println("medium")
    case Large => println("large")

  enum Color(val rgb: Int):
    case Red extends Color(0xFF0000)
    case Green extends Color(0x00FF00)
    case Blue extends Color(0x0000FF)

  import Color.*
  val c = Red

  // my examples
  enum UnitedKingdom:
    case England, northernIreland, Scotland, Wales

  enum TriathlonDistance(val metres: Int):
    case Swim extends TriathlonDistance(400)
    case Cycle extends TriathlonDistance(10000)
    case Run extends TriathlonDistance(2500)

  val triSwim = Swim

  //enum - if statement
  import TriathlonDistance.*
  def triathlon(tri: TriathlonDistance): String =
    if tri == Run then "let's run!"
    else if tri == Cycle then "let's cycle!"
    else "let's swim!"

  //enum - match statement
  def triathlon2(triathlon: TriathlonDistance): String = triathlon match {
    case s @ Swim => s"let's swim ${s.metres}!"
    case c @ Cycle => s"let's cycle ${c.metres}!"
    case r @ Run => s"let's run ${r.metres}!"
  }

  // challenge
  case class Country(name: String, capital: String, population: Int)
  def population(country: Country): Int = country.population
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
