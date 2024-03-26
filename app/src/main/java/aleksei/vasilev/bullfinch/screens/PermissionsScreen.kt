package aleksei.vasilev.bullfinch.screens

import aleksei.vasilev.bullfinch.viewmodels.permissionsviewmodel.PermissionsViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

// import com.google.accompanist.permissions.ExperimentalPermissionsApi
// import com.google.accompanist.permissions.rememberMultiplePermissionsState

// @OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsScreen(
    viewModel: PermissionsViewModel = hiltViewModel()
) {
    // val permissions = rememberMultiplePermissionsState(
    //     permissions = listOf(
    //         Manifest.permission.INTERNET,
    //         Manifest.permission.RECORD_AUDIO
    //     )
    // )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.goHome()
        }) {
            // hardcoded string literal yet
            Text(text = "Permissions")
        }
    }
}