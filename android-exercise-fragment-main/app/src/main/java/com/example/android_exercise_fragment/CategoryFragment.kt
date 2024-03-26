package com.example.android_exercise_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_exercise_fragment.databinding.FragmentCategoryBinding
import com.example.android_exercise_fragment.databinding.FragmentHomeBinding

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return inflater.inflate(R.layout.fragment_category, container, false)
        // di bawah ini jika menggunaka binding --- yang di atas adalah cara lama
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategory.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val detailCategoryFragment = DetailCategoryFragment()

            // kirimkan data ke fragment ini
            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "data nama kiriman fragment category")
            val description = "data deskripsi kiriman fragment category"

            detailCategoryFragment.arguments = bundle
            detailCategoryFragment.description = description

            // pindah fragment dengan operator elvis
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}