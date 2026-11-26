package com.mar.tareas.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mar.tareas.data.AppScreens

@Composable
fun AppNavegacion() {

    val navController = rememberNavController()

    NavHost(

        navController = navController,

        startDestination = AppScreens.PrimeraPantalla.route

    ) {

        composable(AppScreens.PrimeraPantalla.route) {

            Pantalla1(
                navController = navController
            )

        }

        composable(AppScreens.SegundaPantalla.route) {

            Pantalla2(
                navController = navController
            )

        }

    }

}
