package edu.ucne.marcos_rosario_ap2_p1.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ListScreen
    ) {

        composable<Screen.ListScreen> {

        }


        composable<Screen.EditScreen> {


        }
    }
}