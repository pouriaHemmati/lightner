package com.poudean.lightner.ui.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.poudean.lightner.adapter.LessonAdapter
import com.poudean.lightner.databinding.FragmentHomeBinding
import com.poudean.lightner.db.models.LessonModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LessonFragment : Fragment() , ItemLessonClickListener {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: LessonViewModel by viewModels()
    private var lessonAdapter: LessonAdapter? = null
    private var listLesson : List<LessonModel> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)


        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lessonAdapter = LessonAdapter(listLesson,this)
        viewModel.lessons.observe(requireActivity()) {
            listLesson = it
            lessonAdapter?.notifyDataSetChanged()
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllLessons()
    }

    override fun clickLesson(id: Long) {

    }

}