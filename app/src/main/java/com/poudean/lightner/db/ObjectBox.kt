package com.poudean.lightner.db

import android.content.Context
import android.util.Log
import com.poudean.lightner.db.boxes.DBDetailsBox
import com.poudean.lightner.db.boxes.LessonBox
import com.poudean.lightner.db.boxes.VocabularyBox
import com.poudean.lightner.db.models.MyObjectBox
import io.objectbox.BoxStore
import io.objectbox.android.Admin
import io.objectbox.android.BuildConfig

class ObjectBox(
    context: Context
) {
    var boxStore: BoxStore
        private set

    var lessonBox : LessonBox
    private set

    var vocabularyBox : VocabularyBox
    private set

    var dbDetails : DBDetailsBox
    private set

    init {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()

        lessonBox = LessonBox(boxStore)
        vocabularyBox = VocabularyBox(boxStore)
        dbDetails = DBDetailsBox(boxStore)

    }
}