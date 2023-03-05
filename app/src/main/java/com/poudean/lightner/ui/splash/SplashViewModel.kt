package com.poudean.lightner.ui.splash

import androidx.lifecycle.ViewModel
import com.poudean.lightner.db.ObjectBox
import com.poudean.lightner.db.models.MyObjectBox
import com.poudean.lightner.utils.getProp
import com.poudean.lightner.utils.setProp
import dagger.hilt.android.lifecycle.HiltViewModel
import io.objectbox.android.Admin
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(private val objectBox: ObjectBox) : ViewModel() {
    private val _haveLesson = setProp<Boolean>()
    val haveLesson = getProp(_haveLesson)
    init {
        _haveLesson.postValue(objectBox.lessonBox.getAllLessons()?.size!! > 0 )
    }

    fun insertData(){

    }

}