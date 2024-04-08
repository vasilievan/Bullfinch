package aleksei.vasilev.bullfinch.screens

import aleksei.vasilev.bullfinch.R
import aleksei.vasilev.bullfinch.TestActivity
import aleksei.vasilev.bullfinch.ui.theme.BullfinchTheme
import android.Manifest
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class PermissionsScreenTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @OptIn(ExperimentalPermissionsApi::class)
    @Before
    fun setup() {
        hiltRule.inject()
        composeTestRule.setContent {
            BullfinchTheme {
                val permissions = rememberMultiplePermissionsState(
                    permissions = listOf(
                        Manifest.permission.INTERNET,
                        Manifest.permission.RECORD_AUDIO
                    )
                )
                PermissionsScreen(permissions = permissions)
            }
        }
    }

    @Test
    fun isPermissionsScreenShownCorrectly() {
        val context = composeTestRule.activity
        composeTestRule.apply {
            onNode(hasText(context.getString(R.string.permissions))).assertExists()
            onNode(hasText(context.getString(R.string.permissions_reason))).assertExists()
            onNode(hasText(context.getString(R.string.request_permissions))).assertExists()
        }
    }
}