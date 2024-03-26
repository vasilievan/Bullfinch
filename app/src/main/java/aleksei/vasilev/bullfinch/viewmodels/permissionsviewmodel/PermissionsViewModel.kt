package aleksei.vasilev.bullfinch.viewmodels.permissionsviewmodel

import aleksei.vasilev.bullfinch.navigation.NavigationDestination
import aleksei.vasilev.bullfinch.navigation.NavigatorImpl
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PermissionsViewModel @Inject constructor(
    private val navigator: NavigatorImpl
) : ViewModel() {
    fun goHome() {
        viewModelScope.launch(Dispatchers.Main) {
            navigator.navigateTo(NavigationDestination.HOME, NavigationDestination.PERMISSONS)
        }
    }
}