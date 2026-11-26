package com.mar.tareas.data

sealed class AppScreens(val route: String) {

    object PrimeraPantalla : AppScreens("Inicio")

    object SegundaPantalla : AppScreens("NuevaTarea")

}