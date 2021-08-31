package com.example.mvvmwithroom.room

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper



@Database(entities = [LoginDetails::class], version = 1,exportSchema=false)
 abstract class ApplicationDatabaseClass : RoomDatabase() {

    abstract fun applicationDAOclass():ApplicationDAOclass

    companion object{
        var applicationDatabaseClass:ApplicationDatabaseClass?=null

        fun newInstance(context: Context):ApplicationDatabaseClass?{
            if(applicationDatabaseClass == null){
               applicationDatabaseClass= Room.databaseBuilder(context,ApplicationDatabaseClass::class.java,"login_database")
                                        .allowMainThreadQueries()
                                        .build()
            }
            return applicationDatabaseClass
        }
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}
