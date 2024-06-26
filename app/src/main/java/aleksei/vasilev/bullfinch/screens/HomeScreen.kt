package aleksei.vasilev.bullfinch.screens

import aleksei.vasilev.bullfinch.viewmodels.homeviewmodel.HomeViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import timber.log.Timber

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        Timber.d("Welcome home.")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.goPermissions()
        }) {
            // hardcoded string literal yet
            Text(text = "Home")
        }
    }
}