package com.oscargil80.exampleroom.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.exampleroom.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user:User)

    @Delete
    suspend fun deleteUser(user:User)

    @Query("Delete from user_table")
    suspend fun deleteAllUsers()

    @Query("Select * from user_table order by id ASC")
    fun readAllData(): LiveData<List<User>>


}