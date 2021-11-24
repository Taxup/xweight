package com.onepercent.xweight.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.onepercent.xweight.home.ui_homeScreen.HomeScreen
import com.onepercent.xweight.home.ui_homeScreen.HomeScreenViewModel
import com.onepercent.xweight.ui.navigation.BottomBarScreen
import com.onepercent.xweight.weight.ui_weightList.ui.WeightList
import com.onepercent.xweight.weight.ui_weightList.ui.WeightListViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        builder = {
            homeScreen()
            historyScreen()
        }
    )
}

fun NavGraphBuilder.homeScreen() {
    composable(route = BottomBarScreen.Home.route) {
        val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()

        HomeScreen(
            state = homeScreenViewModel.state.value,
            events = homeScreenViewModel::onTriggerEvent,
        )
    }
}

fun NavGraphBuilder.historyScreen() {
    composable(route = BottomBarScreen.History.route) {
        val weightListViewModel: WeightListViewModel = hiltViewModel()

        WeightList(
            state = weightListViewModel.state.value,
            events = weightListViewModel::onTriggerEvent,
        )
    }
}

