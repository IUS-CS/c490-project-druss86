package edu.iu.c490.synonymist

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import edu.iu.c490.synonymist.api.PlayFragment

/**
 * Start of the application.  Designates the fragment instance GameFragment (or others).
 **/

class MainActivity : AppCompatActivity(), GameFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val isFragmentContainerEmpty  = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, GameFragment.newInstance())
                .commit()
        }

    }

}
