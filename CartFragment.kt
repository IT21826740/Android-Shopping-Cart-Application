package com.example.cartapplication

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartapplication.CartAdapter
import com.example.cartapplication.MainActivityData
import com.example.cartapplication.R
import com.example.cartapplication.database.Cart
import com.example.cartapplication.database.CartDatabase
import com.example.cartapplication.database.CartRepository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: CartAdapter
    private lateinit var viewModel: MainActivityData

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
        val rootView= inflater.inflate(R.layout.fragment_cart, container, false)

        val recycleView: RecyclerView = rootView.findViewById(R.id.rvcart)
        val repository = CartRepository(CartDatabase.getInstance(requireActivity()))

        val add: Button = rootView.findViewById(R.id.add)

        add.setOnClickListener{
            displayAlert(repository)
        }
        viewModel = ViewModelProvider(requireActivity())[MainActivityData::class.java]


        viewModel.data.observe(requireActivity()) {
            adapter =CartAdapter(it,repository,viewModel)
            recycleView.adapter = adapter
            recycleView.layoutManager = LinearLayoutManager(requireActivity())
        }
        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllCart()

            withContext(Dispatchers.Main){
                viewModel.setData(data)
            }
        }
        return  rootView;
    }
    private fun displayAlert(repository:CartRepository){
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Enter Cart Details")

        val layout = LinearLayout(requireActivity())
        layout.orientation = LinearLayout.VERTICAL

        val editTextId = EditText(requireActivity())
        editTextId.hint = "Item name"
        layout.addView(editTextId)

        val editTextName = EditText(requireActivity())
        editTextName.hint = "Price"
        layout.addView(editTextName)

        builder.setView(layout)

        builder.setPositiveButton("ok") {dialog , which ->
            val cartName = editTextId.text.toString()
            val description = editTextName.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                repository.insert(Cart(cartName,description))
                val data = repository.getAllCart()
                withContext(Dispatchers.Main){
                    viewModel.setData(data)
                }
            }
        }
        builder.setNegativeButton("cancel"){ dialog , which -> dialog.cancel()}

        val alertDialog = builder.create()
        alertDialog.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}