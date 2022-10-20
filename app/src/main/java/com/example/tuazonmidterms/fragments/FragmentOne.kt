package com.example.tuazonmidterms.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tuazonmidterms.MY_PREFERENCE
import com.example.tuazonmidterms.R
import com.example.tuazonmidterms.USERNAME
import com.example.tuazonmidterms.databinding.FragmentOneBinding


class FragmentOne : Fragment(),View.OnClickListener {
    private lateinit var binding : FragmentOneBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var oneFragmentInterface : OneFragmentInterface

    interface OneFragmentInterface{
        fun modifyUserName()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        oneFragmentInterface = context as OneFragmentInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentOneBinding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveUser.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val userlength = binding.edtUserName.text.length
        binding.edtUserName.hint = "USERNAME"

        if(binding.edtUserName.text.isEmpty()){
            binding.edtUserName.error = "Required"
            return
        }
        else if(userlength<6){
            binding.edtUserName.error = "Please enter at least 6 characters"
            return
        } else {
            val editor = sharedPreferences.edit()
            editor.putString(USERNAME, binding.edtUserName.text.toString())
            editor.apply()
            oneFragmentInterface.modifyUserName()
        }
    }
}