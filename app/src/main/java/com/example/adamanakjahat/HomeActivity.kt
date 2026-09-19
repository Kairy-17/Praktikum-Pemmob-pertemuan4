package com.example.adamanakjahat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.adamanakjahat.ui.screen.DaftarProdukScreen
import com.example.adamanakjahat.ui.theme.JualanTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                DaftarProdukScreen()
            }
        }
    }
}
