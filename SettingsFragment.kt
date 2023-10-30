package com.example.ashoppingcartapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_settings, container, false)
        val spinner: Spinner = rootView.findViewById(R.id.spinner)
        val saveButton: Button = rootView.findViewById(R.id.button3)

        val viewModel = ViewModelProvider(this)[FragmentViewModel::class.java]

        saveButton.setOnClickListener {
            when (spinner.selectedItem as String) {
                "blank" -> { /* Do something for "blank" selection */ }
                "Canvas painting" -> { viewModel.setBackgroundColor(R.color.background1) }
                "Jewelry" -> { viewModel.setBackgroundColor(R.color.background2) }
                "Fashion" -> { viewModel.setBackgroundColor(R.color.background3) }
                "Beauty" -> { viewModel.setBackgroundColor(R.color.background4) }
                "Mart" -> { viewModel.setBackgroundColor(R.color.background5) }
            }
        }

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
