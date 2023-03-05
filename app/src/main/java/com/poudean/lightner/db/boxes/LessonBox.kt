package com.poudean.lightner.db.boxes


import com.poudean.lightner.db.models.LessonModel
import com.poudean.lightner.db.models.LessonModel_
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

class LessonBox constructor(
    boxStore: BoxStore
) {
    private val box: Box<LessonModel> = boxStore.boxFor(LessonModel::class.java)

    fun addLesson(lesson: LessonModel) {
        box.put(lesson)
    }

    fun addLessons(lessons: List<LessonModel>) {
        box.put(lessons)
    }

     fun getAllLessons(): List<LessonModel> {
         return box.query {
             this.order(LessonModel_.id,QueryBuilder.DESCENDING)
         }.find()
     }
    fun removeAll() {
        box.removeAll()
    }


//    fun getPersonDataByCaseNumber(caseNumber: Long) =
//        box.query().equal(Person_.caseNumber, caseNumber).build().findFirst()
//
//
//    fun searchSamplingNumberByCaseNumber(caseNumber: Long, samplingNumber: Long): Person? {
//        return box.query {
//            this.equal(Person_.caseNumber, caseNumber)
//                .equal(Person_.samplingNumber,samplingNumber)
//        }.findFirst()
//    }

}


