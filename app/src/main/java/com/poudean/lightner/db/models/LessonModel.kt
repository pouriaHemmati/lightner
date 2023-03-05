package com.poudean.lightner.db.models

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class LessonModel(
    @Id
    var id : Long = 0,
    var lessonName : String = "",
)
{
    @Backlink(to = "vocabulary")
    lateinit var vocabularyModel : ToMany<VocabularyModel>
}
