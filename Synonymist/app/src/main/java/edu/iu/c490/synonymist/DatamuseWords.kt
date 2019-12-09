package edu.iu.c490.synonymist

import com.google.gson.annotations.SerializedName

/**
 * "word" below is the json identifier passed to the api so we choose the correct portion of the json array.
 * It will get the "word" from the api and store it in randomDatamuseWord for use in GameFragment.
 **/
class DatamuseWords {
    @SerializedName("word")
    lateinit var randomDatamuseWord: String
}