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

class MainActivity : AppCompatActivity(), PlayFragment.Callbacks, GameFragment.Callbacks {

//    override fun onFragmentInteraction(uri: Uri) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragment = PlayFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
//        val isFragmentContainerEmpty  = savedInstanceState == null
//        if (isFragmentContainerEmpty) {
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.fragment_container, GameFragment.newInstance())
//                .commit()
//        }

    }

    override fun onPlay() {
        val fragment = GameFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onHome() {
        val fragment = PlayFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onStats() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
