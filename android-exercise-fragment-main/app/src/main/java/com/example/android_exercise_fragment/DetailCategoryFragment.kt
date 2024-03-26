package com.example.android_exercise_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android_exercise_fragment.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {
    private lateinit var binding: FragmentDetailCategoryBinding

    //menyimpan data dengan metode setter
    var description: String? = null

    //objek penerima data
    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // return inflater.inflate(R.layout.fragment_detail_category, container, false)
        // di bawah ini jika menggunaka binding --- yang di atas adalah cara lama
        binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //cek data di saveInstaceState
        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        // menangkap dan memeriksa data kiriman
        if (arguments != null) {
            val dataKiriman = arguments?.getString(EXTRA_NAME)
            binding.tvCategoryName.text = dataKiriman
            // menangkap data dengan metode getter
            binding.tvCategoryDescription.text = description
        }

        //memunculkan dialog
        binding.btnShowDialog.setOnClickListener {
            val fragmentManager = childFragmentManager // memberi akses untuk memunculkan fragment baru lagi
            val optionDialogBinding = OptionDialogFragment()
            optionDialogBinding.show(fragmentManager, OptionDialogFragment::class.java.simpleName) // memunculkan dialog
        }

        //memanggil / pindah ke activity menggunakan fragment
        binding.btnProfile.setOnClickListener {
            val Intent = Intent(requireActivity(),ProfileActivity::class.java)
            startActivity(Intent)
        }
    }

    // untukk menyambungkan data yang dikirim dari dialog .
    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener {
        override fun OnOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
    }

}