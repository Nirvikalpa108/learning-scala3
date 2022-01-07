object ControlFlow {
  def partyAtHome(guests: Int, tentAvailable: Boolean): Boolean =
    if guests < 15 then true
    else if tentAvailable && guests < 40 then true
    else false

  def partyAtHomeResponse(response: Boolean): String = response match
    case true => "Let's get this party started!"
    case false => "Let's find another venue for the party!"

  def partyAtHomeAgain(guests: Int, tentAvailable: Boolean): Boolean = guests match
    case g if g < 15 => true
    case g if g < 40 && tentAvailable => true
    case _ => false

  def weather(sunny: Boolean): String = sunny match
    case true => "yay! Where are my sunglasses?"
    case false => "oh where is my umbrella?"

  def greeting(friend: String): String = friend match
    case "Ada" => "hi Ada!"
    case "Deji" => "hi Deji!"
    case _ => "hi! What's your name?"

  def greeting2(friend: String): String = friend match
    case "Ada" | "Deji" => "hi my friend! Long time no see!"
    case newFriend => s"hi $newFriend! It's so nice to meet you!"

  // Challenge
  // competition
  // result :  Int
  // : String
  // 1 -> gold
  // 2 -> silver
  // 3 -> bronze
  // _ -> well done!

  // Solution
  def competition(result: Int): String =
    if result == 1 then "gold"
    else if result == 2 then "silver"
    else if result == 3 then "bronze"
    else "well done!"

  def competition2(result: Int): String = result match
    case 1 => "gold"
    case 2 => "silver"
    case 3 => "bronze"
    case _ => "well done!"
}
