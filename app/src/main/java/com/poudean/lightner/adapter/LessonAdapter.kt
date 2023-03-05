package com.poudean.lightner.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poudean.lightner.databinding.ItemLessonBinding
import com.poudean.lightner.db.models.LessonModel
import com.poudean.lightner.adapter.LessonAdapter.ViewHolder
import com.poudean.lightner.ui.lesson.ItemLessonClickListener


class LessonAdapter(
    private val lessons: List<LessonModel>,
    private val listenToClick: ItemLessonClickListener
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLessonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding.root)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lesson = lessons[position]
        with(holder.binding){
            parentLesson.setOnClickListener {
                listenToClick.clickLesson(lesson.id)
            }
            tvLesson.text = lesson.lessonName
        }



    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLessonBinding.bind(view)
    }
}