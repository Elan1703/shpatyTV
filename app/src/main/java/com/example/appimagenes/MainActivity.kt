package com.example.appimagenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Usamos Box para el contenedor principal
            Box(modifier = Modifier.fillMaxSize()) {
                FondoImageWithClock()
            }
        }
    }
}

@Composable
fun FondoImageWithClock(modifier: Modifier = Modifier) {
    // Lista de imágenes de fondos
    val images = listOf(
        R.drawable.fondo1,
        R.drawable.fondo2,
        R.drawable.fondo3,
        R.drawable.fondo4,
        R.drawable.fondo5,
        R.drawable.fondo6,
        R.drawable.fondo7,
        R.drawable.fondo8,
        R.drawable.fondo9,
        R.drawable.fondo10,



    )
    var currentImageIndex by remember { mutableStateOf(0) }

    // Aseguramos que el índice de la imagen se mantenga dentro de los límites de la lista
    val changeImage: () -> Unit = {
        currentImageIndex = (currentImageIndex + 1) % images.size
    }

    // Contenedor principal
    Box(modifier = modifier.fillMaxSize()) {
        // Mostrar la imagen de fondo
        val image: Painter = painterResource(id = images[currentImageIndex])
        Image(
            painter = image,
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize()
                .clickable { changeImage() }  // Cambiar la imagen al hacer clic
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FondoImageWithClockPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        FondoImageWithClock()
    }
}
