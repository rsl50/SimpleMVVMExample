package com.robsonlima.simplemvvmexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.robsonlima.simplemvvmexample.databinding.FragmentMainBinding
import com.robsonlima.simplemvvmexample.viewmodel.MainViewModel

class MainFragment: Fragment() {
    // View Binding with 'fragment_main.xml' so we get reference to xml layout objects easier.
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTextUpdateObserver()
    }

    private fun fragmentTextUpdateObserver() {
        // Adds a Observer waiting for viewModel to update our UI
        // updatedText is an alias to help the code be more clear
        // If data of 'uiTextLiveData' changes, then it is set to 'fragmentTextView' on
        // fragment_main.xml
        viewModel.uiTextLiveData.observe(viewLifecycleOwner, Observer { updatedText ->
            binding.fragmentTextView.text = updatedText
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Invalidate the binding
        _binding = null
    }
}
