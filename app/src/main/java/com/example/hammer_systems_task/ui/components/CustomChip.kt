package com.example.hammer_systems_task.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hammer_systems_task.R
import com.example.hammer_systems_task.ui.theme.Pink200
import com.example.hammer_systems_task.ui.theme.Pink400
import com.example.hammer_systems_task.ui.theme.Shapes
import com.example.hammer_systems_task.ui.theme.Typography

@Composable
fun CustomChip(
    selected: Boolean = false,
    onSelectedChange: (String) -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> Pink200
            else -> Color.White
        },
        contentColor = when {
            selected -> Pink400
            else -> Color.LightGray
        },
        shape = Shapes.medium,
        modifier = when {
            selected -> modifier
            else -> modifier.advancedShadow(
                color = Color(0xFFBEBEBE),
                alpha = 0.17f,
                cornersRadius = 6.dp,
                shadowBlurRadius = 10.dp
            )
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .toggleable(
                    value = selected,
                    onValueChange = {
                        onSelectedChange(text)
                    }
                )
                .width(dimensionResource(R.dimen.chip_width))

        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = when {
                    selected -> Typography.subtitle1
                    else -> Typography.body2
                },
                modifier = Modifier.padding(dimensionResource(R.dimen.chip_text_padding))
            )
        }
    }
}

// Jetpack Compose does not have the ability to specify the shadow radius,
// only the blur radius, I had to use canvas
fun Modifier.advancedShadow(
    color: Color = Color.Black,
    alpha: Float = 0f,
    cornersRadius: Dp = 0.dp,
    shadowBlurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = drawBehind {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparentColor = color.copy(alpha = 0f).toArgb()

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowBlurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            cornersRadius.toPx(),
            cornersRadius.toPx(),
            paint
        )
    }
}
