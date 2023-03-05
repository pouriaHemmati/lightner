package com.poudean.lightner.db.models

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
data class VocabularyModel(
    @Id var id : Long = 0,
    var lessonId : Long = 0,
    var germanVocabulary : String = "",
    var persianVocabulary : String = "",
    var englishVocabulary : String? = null
)
{
    lateinit var vocabulary: ToOne<LessonModel>
}

