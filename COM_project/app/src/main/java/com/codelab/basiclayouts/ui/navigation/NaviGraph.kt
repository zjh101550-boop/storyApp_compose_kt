package com.codelab.basiclayouts.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codelab.basiclayouts.ui.screens.shared.LoginScreen
import com.codelab.basiclayouts.ui.screens.shared.ForgotPasswordScreen
import com.codelab.basiclayouts.ui.screens.shared.ResetPasswordScreen
import com.codelab.basiclayouts.ui.screens.shared.SignupScreen
import com.codelab.basiclayouts.ui.screens.shared.GuestScreen
import com.codelab.basiclayouts.ui.screens.shared.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "GuestScreen"
    ) {
        composable(route = "MainScreen") {
            MainScreen(navController)
        }
        composable(route = "LoginScreen") {
            LoginScreen(navController)
        }
        composable(route = "ForgotPassword") {
            ForgotPasswordScreen(navController)
        }
        composable(route = "ResetPassword") {
            ResetPasswordScreen(navController)
        }
        composable(route = "SignupScreen") {
            SignupScreen(navController)
        }
//        composable(route = "author_home_Screen") {
//            AuthorMainScreen(navController)
//        }
        composable(route = "GuestScreen") {
            GuestScreen(navController)
        }
    }
}
