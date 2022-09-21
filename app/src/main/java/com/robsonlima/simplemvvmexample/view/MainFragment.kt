package com.robsonlima.simplemvvmexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.robsonlima.simplemvvmexample.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    // View Binding with 'fragment_main.xml' so we get reference to xml layout objects easier.
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflating the layout/view
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Invalidate the binding
        _binding = null
    }
}
