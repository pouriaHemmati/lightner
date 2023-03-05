package com.poudean.lightner.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.poudean.lightner.databinding.ActivitySplashBinding
import com.poudean.lightner.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@AndroidEntryPoint
class Splash : AppCompatActivity() {
    lateinit var binding : ActivitySplashBinding
    private val viewModel : SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel.haveLesson.observe(this){
            if (it){
                lifecycleScope.launch {
                    delay(2000)
                    startActivity(Intent(this@Splash,MainActivity::class.java))
                    finish()
                }
            } else {
                Toast.makeText(this,"have not lesson" , Toast.LENGTH_LONG).show()
            }
        }


    }
}
