package com.diegoviera.gamermvvmapp.domain.use_cases.auth

import com.diegoviera.gamermvvmapp.domain.model.User
import com.diegoviera.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class SignUp @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.signUp(user)

}