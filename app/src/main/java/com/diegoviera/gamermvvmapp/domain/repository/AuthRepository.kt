package com.diegoviera.gamermvvmapp.domain.repository

import com.diegoviera.gamermvvmapp.domain.model.Response
import com.diegoviera.gamermvvmapp.domain.model.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email:String, password:String): Response<FirebaseUser>
    suspend fun signUp(user: User): Response<FirebaseUser>
    fun logout()

}