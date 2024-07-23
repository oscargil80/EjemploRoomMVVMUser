package com.oscargil80.exampleroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oscargil80.exampleroom.data.UserDataBase
import com.oscargil80.exampleroom.repository.UserRepository
import com.oscargil80.exampleroom.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application)  {

     val  readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.adduser(user)
        }
    }

    fun  updateUser(user:User){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteuser(user)
        }
    }

    fun deleteAllUser(){
    viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAllUsers()
    }
    }



}