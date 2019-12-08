package edu.iu.c490.synonymist.api

import android.provider.ContactsContract
import edu.iu.c490.synonymist.DatamuseWords
import edu.iu.c490.synonymist.DatamuseRepository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface DatamuseApi {
    @GET
    fun fetchDatamuseWords(
        @Url url: String
    ): Call<List<DatamuseWords>>
}

