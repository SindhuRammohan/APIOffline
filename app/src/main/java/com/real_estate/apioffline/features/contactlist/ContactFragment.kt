package com.real_estate.apioffline.features.contactlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.real_estate.apioffline.data.ContactList
import com.real_estate.apioffline.databinding.ActivityContactBinding
import com.real_estate.apioffline.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : Fragment() {
    // Helps to preserve the view
    // If the app is closed, then after reopening it the app will open
    // in a state in which it was closed
    // DaggerHilt will inject the view-model for us
    private val viewModel: ContactListViewModel by viewModels()
    private var _binding: ActivityContactBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityContactBinding.inflate(inflater, container, false)
        val view = binding.root
        val contactAdapter = ContactAdapter()
        setHasOptionsMenu(true);
        binding.apply {
            recyclerViewer.apply {
                adapter = contactAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.contacts.observe(this@ContactFragment) { result ->
                contactAdapter.submitList(result.data)
                progressBar.isVisible = result is Resource.Loading<*> && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error<*> && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage

            }
        }


        binding.editTextSample.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Log.d("onQueryTextChange", "query: " + s)
            }
        })

        return view
    }

}