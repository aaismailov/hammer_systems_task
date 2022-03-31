package com.example.hammer_systems_task.ui.screens.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.hammer_systems_task.ui.theme.Typography
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun ProfileScreen(
    navController: NavHostController
) {
    ProfileScreenContent(
    )
}


@Composable
fun ProfileScreenContent(
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Вас не существует.",
            style = Typography.body1,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreenContent()
}