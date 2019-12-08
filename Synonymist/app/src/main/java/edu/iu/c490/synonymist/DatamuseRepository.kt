package edu.iu.c490.synonymist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.iu.c490.synonymist.api.DatamuseApi
import edu.iu.c490.synonymist.GameFragment

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "DatamuseRepository"
//http://api.datamuse.com/words?rel_syn=forgetful would get all synonyms related to forgetful
private const val baseURL = "http://api.datamuse.com/"
private const val datamuseURL = "words?rel_syn="

/*
* baseURL is set up in the init function
* fun fetchDatamuseWord is called from in DatamuseApi interface
*   -it accepts a string (our dynamic URL)
* datamuseURL is our synonym path of the URL
* fetchRootWord random rootWord from rootWordListwhich is passed to the URL
*
*  */


class DatamuseRepository {
    val api: DatamuseApi

//    var n = 0 //Helper function used to increment indices at the same rate
//    fun increment(): Int{
//        if (n == 9){
//            n = 0
//        }
//        n++
//        return n
//    }
//
//        var rootWordList = mutableListOf(
//            "Bad", "Good", "Fine", "Friend", "Dingle", "Clean", "Dirty", "Rough", "Soft", "Poor"
//            //10 more
//        )
//        var removeRootWord = rootWordList.removeAt(0)
//        var rootWord = rootWordList.shuffled().take(1)[0]
//
//       // var rootWord = rootWordList.
//    val randomWordGenerator = RandomWordGenerator()
//    val root = RandomWordProvider(randomWordGenerator)


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(DatamuseApi::class.java)
    }




    /*
    * Gets word from list at index "word[x]"
    * response.body()!! - the !! makes it get created
    * */
    fun fetchWord(): LiveData<DatamuseWords> {

        val responseData = MutableLiveData<DatamuseWords>()
        val req = api.fetchDatamuseWords(datamuseURL + RandomWordGenerator().setRootWord())

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
        val req = api.fetchDatamuseWords(datamuseURL + RandomWordGenerator().setRootWord())

        //rootWordList.add(rootWordList.lastIndex+1)
        req.enqueue(object: Callback<List<DatamuseWords>> {
            override fun onFailure(call: Call<List<DatamuseWords>>, t: Throwable) {
                Log.e(TAG, "Could not fetch a word: ${t}")
            }

            override fun onResponse(call: Call<List<DatamuseWords>>, response: Response<List<DatamuseWords>>) {
                val word2 = response.body()!!
                Log.d(TAG, "Datamuse word: ${word2}}")
                responseData.value = word2[1]

//                val word2 = response.body()!!
//                responseData.value = word2[1]

            }

        })

        return responseData
    }



}