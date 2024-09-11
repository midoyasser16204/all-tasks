package com.example.myapplication

import androidx.lifecycle.LiveData

class UserRepo(private val userDao: UserDao) {

    val allUser:LiveData<List<User>> = userDao.getAllUser()

    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
}