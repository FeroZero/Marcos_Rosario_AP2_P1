package edu.ucne.marcos_rosario_ap2_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.marcos_rosario_ap2_p1.Navigation.MainNavHost
import edu.ucne.marcos_rosario_ap2_p1.ui.theme.Marcos_Rosario_AP2_P1Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Marcos_Rosario_AP2_P1Theme {
                val navHost = rememberNavController()
                MainNavHost(navHost)
            }
        }
    }
}