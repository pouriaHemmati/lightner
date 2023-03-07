package com.poudean.lightner.db.boxes

import com.poudean.lightner.db.ObjectBox
import com.poudean.lightner.db.models.DBDetailsModel
import com.poudean.lightner.db.models.DBDetailsModel_
import com.poudean.lightner.db.models.LessonModel
import com.poudean.lightner.db.models.LessonModel_
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

class DBDetailsBox constructor( boxStore: BoxStore) {
    private val box : Box<DBDetailsModel> = boxStore.boxFor(DBDetailsModel::class.java)

    fun addDBDetails(db : DBDetailsModel){
        box.put(db)
    }

    fun removeDBDetails(){
        box.removeAll()
    }


    fun getAllLessons(): DBDetailsModel? {
        return box.query {
            this.order(DBDetailsModel_.id,QueryBuilder.DESCENDING)
        }.findFirst()
    }
}