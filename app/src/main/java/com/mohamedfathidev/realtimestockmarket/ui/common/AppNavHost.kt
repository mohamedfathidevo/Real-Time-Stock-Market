package com.mohamedfathidev.realtimestockmarket.ui.common

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mohamedfathidev.realtimestockmarket.ui.details.screen.DetailScreen
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.HomeScreen
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.InstrumentType

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavDestinations.Home.url) {
        composable(route = NavDestinations.Home.url) {
            HomeScreen(navController)
        }
        composable(route = NavDestinations.Details.url) {
            DetailScreen(navController)
        }
    }
}

sealed class NavDestinations(val url: String) {
    object Home : NavDestinations("home")
    object Details : NavDestinations("details?symbol={symbol}&type={type}") {
        fun uri(symbol: String, type: InstrumentType) =
            url.replace("{symbol}", symbol)
                .replace("{type}", type.toString())

        fun getSymbol(savedStateHandle: SavedStateHandle): String? = savedStateHandle["symbol"]
        fun getType(savedStateHandle: SavedStateHandle): InstrumentType? =
            savedStateHandle.get<String?>("type")?.let { InstrumentType.valueOf(it) }
    }
}
