
package com.mar.tareas.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val ColoresAplicacion = lightColorScheme(
    primary = Morado,
    secondary = AzulClaro,
    background = Fondo,
    surface = Blanco,
    onPrimary = Blanco,
    onBackground = TextoOscuro,
    onSurface = TextoOscuro
)

@Composable
fun ListaDeTareasTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ColoresAplicacion,
        content = content
    )
}
