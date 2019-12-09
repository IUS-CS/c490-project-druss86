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
import android.widget.Toast
import androidx.lifecycle.Observer
import edu.iu.c490.synonymist.api.PlayFragment

private const val TAG = "GameFragment"

/**
 * The game's Fragment calls.  All Dynamic UI updates happen here and
 * the game's activity cycle is handled here.
 **/
class GameFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
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
        val submitButton = view.findViewById<Button>(R.id.submitBtn)
        val homeButton = view.findViewById<Button>(R.id.homeBtn)
        /* Can remove to have no text on view create*/
//        updateButtonText2(
//            topLeftButton, topRightButton,
//            topLeftMiddleButton, topRightMiddleButton,
//            bottomLeftMiddleButton, bottomRightMiddleButton,
//            bottomLeftButton, bottomRightButton)


        var correctAnswers = 0
        var btnLayout = 0

        fun incrementBtnLayout(): Int{
            if (btnLayout == 3){
                btnLayout = 0
            }
            btnLayout++
            return btnLayout
        }


        rootWordButton.setOnClickListener {
            correctAnswers = 4
            populateSynonyms()
            incrementBtnLayout()

            topLeftButton.setBackgroundResource(R.drawable.button_press_color_blue)
            topRightButton.setBackgroundResource(R.drawable.button_press_color_blue)
            topLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_blue)
            topRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_blue)
            bottomLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_blue)
            bottomRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_blue)
            bottomLeftButton.setBackgroundResource(R.drawable.button_press_color_blue)
            bottomRightButton.setBackgroundResource(R.drawable.button_press_color_blue)
            submitButton.setBackgroundResource(R.drawable.button_press_color_blue)

            if (btnLayout == 1){
                updateButtonText(
                    topLeftButton, topRightButton,
                    topLeftMiddleButton, topRightMiddleButton,
                    bottomLeftMiddleButton, bottomRightMiddleButton,
                    bottomLeftButton, bottomRightButton)
            } else if (btnLayout == 2){
                updateButtonText2(
                    topLeftButton, topRightButton,
                    topLeftMiddleButton, topRightMiddleButton,
                    bottomLeftMiddleButton, bottomRightMiddleButton,
                    bottomLeftButton, bottomRightButton)
            } else {
                updateButtonText3(
                    topLeftButton, topRightButton,
                    topLeftMiddleButton, topRightMiddleButton,
                    bottomLeftMiddleButton, bottomRightMiddleButton,
                    bottomLeftButton, bottomRightButton)
            }
            updateRootButtonText(rootWordButton)
        }

        topLeftButton.setOnClickListener {

            topLeftButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1){
                correctAnswers++
            }
            if (btnLayout == 2){
                correctAnswers--
            }
            if (btnLayout == 3){
                correctAnswers--
            }
        }

        topRightButton.setOnClickListener {

            topRightButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1){
                correctAnswers--
            }
            if (btnLayout == 2){
                correctAnswers++
            }
            if (btnLayout == 3){
                correctAnswers++
            }
        }

        topLeftMiddleButton.setOnClickListener {

            topLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1) {
                correctAnswers--
            }
            if (btnLayout == 2) {
                correctAnswers++
            }
            if (btnLayout == 3) {
                correctAnswers--
            }
        }

        topRightMiddleButton.setOnClickListener {

            topRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1) {
                correctAnswers++
            }
            if (btnLayout == 2) {
                correctAnswers++
            }
            if (btnLayout == 3) {
                correctAnswers--
            }
        }

        bottomLeftMiddleButton.setOnClickListener {

            bottomLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1) {
                correctAnswers++
            }
            if (btnLayout == 2) {
                correctAnswers++
            }
            if (btnLayout == 3) {
                correctAnswers++
            }
        }

        bottomRightMiddleButton.setOnClickListener {
            bottomRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1) {
                correctAnswers--
            }
            if (btnLayout == 2) {
                correctAnswers--
            }
            if (btnLayout == 3) {
                correctAnswers--
            }
        }

        bottomLeftButton.setOnClickListener {

            bottomLeftButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1) {
                correctAnswers--
            }
            if (btnLayout == 2) {
                correctAnswers--
            }
            if (btnLayout == 3) {
                correctAnswers++
            }
        }

        bottomRightButton.setOnClickListener {

            bottomRightButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1) {
                correctAnswers++
            }
            if (btnLayout == 2) {
                correctAnswers--
            }
            if (btnLayout == 3) {
                correctAnswers++
            }
        }

        submitButton.setOnClickListener {

            submitButton.setBackgroundResource(R.drawable.button_press_color_green)

            if (btnLayout == 1){
                topLeftButton.setBackgroundResource(R.drawable.button_press_color_green)
                topRightButton.setBackgroundResource(R.drawable.button_press_color_red)
                topLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_red)
                topRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)
                bottomLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)
                bottomRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_red)
                bottomLeftButton.setBackgroundResource(R.drawable.button_press_color_red)
                bottomRightButton.setBackgroundResource(R.drawable.button_press_color_green)
            } else if (btnLayout == 2){
                topLeftButton.setBackgroundResource(R.drawable.button_press_color_red)
                topRightButton.setBackgroundResource(R.drawable.button_press_color_green)
                topLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)
                topRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)
                bottomLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)
                bottomRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_red)
                bottomLeftButton.setBackgroundResource(R.drawable.button_press_color_red)
                bottomRightButton.setBackgroundResource(R.drawable.button_press_color_red)
            } else {
                topLeftButton.setBackgroundResource(R.drawable.button_press_color_red)
                topRightButton.setBackgroundResource(R.drawable.button_press_color_green)
                topLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_red)
                topRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_red)
                bottomLeftMiddleButton.setBackgroundResource(R.drawable.button_press_color_green)
                bottomRightMiddleButton.setBackgroundResource(R.drawable.button_press_color_red)
                bottomLeftButton.setBackgroundResource(R.drawable.button_press_color_green)
                bottomRightButton.setBackgroundResource(R.drawable.button_press_color_green)
            }
            Toast.makeText(context, "Score: "+ correctAnswers +"/8 correct", Toast.LENGTH_LONG).show()
        }

        rootWordButton.text = "Start"
        Log.d(TAG, "Root Word: ${rootWordButton.text}")

        return view
    }

    val rndIndex = (3..4).random()
    var n = 0
    fun incRootWordList(): Int{
        if (n == 20){
            n = 0
        }
        n++
        return n
    }

    var rootWordList = listOf(
        "", "Bad", "Lonely", "Friend", "Clean", "Rough", "Poor", "Good", "Dirty", "Soft", "Change",
        "Animal", "Character", "Family", "Important", "Learn", "True", "Mind", "Cold", "Realize", "Fine"
    )

    var synonymWordList = mutableListOf<String>()

    fun updateRootButtonText(rootWordButton: Button){
        rootWordButton.text = rootWordList[incRootWordList()]
        Log.d(TAG, "Root Word: ${rootWordButton.text}")
    }

    /*Four Synonyms and four random words*/
    fun updateButtonText(topLeftButton: Button, topRightButton: Button,
                         topLeftMiddleButton: Button, topRightMiddleButton: Button,
                         bottomLeftMiddleButton: Button, bottomRightMiddleButton: Button,
                         bottomLeftButton: Button, bottomRightButton: Button) {
        val resp = DatamuseRepository().fetchWord()
        resp.observe(this, Observer { word ->
            topLeftButton.text = synonymWordList[0]
            topRightMiddleButton.text = synonymWordList[1]
            bottomLeftMiddleButton.text = synonymWordList[2]
            bottomRightButton.text = synonymWordList[rndIndex]
        })

        val resp2 = DatamuseRepository().fetchWord2()
        resp2.observe(this, Observer { word2 ->
            topRightButton.text = word2.randomDatamuseWord
        })

        val resp3 = DatamuseRepository().fetchWord3()
        resp3.observe(this, Observer { word3 ->
            topLeftMiddleButton.text = word3.randomDatamuseWord
        })

        val resp4 = DatamuseRepository().fetchWord4()
        resp4.observe(this, Observer { word4 ->
            bottomRightMiddleButton.text = word4.randomDatamuseWord
        })

        val resp5 = DatamuseRepository().fetchWord5()
        resp5.observe(this, Observer { word5 ->
            bottomLeftButton.text = word5.randomDatamuseWord
        })
    }

    /*Four Synonyms and four random words*/
    fun updateButtonText2(topLeftButton: Button, topRightButton: Button,
    topLeftMiddleButton: Button, topRightMiddleButton: Button,
    bottomLeftMiddleButton: Button, bottomRightMiddleButton: Button,
    bottomLeftButton: Button, bottomRightButton: Button) {
        val resp = DatamuseRepository().fetchWord()
        resp.observe(this, Observer { word ->
            topRightButton.text = synonymWordList[0]
            topLeftMiddleButton.text = synonymWordList[1]
            topRightMiddleButton.text = synonymWordList[2]
            bottomLeftMiddleButton.text = synonymWordList[rndIndex]
        })

        val resp2 = DatamuseRepository().fetchWord2()
        resp2.observe(this, Observer { word2 ->
            topLeftButton.text = word2.randomDatamuseWord
        })

        val resp3 = DatamuseRepository().fetchWord3()
        resp3.observe(this, Observer { word3 ->
            bottomRightMiddleButton.text = word3.randomDatamuseWord
        })

        val resp4 = DatamuseRepository().fetchWord4()
        resp4.observe(this, Observer { word4 ->
            bottomLeftButton.text = word4.randomDatamuseWord
        })

        val resp5 = DatamuseRepository().fetchWord5()
        resp5.observe(this, Observer { word5 ->
            bottomRightButton.text = word5.randomDatamuseWord
        })
    }

    fun updateButtonText3(topLeftButton: Button, topRightButton: Button,
    topLeftMiddleButton: Button, topRightMiddleButton: Button,
    bottomLeftMiddleButton: Button, bottomRightMiddleButton: Button,
    bottomLeftButton: Button, bottomRightButton: Button) {
        val resp = DatamuseRepository().fetchWord()
        resp.observe(this, Observer { word ->
            topRightButton.text = synonymWordList[0]
            bottomLeftMiddleButton.text = synonymWordList[1]
            bottomLeftButton.text = synonymWordList[2]
            bottomRightButton.text = synonymWordList[rndIndex]
        })

        val resp2 = DatamuseRepository().fetchWord2()
        resp2.observe(this, Observer { word2 ->
            topLeftButton.text = word2.randomDatamuseWord
        })

        val resp3 = DatamuseRepository().fetchWord3()
        resp3.observe(this, Observer { word3 ->
            topLeftMiddleButton.text = word3.randomDatamuseWord
        })

        val resp4 = DatamuseRepository().fetchWord4()
        resp4.observe(this, Observer { word4 ->
            topRightMiddleButton.text = word4.randomDatamuseWord
        })

        val resp5 = DatamuseRepository().fetchWord5()
        resp5.observe(this, Observer { word5 ->
            bottomRightMiddleButton.text = word5.randomDatamuseWord
        })
    }

    fun populateSynonyms(){
        if (n == 0){
            synonymWordList = mutableListOf("wicked", "evil", "mischievous", "abominable", "terrible")
        }
        if (n == 1){
            synonymWordList = mutableListOf("only", "sole", "exclusive", "solitary", "unaccompanied")
        }
        if (n == 2){
            synonymWordList = mutableListOf("ally", "supporter", "confederate", "acquaintance", "admirer")
        }
        if (n == 3){
            synonymWordList = mutableListOf("pure", "neat", "spotless", "unsullied", "unclouded")
        }
        if (n == 4){
            synonymWordList = mutableListOf("jagged", "rugged", "pugnacious", "mountainous", "cragged")
        }
        if (n == 5){
            synonymWordList = mutableListOf("bust", "broke", "beggarly", "slummy", "needy")
        }
        if (n == 6){
            synonymWordList = mutableListOf("great", "kind", "honorable", "virtuous", "genuine")
        }
        if (n == 7){
            synonymWordList = mutableListOf("soil", "lewd", "perverted", "dusty", "scummy")
        }
        if (n == 8){
            synonymWordList = mutableListOf("fluffy", "velvety", "gentle", "flaccid", "weak")
        }
        if (n == 9){
            synonymWordList = mutableListOf("switch", "shift", "transfer", "modification", "alter")
        }
        if (n == 10){
            synonymWordList = mutableListOf("creature", "beast", "brute", "carnal", "fauna")
        }
        if (n == 11){
            synonymWordList = mutableListOf("role", "persona", "eccentric", "theatrical", "part")
        }
        if (n == 12){
            synonymWordList = mutableListOf("home", "kinfolk", "fellowship", "house", "category")
        }
        if (n == 13){
            synonymWordList = mutableListOf("noteworthy", "significant", "earthshaking", "grievous", "crucial")
        }
        if (n == 14){
            synonymWordList = mutableListOf("read", "study", "ascertain", "absorb", "discover")
        }
        if (n == 15){
            synonymWordList = mutableListOf("real", "accurate", "loyal", "dependable", "lawful")
        }
        if (n == 16){
            synonymWordList = mutableListOf("psyche", "brain", "intellect", "idea", "head")
        }
        if (n == 17){
            synonymWordList = mutableListOf("cool", "polar", "frosty", "glacial", "frigid")
        }
        if (n == 18){
            synonymWordList = mutableListOf("understand", "recognize", "actualize", "agnise", "see")
        }
        if (n == 19){
            synonymWordList = mutableListOf("well", "dainty", "good", "delicate", "pulverized")
        }
        if (n == 20){
            synonymWordList = mutableListOf("wicked", "evil", "mischievous", "abominable", "terrible")
        }
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }

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