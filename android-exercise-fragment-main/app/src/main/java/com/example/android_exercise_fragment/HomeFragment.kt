package com.example.android_exercise_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_exercise_fragment.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // return inflater.inflate(R.layout.fragment_home, container, false)
        // di bawah ini jika menggunaka binding --- yang di atas adalah cara lama
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCategory.setOnClickListener{
            val fragmentManager = parentFragmentManager // memberi akses fragment untuk muncul pada activity
            val categoryFragment = CategoryFragment() // fragment yang mana?

            // menimpa fragment
            fragmentManager.beginTransaction().apply {
                    replace(R.id.frame_container, categoryFragment,CategoryFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
        }
    }

}