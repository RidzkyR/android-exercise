package com.example.android_exercise_fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.android_exercise_fragment.databinding.FragmentOptionDialogBinding

class OptionDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentOptionDialogBinding
    private var optionDialogListener: OnOptionDialogListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentOptionDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // fungsi ketika button ditekan
        binding.btnChoose.setOnClickListener {
            val checkedRadioButtonId = binding.rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var coach: String? = when (checkedRadioButtonId) {
                    R.id.rb_saf -> binding.rbSaf.text.toString().trim()
                    R.id.rb_mou -> binding.rbMou.text.toString().trim()
                    R.id.rb_lvg -> binding.rbLvg.text.toString().trim()
                    R.id.rb_moyes -> binding.rbMoyes.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.OnOptionChosen(coach) // memasukan data ke interface OnOptionDialogListener
                dialog?.dismiss() // menutup dialog
            }
        }

        binding.btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }
    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }
    interface OnOptionDialogListener {
        fun OnOptionChosen(text: String?)
    }
}

