package com.example.hammer_systems_task.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.hammer_systems_task.R
import com.example.hammer_systems_task.ui.theme.Typography

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.top_bar_padding)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Text(
                text = stringResource(R.string.city),
                style = Typography.h6
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.city_arrow_between)))
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
        Icon(
            painterResource(R.drawable.ic_qrcode),
            contentDescription = null
        )
    }
}