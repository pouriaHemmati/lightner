package com.poudean.lightner

import androidx.multidex.MultiDexApplication
import com.poudean.lightner.db.ObjectBox
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class lightnerApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

    }
}