package com.poudean.lightner.db.boxes

import com.poudean.lightner.db.ObjectBox
import com.poudean.lightner.db.models.DBDetailsModel
import io.objectbox.Box
import io.objectbox.BoxStore

class DBDetailsBox constructor( boxStore: BoxStore) {
    private val box : Box<DBDetailsModel> = boxStore.boxFor(DBDetailsModel::class.java)

    fun addDBDetails(db : DBDetailsModel){
        box.put(db)
    }

    fun removeDBDetails(){
        box.removeAll()
    }
}