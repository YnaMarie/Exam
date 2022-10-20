package com.example.tuazonmidterms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tuazonmidterms.databinding.ActivityMainBinding
import com.example.tuazonmidterms.fragments.FragmentOne
import com.example.tuazonmidterms.fragments.FragmentTwo

class MainActivity : AppCompatActivity() , FragmentOne.OneFragmentInterface {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragContA.id, FragmentOne()) // top fragment
        fragmentManager.commit()

}
    override fun modifyUserName() {
    val fragmentManager = supportFragmentManager.beginTransaction()
    fragmentManager.replace(binding.fragContB.id, FragmentTwo()) // top fragment
    fragmentManager.commit()
}
}