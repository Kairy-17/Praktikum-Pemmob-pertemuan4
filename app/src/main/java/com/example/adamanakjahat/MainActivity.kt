package com.example.adamanakjahat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adamanakjahat.ui.screen.HubungiKamiScreen
import com.example.adamanakjahat.ui.theme.JualanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                val navController = rememberNavController()
                
                NavHost(
                    navController = navController,
                    startDestination = "hubungi_kami"
                ) {
                    composable("hubungi_kami") {
                        HubungiKamiScreen(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
