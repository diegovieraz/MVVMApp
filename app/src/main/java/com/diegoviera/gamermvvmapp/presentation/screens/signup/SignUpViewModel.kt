package com.diegoviera.gamermvvmapp.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoviera.gamermvvmapp.domain.model.Response
import com.diegoviera.gamermvvmapp.domain.model.User
import com.diegoviera.gamermvvmapp.domain.use_cases.auth.AuthUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {

    //USERNAME
    val username: MutableState<String> = mutableStateOf("")
    var isUserNameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")

    //EMAIL
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    //PASSWORD
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    //CONFIRM PASSWORD
    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isConfirmPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledSignUpButton: Boolean = false

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow : StateFlow<Response<FirebaseUser>?> = _signupFlow


    fun onSignup() {
        val user = User(
            username = username.value,
            email = email.value,
            password = password.value
        )

        signup(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = authUseCases.signUp(user)
        _signupFlow.value = result
    }


    fun enabledSignUpButton() {
        isEnabledSignUpButton = isUserNameValid.value && isPasswordValid.value && isEmailValid.value && isConfirmPasswordValid.value
    }

    fun validateUsername() {
        //ES UN USERNAME VÁLIDO
        if (username.value.length >= 5) {
            isUserNameValid.value = true
            usernameErrMsg.value = ""
        } else {
            isUserNameValid.value = false
            usernameErrMsg.value = "Al menos 5 caracteres."
        }

        enabledSignUpButton()
    }

    fun validateEmail() {
        //ES UN EMAIL VÁLIDO
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrMsg.value = "El email no es válido."
        }

        enabledSignUpButton()
    }

    fun validatePassword() {
        //ES UN PASSWORD VÁLIDO
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrMsg.value = "Al menos 6 caracteres."
        }

        enabledSignUpButton()
    }

    fun validateConfirmPassword() {
        //ES UN PASSWORD IGUAL
        if (password.value.equals(confirmPassword.value)){
            isConfirmPasswordValid.value = true
            confirmPasswordErrMsg.value = ""
        } else {
            isConfirmPasswordValid.value = false
            confirmPasswordErrMsg.value = "Las contraseñas no coinciden"
        }

        enabledSignUpButton()
    }

}