package com.poudean.lightner.db

import android.content.Context
import com.poudean.lightner.db.boxes.LessonBox
import com.poudean.lightner.db.models.MyObjectBox
import io.objectbox.BoxStore

class ObjectBox(
    context: Context
) {
    var boxStore: BoxStore
        private set

    var lessonBox : LessonBox
    private set



    init {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()

        lessonBox = LessonBox(boxStore)

    }
}