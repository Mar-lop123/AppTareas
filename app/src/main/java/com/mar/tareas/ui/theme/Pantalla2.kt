package com.mar.tareas.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.mar.tareas.R
import com.mar.tareas.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
//anotsacion


@Composable
fun Pantalla2(
    navController: NavController,
    viewModel: TareaViewModel = hiltViewModel()
) {

    var nombre by remember {
        mutableStateOf("")
    }

    var descripcion by remember {
        mutableStateOf("")
    }

    var mostrarError by remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = Fondo,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.nueva_tarea),
                        color = Blanco
                    )
                },

                navigationIcon = {
                    TextButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Text(
                            "←",
                            color = Blanco
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Morado
                )
            )
        }

    ) { espacio ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(espacio)
                .padding(20.dp),

            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            Text(
                stringResource(R.string.titulo_nueva_actividad),
                style = MaterialTheme.typography.headlineSmall,
                color = TextoOscuro
            )

            Text(
                stringResource(R.string.agregar_actividad),
                color = TextoOscuro
            )

            OutlinedTextField(
                value = nombre,

                onValueChange = {
                    nombre = it
                    mostrarError = false
                },

                label = {
                    Text(stringResource(R.string.nombre_tarea))
                },

                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                singleLine = true,
                isError = mostrarError
            )

            if (mostrarError) {
                Text(
                    stringResource(R.string.error_nombre),
                    color = MaterialTheme.colorScheme.error
                )
            }

            OutlinedTextField(
                value = descripcion,

                onValueChange = {
                    descripcion = it
                },

                label = {
                    Text(stringResource(R.string.descripcion_tarea))
                },

                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                minLines = 4
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {

                    if (nombre.isNotBlank()) {

                        viewModel.agregarTarea(
                            nombre.trim(),
                            descripcion.trim()
                        )

                        navController.popBackStack()

                    } else {
                        mostrarError = true
                    }
                },

                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Morado
                )
            ) {
                Text(stringResource(R.string.guardar_tarea))
            }

            OutlinedButton(
                onClick = {
                    navController.popBackStack()
                },

                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text(
                    stringResource(R.string.cancelar),
                    color = Morado
                )
            }
        }
    }
}
