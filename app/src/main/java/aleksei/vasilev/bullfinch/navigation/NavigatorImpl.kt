package aleksei.vasilev.bullfinch.navigation

import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import javax.inject.Inject

class NavigatorImpl @Inject constructor() {
    private var navController: NavHostController? = null

    fun getCurrentDestination() = NavigationDestination.getNavigationDestination(navController?.currentDestination?.route)

    fun setNavHostController(controller: NavHostController) {
        if (navController == null) {
            synchronized(this) {
                if (navController == null) {
                    navController = controller
                }
            }
        }
    }

    fun navigateTo(
        startDestination: NavigationDestination,
        navigationDestination: NavigationDestination
    ) {
        val options = navOptions {
            launchSingleTop = true
            restoreState = true
            popUpTo(startDestination.destination)
        }
        navController?.navigate(route = navigationDestination.destination, navOptions = options)
    }

    fun popUp(navigationDestination: NavigationDestination) {
        navController?.popBackStack(route = navigationDestination.destination, inclusive = false)
    }
}