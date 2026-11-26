
package com.mar.tareas.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mar.tareas.R
import com.mar.tareas.data.AppScreens
import com.mar.tareas.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla1(
    navController: NavController,
    viewModel: TareaViewModel = hiltViewModel()
) {

    val tareas by viewModel.tareas.collectAsStateWithLifecycle()

    var mostrarCompletadas by remember {
        mutableStateOf(false)
    }

    val tareasFiltradas = tareas.filter {
        it.completada == mostrarCompletadas
    }

    Scaffold(
        containerColor = Fondo,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.titulo_principal),
                        color = Blanco
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Morado
                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        AppScreens.SegundaPantalla.route
                    )
                },
                containerColor = Morado,
                contentColor = Blanco
            ) {
                Text(
                    "+",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

    ) { espacio ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(espacio)
                .padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier.size(55.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "✓",
                        color = Morado,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        stringResource(R.string.saludo),
                        style = MaterialTheme.typography.titleLarge,
                        color = TextoOscuro
                    )

                    Text(
                        stringResource(R.string.subtitulo),
                        color = TextoOscuro
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Button(
                    onClick = {
                        mostrarCompletadas = false
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!mostrarCompletadas) {
                            Morado
                        } else {
                            AzulClaro
                        },
                        contentColor = if (!mostrarCompletadas) {
                            Blanco
                        } else {
                            TextoOscuro
                        }
                    )
                ) {
                    Text(stringResource(R.string.pendientes))
                }

                Button(
                    onClick = {
                        mostrarCompletadas = true
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (mostrarCompletadas) {
                            Morado
                        } else {
                            AzulClaro
                        },
                        contentColor = if (mostrarCompletadas) {
                            Blanco
                        } else {
                            TextoOscuro
                        }
                    )
                ) {
                    Text(stringResource(R.string.completadas))
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = if (mostrarCompletadas) {
                    stringResource(R.string.titulo_tareas_completadas)
                } else {
                    stringResource(R.string.titulo_tareas_pendientes)
                },
                style = MaterialTheme.typography.titleMedium,
                color = TextoOscuro
            )

            Spacer(modifier = Modifier.height(10.dp))

            if (tareasFiltradas.isEmpty()) {

                Text(
                    stringResource(R.string.sin_tareas),
                    color = TextoOscuro
                )

            } else {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(
                        items = tareasFiltradas,
                        key = { it.id }
                    ) { tarea ->

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Blanco
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 3.dp
                            )
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),

                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Checkbox(
                                    checked = tarea.completada,
                                    onCheckedChange = {
                                        viewModel.cambiarEstado(tarea, it)
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Morado
                                    )
                                )

                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {

                                    Text(
                                        tarea.nombre,
                                        color = TextoOscuro,
                                        style = MaterialTheme.typography.titleMedium
                                    )

                                    Spacer(
                                        modifier = Modifier.height(4.dp)
                                    )

                                    Text(
                                        tarea.descripcion,
                                        color = TextoOscuro
                                    )
                                }

                                TextButton(
                                    onClick = {
                                        viewModel.eliminarTarea(tarea)
                                    }
                                ) {
                                    Text(
                                        stringResource(R.string.eliminar),
                                        color = Morado
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

