package com.diegoviera.gamermvvmapp.domain.use_cases.auth

import com.diegoviera.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.logout()

}