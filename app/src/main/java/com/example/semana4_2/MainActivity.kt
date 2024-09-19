package com.example.semana4_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.foundation.lazy.items
import com.example.semana4_2.Beans.Sitios
import com.example.semana4_2.Modelo.SitiosViewModel
import com.example.semana4_2.ui.theme.Semana4_2Theme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<SitiosViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana4_2Theme {
                Box(modifier = Modifier.fillMaxSize()){
                    viewModel.getSitios()
                    Vista(viewModel.listaSitios,viewModel)
                }
            }
        }
    }
}




@Composable
fun Vista(listaSitios:ArrayList<Sitios>, viewModel: SitiosViewModel){
    val context = LocalContext.current
    Column(modifier= Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .padding(16.dp)){
        LazyColumn(contentPadding = PaddingValues(
            horizontal = 15.dp,
            vertical=8.dp
        )) {
            items(listaSitios){ sitio->
                Card(modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 10.dp)
                        .clickable{
                            Log.d("Vista", "Clicked on Sitio: $sitio")
                            val intent = Intent(context, SitioDetailActivity::class.java).apply {
                                putExtra("idSitio", sitio.idSitio)
                                putExtra("nombre", sitio.nombre)
                                putExtra("descripcion", sitio.descripcion)
                                putExtra("pais", sitio.pais)
                                putExtra("imagen", sitio.imagen)
                            }
                            context.startActivity(intent)
                        },
                        elevation=CardDefaults.cardElevation(defaultElevation = 8.dp)){
                        Column {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(sitio.imagen)
                                    .build(),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp))
                            Text(text = "SitioID: ${sitio.idSitio}")
                            Text(text = "Nombre: ${sitio.nombre}")
                        }
                    }
            }
        }

    }
}
