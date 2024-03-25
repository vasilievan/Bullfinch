package aleksei.vasilev.bullfinch

import aleksei.vasilev.bullfinch.navigation.NavigationDestination
import aleksei.vasilev.bullfinch.screens.HomeScreen
import aleksei.vasilev.bullfinch.ui.theme.BullfinchTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BullfinchTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationDestination.HOME.destination
                ) {
                    composable(NavigationDestination.HOME.destination) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}