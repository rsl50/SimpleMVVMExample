package com.robsonlima.simplemvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.robsonlima.simplemvvmexample.R

/**
 * Opens the fragment with the UI
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            // Adds our fragment
            supportFragmentManager.commit {
                // Sets whether or not to allow optimizing operations within and across
                // transactions. This will remove redundant operations, eliminating operations that
                // cancel.
                setReorderingAllowed(true)

                // Add a fragment to the associated FragmentManager, inflating the Fragment's view
                // into the container view specified by containerViewId, to later retrieve via
                // FragmentManager.findFragmentById.
                add<MainFragment>(R.id.fragment_container_view)
            }
        }
    }
}