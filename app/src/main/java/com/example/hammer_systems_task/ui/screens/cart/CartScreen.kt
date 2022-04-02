package com.example.hammer_systems_task.ui.screens.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hammer_systems_task.R
import com.example.hammer_systems_task.ui.theme.Typography

@Composable
fun CartScreen() {
    CartScreenContent()
}

@Composable
fun CartScreenContent() = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxSize()
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.cart_body),
            style = Typography.body1,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreenContent()
}