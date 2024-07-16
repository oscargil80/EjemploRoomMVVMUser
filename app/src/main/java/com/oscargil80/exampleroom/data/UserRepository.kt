package com.oscargil80.exampleroom.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend  fun adduser(user:User){
        userDao.addUser(user)


    }


}