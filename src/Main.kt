fun main() {
    val pets = mutableListOf<String>()

    // Some test data
    pets.add("Dog")
    pets.add("Beaver")
    pets.add("Newt")

    while (true) {
        // Show the current pets
        show(pets)

        // Get user action
        val action = menu()

        // Act upon it
        when (action) {
            'Q' -> break
            'A' -> getNewPet(pets)
//            'D' -> deletePet()
        }
    }
}


/**
 * Get a pet name from the user and
 * add to the given list of pets
 */
fun getNewPet(pets: MutableList<String>) {
    val newPet = getString("New pet: ")
    pets.add(newPet)
}


/**
 * Show a menu and get the user's
 * choice. Return this as a Char
 */
fun menu(): Char {
    println("[A]dd a new pet")
    println("[D]elete a pet")
    println("[Q]uit")

    val validChoices = "ADQ"

    while (true) {
        print("Choice: ")
        val input = readln()

        // Typed nothing? Try again!
        if (input.isBlank()) continue

        // Grab the first letter
        val choice = input.uppercase().first()

        // Check it is a valid option
        if (validChoices.contains(choice)) return choice
    }
}

/**
 * Show a given list with numbered
 * entries (from 1 upwards)
 */
fun show(list: List<Any>){
    for ((i, item) in list.withIndex()) {
        println("${i+1}: $item")
    }
}


/**
 * Function to get a string from the user
 *
 * parameters:
 *   - prompt - Text to show the user
 * returns:
 *   - String that the user types
 */
fun getString(prompt: String): String {
    var userInput: String

    while(true) {
        print(prompt)

        userInput = readln()
        if (userInput.isNotBlank()) break
    }

    return userInput
}