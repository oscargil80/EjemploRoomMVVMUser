package com.oscargil80.exampleroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscargil80.exampleroom.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract  class UserDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INTANCE: UserDataBase? = null

        fun getDatabase(context: Context): UserDataBase{
            val tempInstance = INTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "user_database"
                ).build()
                INTANCE = instance
                return  instance
            }

        }
    }





}