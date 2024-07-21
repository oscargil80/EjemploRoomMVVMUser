package com.oscargil80.exampleroom.repository

import androidx.lifecycle.LiveData
import com.oscargil80.exampleroom.data.UserDao
import com.oscargil80.exampleroom.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend  fun adduser(user: User){
        userDao.addUser(user)


    }


}