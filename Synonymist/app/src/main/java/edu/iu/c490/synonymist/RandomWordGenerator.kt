package edu.iu.c490.synonymist

/**
*Class gets a random word from randomWordList and stores it in randomWord (Intent to call fetchRootWord).
**/
class RandomWordGenerator {
    var randomWordList = listOf(
        "Healthy",  "Ugly",  "Hell", "Hard", "Smooth", "Game", "Sport", "Chunk", "Smell", "Sick",
        "Salty", "Air", "Grass", "Fly", "Jump", "Existence", "Being", "Love", "Small", "Intense"
    )

    var randomWord = String()

    fun fetchRandomWord(): String {
        //contains the word at index 0 of the shuffled array
        randomWord = randomWordList.shuffled().take(1)[0]
        return randomWord
    }

}