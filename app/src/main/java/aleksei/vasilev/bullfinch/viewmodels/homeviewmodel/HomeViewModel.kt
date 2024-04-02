package aleksei.vasilev.bullfinch.viewmodels.homeviewmodel

import aleksei.vasilev.bullfinch.navigation.NavigationDestination
import aleksei.vasilev.bullfinch.navigation.NavigatorImpl
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val navigator: NavigatorImpl) : ViewModel() {
    fun goPermissions() {
        viewModelScope.launch(Dispatchers.Main) {
            navigator.popUp(NavigationDestination.PERMISSIONS)
        }
    }
}