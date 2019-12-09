package edu.iu.c490.synonymist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.iu.c490.synonymist.api.DatamuseApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "DatamuseRepository"
private const val baseURL = "http://api.datamuse.com/"
private const val datamuseURL = "words?rel_syn="

/**
 * -baseURL is set up in the init function
 * -datamuseURL is our synonym path of the URL
 * -RandomWordGenerator.setRootWord() gets a random word which is passed to the URL*
 * -fun fetchDatamuseWord is called from in DatamuseApi interface and
 *  accepts a string (RandomWordGenerator.setRootWord())
 *  -Thus, baseURL + synonymURL + RandomWordGenerator.setRootWord() =
 *  "http://api.datamuse.com/words?rel_syn=<randomWord>"
**/
class DatamuseRepository {
    val api: DatamuseApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(DatamuseApi::class.java)
    }


    /*
    * Gets word from json data at index [n] of the array
    * Creates a response for use in GameFragment
    **/
    fun fetchWord(): LiveData<DatamuseWords> {

        val responseData = MutableLiveData<DatamuseWords>()
        val req = api.fetchDatamuseWords(datamuseURL + RandomWordGenerator().fetchRandomWord())

        //rootWordList.add(rootWordList.lastIndex+1)
        req.enqueue(object: Callback<List<DatamuseWords>> {
            override fun onFailure(call: Call<List<DatamuseWords>>, t: Throwable) {
                Log.e(TAG, "Could not fetch a word: ${t}")
            }

            override fun onResponse(call: Call<List<DatamuseWords>>, response: Response<List<DatamuseWords>>) {
                val word = response.body()!!
                Log.d(TAG, "Datamuse word: ${word}}")
                responseData.value = word[0]

//                val word2 = response.body()!!
//                responseData.value = word2[1]
            }

        })

        return responseData
    }

    fun fetchWord2(): LiveData<DatamuseWords> {

        val responseData = MutableLiveData<DatamuseWords>()
        val req = api.fetchDatamuseWords(datamuseURL + RandomWordGenerator().fetchRandomWord())

        //rootWordList.add(rootWordList.lastIndex+1)
        req.enqueue(object: Callback<List<DatamuseWords>> {
            override fun onFailure(call: Call<List<DatamuseWords>>, t: Throwable) {
                Log.e(TAG, "Could not fetch a word: ${t}")
            }

            override fun onResponse(call: Call<List<DatamuseWords>>, response: Response<List<DatamuseWords>>) {
                val word2 = response.body()!!
                Log.d(TAG, "Datamuse word: ${word2}}")
                responseData.value = word2[1]
            }

        })

        return responseData
    }

    fun fetchWord3(): LiveData<DatamuseWords> {

        val responseData = MutableLiveData<DatamuseWords>()
        val req = api.fetchDatamuseWords(datamuseURL + RandomWordGenerator().fetchRandomWord())

        //rootWordList.add(rootWordList.lastIndex+1)
        req.enqueue(object: Callback<List<DatamuseWords>> {
            override fun onFailure(call: Call<List<DatamuseWords>>, t: Throwable) {
                Log.e(TAG, "Could not fetch a word: ${t}")
            }

            override fun onResponse(call: Call<List<DatamuseWords>>, response: Response<List<DatamuseWords>>) {
                val word3 = response.body()!!
                Log.d(TAG, "Datamuse word: ${word3}}")
                responseData.value = word3[2]
            }

        })

        return responseData
    }

    fun fetchWord4(): LiveData<DatamuseWords> {

        val responseData = MutableLiveData<DatamuseWords>()
        val req = api.fetchDatamuseWords(datamuseURL + RandomWordGenerator().fetchRandomWord())

        //rootWordList.add(rootWordList.lastIndex+1)
        req.enqueue(object: Callback<List<DatamuseWords>> {
            override fun onFailure(call: Call<List<DatamuseWords>>, t: Throwable) {
                Log.e(TAG, "Could not fetch a word: ${t}")
            }

            override fun onResponse(call: Call<List<DatamuseWords>>, response: Response<List<DatamuseWords>>) {
                val word4 = response.body()!!
                Log.d(TAG, "Datamuse word: ${word4}}")
                responseData.value = word4[3]
            }

        })

        return responseData
    }

    fun fetchWord5(): LiveData<DatamuseWords> {

        val responseData = MutableLiveData<DatamuseWords>()
        val req = api.fetchDatamuseWords(datamuseURL + RandomWordGenerator().fetchRandomWord())

        //rootWordList.add(rootWordList.lastIndex+1)
        req.enqueue(object: Callback<List<DatamuseWords>> {
            override fun onFailure(call: Call<List<DatamuseWords>>, t: Throwable) {
                Log.e(TAG, "Could not fetch a word: ${t}")
            }

            override fun onResponse(call: Call<List<DatamuseWords>>, response: Response<List<DatamuseWords>>) {
                val word = response.body()!!
                Log.d(TAG, "Datamuse word: ${word}}")
                responseData.value = word[4]
            }

        })

        return responseData
    }


}