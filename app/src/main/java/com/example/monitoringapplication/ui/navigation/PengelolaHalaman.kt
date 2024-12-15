package com.example.monitoringapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import  androidx.navigation.NavHostController
import com.example.monitoringapplication.ui.view.mahasiswa.DestinasiInsert
import com.example.monitoringapplication.ui.view.mahasiswa.InsertMhsView


@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiInsert.route){
        composable(route = DestinasiInsert.route
        ){InsertMhsView(
            onBack = {}, onNavigate = {}
        )
        }
    }
}