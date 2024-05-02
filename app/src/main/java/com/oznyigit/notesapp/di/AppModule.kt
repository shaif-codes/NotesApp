package com.oznyigit.notesapp.di

import android.content.Context
import androidx.room.Room
import com.oznyigit.notesapp.data.datasource.NoteDataSource
import com.oznyigit.notesapp.data.repository.NoteRepository
import com.oznyigit.notesapp.room.Database
import com.oznyigit.notesapp.room.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNoteDataSource(noteDao: NoteDao) : NoteDataSource
    {
        return NoteDataSource(noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(nds: NoteDataSource) : NoteRepository
    {
        return NoteRepository(nds)
    }

    @Provides
    @Singleton
    fun provideNoteDao(@ApplicationContext context: Context) : NoteDao
    {
        val database = Room.databaseBuilder(context, Database::class.java,"notes_app_db.sqlite")
            .createFromAsset("notes_app_db.sqlite").build()

        return database.getNoteDao()
    }
}