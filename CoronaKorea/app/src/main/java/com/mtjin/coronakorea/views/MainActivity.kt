package com.mtjin.coronakorea.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mtjin.coronakorea.R
import com.mtjin.coronakorea.databinding.ActivityMainBinding
import me.ibrahimsn.lib.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBinding()
        initListener()
    }

    private fun initListener() {
        binding.mainSbBottombar.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int): Boolean {
                Log.d(TAG, "" + pos)
                when (pos) {

                }
                return true
            }
        })
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    companion object {
        const val TAG = "MainActivityTag"
    }
}
