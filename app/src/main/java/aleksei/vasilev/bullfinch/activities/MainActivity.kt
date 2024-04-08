package aleksei.vasilev.bullfinch.activities

import aleksei.vasilev.bullfinch.navigation.NavigationDestination
import aleksei.vasilev.bullfinch.navigation.NavigatorImpl
import aleksei.vasilev.bullfinch.screens.HomeScreen
import aleksei.vasilev.bullfinch.screens.PermissionsScreen
import aleksei.vasilev.bullfinch.ui.theme.BullfinchTheme
import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: NavigatorImpl

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            BullfinchTheme {
                val coroutineScope = rememberCoroutineScope()
                val navController = rememberNavController()
                navigator.setNavHostController(navController)
                val permissions = rememberMultiplePermissionsState(
                    permissions = listOf(
                        Manifest.permission.INTERNET,
                        Manifest.permission.RECORD_AUDIO
                    )
                )
                LaunchedEffect(permissions) {
                    if (!permissions.allPermissionsGranted) {
                        coroutineScope.launch(Dispatchers.Main) {
                            navigator.navigateTo(
                                navigator.getCurrentDestination(),
                                NavigationDestination.PERMISSIONS
                            )
                        }
                    } else {
                        navigator.popUp(navigator.getCurrentDestination())
                    }
                }
                NavHost(
                    navController = navController,
                    startDestination = NavigationDestination.HOME.destination
                ) {
                    composable(NavigationDestination.PERMISSIONS.destination) {
                        PermissionsScreen(permissions = permissions)
                    }
                    composable(NavigationDestination.HOME.destination) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}