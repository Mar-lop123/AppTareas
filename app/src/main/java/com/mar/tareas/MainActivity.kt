package com.mar.tareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mar.tareas.ui.AppNavegacion
import com.mar.tareas.ui.theme.ListaDeTareasTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            ListaDeTareasTheme {

                AppNavegacion()

            }

        }

    }

}
