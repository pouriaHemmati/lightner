package com.poudean.lightner.ui.lesson

import androidx.lifecycle.ViewModel
import com.poudean.lightner.db.ObjectBox
import com.poudean.lightner.db.models.LessonModel
import com.poudean.lightner.utils.getProp
import com.poudean.lightner.utils.setProp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LessonViewModel @Inject constructor(private val objectBox: ObjectBox): ViewModel() {
    private val _lessons = setProp<List<LessonModel>>()
    val lessons = getProp(_lessons)

    fun getAllLessons(){
        objectBox.lessonBox.getAllLessons()?.let {
            _lessons.postValue(it)
        }
    }


}