package com.example.android_exercise_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_exercise_navigation.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {
    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //menangkap data  menggunakan safeargs
        val name = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val stock = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock

        //memasukan data ke dalam textView
        binding.tvCategoryName.text = name
        binding.tvCategoryDescription.text = "$stock"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}