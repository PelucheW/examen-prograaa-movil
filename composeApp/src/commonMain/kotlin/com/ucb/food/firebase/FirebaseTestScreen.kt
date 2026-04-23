package com.ucb.food.firebase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FirebaseTestScreen(
    viewModel: FirebaseTestViewModel = koinViewModel()
) {
    val cachedConfig by viewModel.cachedConfig.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
            .padding(16.dp)
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pruebas Firebase",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2E7D32)
        )
        
        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sincronización & Caché Local",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF1B5E20),
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Valor en Room (Caché):",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray
                )
                
                Text(
                    text = cachedConfig,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF2E7D32),
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Surface(
                    color = Color(0xFFC8E6C9),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "Si apagas el internet, este valor persistirá.",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        color = Color(0xFF1B5E20)
                    )
                }
            }
        }
    }
}
