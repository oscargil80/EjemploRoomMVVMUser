package com.oscargil80.exampleroom.repository

import androidx.lifecycle.LiveData
import com.oscargil80.exampleroom.data.UserDao
import com.oscargil80.exampleroom.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend  fun adduser(user: User){
        userDao.addUser(user)
    }

    suspend fun  updateUser(user:User){
        userDao.updateUser(user)
    }

    suspend fun deleteuser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }



}