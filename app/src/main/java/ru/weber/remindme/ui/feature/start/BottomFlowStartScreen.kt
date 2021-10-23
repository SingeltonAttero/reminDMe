package ru.weber.remindme.ui.feature.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.weber.remindme.ui.feature.screens.BottomStartScreens
import ru.weber.remindme.ui.feature.setting.SettingScreen
import ru.weber.remindme.ui.feature.tasks.TasksScreen

@Composable
fun BottomFlowStartScreen(
    bottomScreens: List<BottomStartScreens> = listOf(
        BottomStartScreens.Tasks,
        BottomStartScreens.History,
        BottomStartScreens.Statistics,
        BottomStartScreens.Setting,
    )
) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { StartBottomBar(bottomNavController, bottomScreens) },
        contentColor = Color.White,
    ) { contentPadding ->
        Box(Modifier.padding(contentPadding)) {
            NavHost(
                navController = bottomNavController,
                startDestination = BottomStartScreens.Tasks.screenKey
            ) {
                composable(BottomStartScreens.Tasks.screenKey) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        TasksScreen()
                    }
                }
                composable(BottomStartScreens.History.screenKey) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                        Text(text = BottomStartScreens.History.screenKey)
                    }
                }
                composable(BottomStartScreens.Statistics.screenKey) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                        Text(text = BottomStartScreens.Statistics.screenKey)
                        listOf<String>().firstOrNull()
                    }
                }
                composable(BottomStartScreens.Setting.screenKey) {
                    SettingScreen()
                }
            }
        }
    }
}

@Composable
private fun StartBottomBar(
    bottomNavController: NavHostController,
    bottomScreens: List<BottomStartScreens>
) {
    BottomNavigation(
        elevation = 10.dp,
        contentColor = Color.White,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        val currentRoute = currentRoute(navController = bottomNavController)
        bottomScreens.forEach { screen ->
            BottomNavigationItem(
                selected = screen.screenKey == currentRoute,
                onClick = {
                    if (screen.screenKey != currentRoute) {
                        bottomNavController.popBackStack()
                        bottomNavController.navigate(screen.screenKey)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(screen.bottomIconDrawable),
                        contentDescription = stringResource(id = screen.titleToolbarRes)
                    )
                },
                label = {
                    Box() {
                        Text(
                            text = stringResource(id = screen.titleToolbarRes),
                            color = Color.White,
                            style = MaterialTheme.typography.overline,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}