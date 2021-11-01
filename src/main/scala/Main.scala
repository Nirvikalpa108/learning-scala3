@main def hello: Unit =
  println("Hello World")
  println(competition(2))
  println(competition2(3))

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















