package aleksei.vasilev.bullfinch

import aleksei.vasilev.bullfinch.navigation.NavigationDestination
import aleksei.vasilev.bullfinch.navigation.NavigatorImpl
import aleksei.vasilev.bullfinch.screens.HomeScreen
import aleksei.vasilev.bullfinch.screens.PermissionsScreen
import aleksei.vasilev.bullfinch.ui.theme.BullfinchTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: NavigatorImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            BullfinchTheme {
                val navController = rememberNavController()
                navigator.setNavHostController(navController)
                NavHost(
                    navController = navController,
                    startDestination = NavigationDestination.PERMISSONS.destination
                ) {
                    composable(NavigationDestination.PERMISSONS.destination) {
                        PermissionsScreen()
                    }
                    composable(NavigationDestination.HOME.destination) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}