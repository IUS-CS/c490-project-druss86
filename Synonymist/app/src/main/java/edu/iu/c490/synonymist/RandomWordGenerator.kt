package edu.iu.c490.synonymist

/*Class gets a random word from rootWordList and stores it in rootWord (Call fetchRootWord).*/
class RandomWordGenerator {
    var rootWordList = listOf(
        "Bad", "Good", "Fine", "Friend", "Dingle", "Clean", "Dirty", "Rough", "Soft", "Poor"
        //10 more
    )

    var rootWord = String()

    fun setRootWord(): String {

        rootWord = rootWordList.shuffled().take(1)[0]
        return rootWord //contains the word at index 0 of the shuffled array
    }

    fun fetchRootWord(): String {
        return rootWord
    }

}