package com.poudean.lightner.di

import android.content.Context
import com.poudean.lightner.db.ObjectBox
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideObjectBox(@ApplicationContext appContext: Context) = ObjectBox(appContext)
}