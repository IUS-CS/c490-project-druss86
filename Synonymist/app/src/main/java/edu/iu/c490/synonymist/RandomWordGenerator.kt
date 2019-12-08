package edu.iu.c490.synonymist

/*Class gets a random word from rootWordList and stores it in rootWord (Call fetchRootWord).*/
class RandomWordGenerator {
    var randomWordList = listOf(
        "Healthy",  "Ugly",  "Hell", "Hard", "Smooth", "Game", "Sport", "Chunk", "Smell", "Sick",
        "Salty", "Air", "Grass", "Fly", "Jump", "Existence", "Being", "Love", "Small", "Intense"
    )

    var rootWord = String()

    fun setRootWord(): String {

        rootWord = randomWordList.shuffled().take(1)[0]
        return rootWord //contains the word at index 0 of the shuffled array
    }

    fun fetchRootWord(): String {
        return rootWord
    }

}