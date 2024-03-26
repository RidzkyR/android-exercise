package com.example.android_exercise_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.android_exercise_navigation.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_category, container, false)
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // mengirim data
        binding.btnCategoryLifestyle.setOnClickListener{
        // menggunakan safeargs biar clean
            val kirimData = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            kirimData.name = "DATA NAMA"
            kirimData.stock = 20
            view.findNavController().navigate(kirimData)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}