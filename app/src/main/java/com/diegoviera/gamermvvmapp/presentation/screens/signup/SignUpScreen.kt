package com.diegoviera.gamermvvmapp.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.diegoviera.gamermvvmapp.presentation.screens.login.components.LoginBottomBar
import com.diegoviera.gamermvvmapp.presentation.screens.login.components.LoginContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen() {

    Scaffold(
        topBar = {},
        content = {
            Text(text = "SignUpScreen")
        },
        bottomBar = {

        }
    )

}