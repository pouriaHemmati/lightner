package com.poudean.lightner.ui.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.poudean.lightner.R
import com.poudean.lightner.databinding.ActivityMainBinding
import com.poudean.lightner.databinding.FragmentHomeBinding
import com.poudean.lightner.databinding.FragmentVocabularyBinding

class VocabularyFragment : Fragment()  , Animation.AnimationListener{
   private lateinit var binding : FragmentVocabularyBinding

    private lateinit var animation1: Animation
    private lateinit var animation2: Animation
    private var isFrontOfCardShowing = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVocabularyBinding.inflate(inflater)


        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animation1 = AnimationUtils.loadAnimation(requireContext(), R.anim.to_middle)
        animation1.setAnimationListener(this)

        animation2 = AnimationUtils.loadAnimation(requireContext(), R.anim.from_middle)
        animation2.setAnimationListener(this)



        binding.imageView1.setOnClickListener {
            it.isEnabled = false

            // stop animation
            binding.imageView1.clearAnimation()
            binding.imageView1.animation = animation1

            // start the animation
            binding.imageView1.startAnimation(animation1)
        }
    }

    override fun onAnimationEnd(animation: Animation) {
        if (animation === animation1) {
            // check whether the front of the card is showing
            if (isFrontOfCardShowing) {
                // set image from card_front to card_back
                binding.txt.text = "page 2"
            } else {
                // set image from card_back to card_front
                binding.txt.text = "page 1"
            }
            // stop the animation of the ImageView
            binding.imageView1.clearAnimation()
            binding.imageView1.animation = animation2
            // allow fine-grained control
            // over the start time and invalidation
            binding.imageView1.startAnimation(animation2)
        } else {
            isFrontOfCardShowing = !isFrontOfCardShowing
            binding.imageView1.isEnabled = true
        }
    }

    override fun onAnimationRepeat(animation: Animation?) {
        // TODO Auto-generated method stub
    }

    override fun onAnimationStart(animation: Animation?) {
        // TODO Auto-generated method stub
    }

}