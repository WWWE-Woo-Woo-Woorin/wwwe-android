package app.junsu.feature_main_nav.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import app.junsu.feature_main_nav._navigation.WWWENavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigationScreen(
    navController: NavHostController,
    content: @Composable () -> Unit,
) {
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues),
            ) {
                content()
            }
        },
        bottomBar = {
            WWWENavigationBar(
                navController = navController,
            )
        },
    )
}
