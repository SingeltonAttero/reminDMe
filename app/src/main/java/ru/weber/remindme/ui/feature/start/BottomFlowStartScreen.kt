package ru.weber.remindme.ui.feature.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.weber.remindme.ui.feature.screens.BottomStartScreens

@Composable
fun BottomFlowStartScreen(
    mainNavHostController: NavHostController,
    bottomScreens: List<BottomStartScreens> = listOf(
        BottomStartScreens.Home,
        BottomStartScreens.History,
        BottomStartScreens.Statistics,
        BottomStartScreens.Setting,
    )
) {
    val bottomNavController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                elevation = 8.dp
            ) {
                val currentRoute = currentRoute(navController = bottomNavController)
                bottomScreens.forEach { screen ->
                    BottomNavigationItem(
                        selected = screen.screenName == currentRoute,
                        onClick = {
                            bottomNavController.navigate(screen.screenName)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(screen.bottomIconDrawable),
                                contentDescription = stringResource(id = screen.titleToolbarRes)
                            )
                        },
                        label = {
                            Text(text = stringResource(id = screen.titleToolbarRes))
                        }
                    )
                }
            }
        },
    ) {
        NavHost(
            navController = bottomNavController,
            startDestination = BottomStartScreens.Home.screenName
        ) {
            composable(BottomStartScreens.Home.screenName) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = BottomStartScreens.Home.screenName)
                }
            }
            composable(BottomStartScreens.History.screenName) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                    Text(text = BottomStartScreens.History.screenName)
                }
            }
            composable(BottomStartScreens.Statistics.screenName) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                    Text(text = BottomStartScreens.Statistics.screenName)
                }
            }
            composable(BottomStartScreens.Setting.screenName) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                    Text(text = BottomStartScreens.Setting.screenName)
                }
            }
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}