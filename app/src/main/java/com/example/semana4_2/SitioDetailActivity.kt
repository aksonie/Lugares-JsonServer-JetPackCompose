package com.example.semana4_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.semana4_2.Beans.Sitios
import com.example.semana4_2.ui.theme.Semana4_2Theme

class SitioDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idSitio = intent.getStringExtra("idSitio") ?: ""
        val nombre = intent.getStringExtra("nombre") ?: ""
        val descripcion = intent.getStringExtra("descripcion") ?: ""
        val pais = intent.getStringExtra("pais") ?: ""
        val imagen = intent.getStringExtra("imagen") ?: ""
        val sitio = Sitios(idSitio, nombre, descripcion,pais, imagen)
        Log.d("SitioDetailActivity", "Received Sitio: $sitio")
        setContent {
            Semana4_2Theme {
                SitioDetailView(sitio)
            }
        }
    }
}

@Composable
fun SitioDetailView(sitio: Sitios) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "SitioID: ${sitio.idSitio}", color = Color.Black)
        Text(text = "Nombre: ${sitio.nombre}", color = Color.Black)
        Text(text = "Descripción: ${sitio.descripcion}", color = Color.Black)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(sitio.imagen)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}