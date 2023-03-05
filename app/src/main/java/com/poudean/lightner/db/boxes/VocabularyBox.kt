package com.poudean.lightner.db.boxes

import com.poudean.lightner.db.models.VocabularyModel
import com.poudean.lightner.db.models.VocabularyModel_
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.query


class VocabularyBox constructor(boxStore : BoxStore) {
    private val box : Box<VocabularyModel> = boxStore.boxFor(VocabularyModel::class.java)

    fun addVocabulary(vocabularyModel: VocabularyModel){
        box.put(vocabularyModel)
    }

    fun addVocabularys(vocabularyModels: List<VocabularyModel>){
        box.put(vocabularyModels)
    }

    fun getAllVocabularysLesson(idLesson : Long) : List<VocabularyModel>{
       return box.query {
           this.equal(VocabularyModel_.vocabularyId, idLesson)
       }.find()
    }
}