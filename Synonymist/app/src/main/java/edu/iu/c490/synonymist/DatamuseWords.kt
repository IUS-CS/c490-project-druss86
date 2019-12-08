package edu.iu.c490.synonymist

import com.google.gson.annotations.SerializedName

class DatamuseWords {

    //"word" below is the json identifier from the api.  It will get the "word" from the api
    // and store it,  vars below store info from request for use in GameFragment
    @SerializedName("word")
    lateinit var synonymDatamuseWords: String


}