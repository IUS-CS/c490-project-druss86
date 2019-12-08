package edu.iu.c490.synonymist

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import edu.iu.c490.synonymist.DatamuseRepository
import edu.iu.c490.synonymist.RandomWordGenerator
import kotlinx.android.synthetic.main.fragment_synonymist.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private const val TAG = "GameFragment"

class GameFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_synonymist, container, false)

        val rootWordButton = view.findViewById<Button>(R.id.rootWord)
        val topLeftButton = view.findViewById<Button>(R.id.topLeft)
        val topRightButton = view.findViewById<Button>(R.id.topRight)
        val topLeftMiddleButton = view.findViewById<Button>(R.id.topLeftMiddle)
        val topRightMiddleButton = view.findViewById<Button>(R.id.topRightMiddle)
        val bottomLeftMiddleButton = view.findViewById<Button>(R.id.bottomLeftMiddle)
        val bottomRightMiddleButton = view.findViewById<Button>(R.id.bottomRightMiddle)
        val bottomLeftButton = view.findViewById<Button>(R.id.bottomLeft)
        val bottomRightButton = view.findViewById<Button>(R.id.bottomRight)

        updateButtonText(
            topLeftButton, topRightButton,
            topLeftMiddleButton, topRightMiddleButton,
            bottomLeftMiddleButton, bottomRightMiddleButton,
            bottomLeftButton, bottomRightButton)

        rootWordButton.setOnClickListener {

            updateButtonText(
                topLeftButton, topRightButton,
                topLeftMiddleButton, topRightMiddleButton,
                bottomLeftMiddleButton, bottomRightMiddleButton,
                bottomLeftButton, bottomRightButton)

            updateRootButtonText(rootWordButton)

        }

        /*Change this line, updateRootButtonText and rootWordList indexing to loop through the list
        * This line is necessary to get root word text initially otherwise it displays buton until
        * it is clicked (until rootWordButton.setOnClickListener is made.  This line may not actually
        * need to be altered since it only happens one time.*/
        rootWordButton.text = RandomWordGenerator().setRootWord()

        return view
    }


//    var n = 0 //Helper function used to increment indices at the same rate
//    fun increment(): Int{
//        if (n == 9){
//            n = 0
//        }
//        n++
//        return n
//    }

    fun updateRootButtonText(rootWordButton: Button){
        rootWordButton.text = RandomWordGenerator().setRootWord()//DatamuseRepository().root
        //rootWordButton.text = DatamuseRepository().

    }

    //a synonym of a word from the api call should be put into the top left button in the UI

    fun updateButtonText(topLeftButton: Button, topRightButton: Button,
                         topLeftMiddleButton: Button, topRightMiddleButton: Button,
                         bottomLeftMiddleButton: Button, bottomRightMiddleButton: Button,
                         bottomLeftButton: Button, bottomRightButton: Button) {
        val resp = DatamuseRepository().fetchWord()
        resp.observe(this, Observer { word ->
            //topLeftButton.text = word.synonymDatamuseWords
            topRightButton.text = word.synonymDatamuseWords
            topLeftMiddleButton.text = word.synonymDatamuseWords
            topRightMiddleButton.text = word.synonymDatamuseWords
            bottomLeftMiddleButton.text = word.synonymDatamuseWords
            bottomRightMiddleButton.text = word.synonymDatamuseWords
            bottomLeftButton.text = word.synonymDatamuseWords
            bottomRightButton.text = word.synonymDatamuseWords
            //DatamuseRepository().fetchRootWord() // this does not get the correct root word, check the refresh function
        })

        val resp2 = DatamuseRepository().fetchWord2()
        resp2.observe(this, Observer { word2 ->
            topLeftButton.text = word2.synonymDatamuseWords

        })
    }



    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()

    }

        /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            GameFragment().apply {
                arguments = Bundle().apply{

                }
            }
    }
}