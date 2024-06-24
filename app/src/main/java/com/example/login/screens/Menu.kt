package com.example.login.screens

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

private fun isSelected(currentDestination: NavDestination?, route: String): Boolean {
    return currentDestination?.hierarchy?.any { it.route == route } == true
}


@Composable
fun Menu() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {

            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry.value?.destination
            
            BottomNavigation {
                BottomNavigationItem(
                    selected = isSelected(currentDestination, "home"),
                    onClick = { navController.navigate("home") },
                    icon = {
                        Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "home")
                    })

                BottomNavigationItem(
                    selected = isSelected(currentDestination, "viagem"),
                    onClick = { navController.navigate("viagem") },
                    icon = {
                        Icon(imageVector = Icons.Filled.AddCircle, contentDescription = "viagem")
                    })

                BottomNavigationItem(
                    selected = isSelected(currentDestination, "sobre"),
                    onClick = { navController.navigate(" sobre") },
                    icon = {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = "sobre")
                    })
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

            NavHost(navController = navController, startDestination = "home" ) {
                composable("home") {
                    Home()
                }
                composable("viagem") {
                    Viagem(navController)
                }
                composable("sobre") {
                    Sobre()
                }

            }
        }
    }
}



