package edu.iu.c490.synonymist

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import edu.iu.c490.synonymist.GameFragment
import edu.iu.c490.synonymist.R

class StatsFragment: Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        val playButton = view.findViewById<Button>(R.id.statsPlayBtn)
        val homeButton = view.findViewById<Button>(R.id.statsHomeBtn)

        playButton.setOnClickListener{
            callbacks?.onPlay()
        }

        homeButton.setOnClickListener{
            callbacks?.onHome()
        }
//        playButton.setOnClickListener( object:View.OnClickListener(){
//            override fun onClick(view:View) {
//                FragmentActivity().supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.fragment_container, GameFragment.newInstance())
//                val newGamefragment = GameFragment()
//                val fragmentTransaction = FragmentActivity().supportFragmentManager.beginTransaction()
//                fragmentTransaction.replace(R.id.fragment_container, newGamefragment)
//                fragmentTransaction.addToBackStack(null)
//                fragmentTransaction.commit()
//                }
//            })
        return view
    }

    interface Callbacks {
        fun onPlay()
        fun onHome()
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null

    }
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            StatsFragment().apply {
                arguments = Bundle().apply{

                }
            }
    }
}