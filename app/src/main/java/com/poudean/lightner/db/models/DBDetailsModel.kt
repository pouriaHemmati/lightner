package com.poudean.lightner.db.models

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class DBDetailsModel(
    @Id var id : Long = 0,
    var versionCode : Int = 1
)
