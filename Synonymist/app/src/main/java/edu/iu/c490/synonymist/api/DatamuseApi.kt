package edu.iu.c490.synonymist.api

import android.provider.ContactsContract
import edu.iu.c490.synonymist.DatamuseWords
import edu.iu.c490.synonymist.DatamuseRepository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

/**
 * Use in presentation with the link found, talking about dynamic urls.  Path vs GET
 */
interface DatamuseApi {
    @GET
    fun fetchDatamuseWords(
        @Url url: String
    ): Call<List<DatamuseWords>>
}

