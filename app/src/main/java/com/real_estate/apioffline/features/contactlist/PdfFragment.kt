package com.real_estate.apioffline.features.contactlist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.real_estate.apioffline.databinding.PdffragmentMainBinding
import com.real_estate.pdfkotlin.PdfViewActivity

class PdfFragment : Fragment() {
    private var _binding: PdffragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PdffragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpOnClickListener()
        return view
    }

    private fun setUpOnClickListener() {
        binding.buttonWebView.setOnClickListener {
            val intent = Intent(activity, WebViewActivity::class.java)
            startActivity(intent)
        }
        binding.buttonAssets.setOnClickListener {
            val intent = Intent(activity, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "assets")
            startActivity(intent)
        }
        binding.buttonStorage.setOnClickListener {
            val intent = Intent(activity, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "storage")
            startActivity(intent)
        }
        binding.buttonInternet.setOnClickListener {
            val intent = Intent(activity, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "internet")
            startActivity(intent)
        }
    }

}