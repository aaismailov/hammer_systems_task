package com.example.hammer_systems_task.ui.screens.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hammer_systems_task.R
import com.example.hammer_systems_task.data.*
import com.example.hammer_systems_task.ui.components.CustomChip
import com.example.hammer_systems_task.ui.theme.Gray400
import com.example.hammer_systems_task.ui.theme.Pink400
import com.example.hammer_systems_task.ui.theme.Shapes
import com.example.hammer_systems_task.ui.theme.Typography
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun MenuScreen() {

    val viewModel: MenuViewModel = viewModel()

    val selectedCategory = viewModel.selectedCategory.value

    MenuScreenContent(
        list = getAllFoodElements(),
        listCategory = getAllFoodCategories(),
        listBanner = getAllFoodBanners(),
        selectedCategory = selectedCategory,
        onSelectedChange = viewModel::onSelectedChange
    )
}

@Composable
fun MenuScreenContent(
    list: List<FoodElement>,
    listCategory: List<FoodCategory>,
    listBanner: List<FoodBanner>,
    selectedCategory: FoodCategory?,
    onSelectedChange: (String) -> Unit
) {
    Column {
        val state = rememberCollapsingToolbarScaffoldState()

        CollapsingToolbarScaffold(
            modifier = Modifier
                .fillMaxSize(),
            state = state,
            scrollStrategy = ScrollStrategy.EnterAlwaysCollapsed,
            toolbar = {
                LazyRow {
                    items(count = 3, itemContent = { page ->
                        Box(
                            modifier = Modifier
                                .width(dimensionResource(R.dimen.banner_width))
                        ) {
                            Image(
                                painter = painterResource(listBanner[page].image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    })
                }
            }
        ) {
            val state2 = rememberCollapsingToolbarScaffoldState()

            CollapsingToolbarScaffold(
                modifier = Modifier
                    .fillMaxSize(),
                state = state2,
                scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
                toolbar = {
                    LazyRow(
                        modifier = Modifier
                            .padding(
                                vertical = dimensionResource(R.dimen.category_vert),
                                horizontal = dimensionResource(R.dimen.category_hor)
                            )
                    ) {
                        items(count = 4, itemContent = { page ->
                            CustomChip(
                                selected = listCategory[page] == selectedCategory,
                                text = listCategory[page].value,
                                onSelectedChange = {
                                    onSelectedChange(listCategory[page].value)
                                },
                                modifier = Modifier
                                    .padding(horizontal = dimensionResource(R.dimen.category_between))
                            )
                        })
                    }
                }
            ) {
                LazyColumn {
                    items(count = 7, itemContent = { page ->
                        Column {
                            Divider(
                                color = Color(0xFFF3F5F9),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(dimensionResource(R.dimen.divider_height))
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(dimensionResource(R.dimen.item_padding))
                            ) {
                                Image(
                                    painter = painterResource(list[page].image),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(dimensionResource(R.dimen.image_size))
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(horizontal = dimensionResource(R.dimen.item_text_padding))
                                ) {
                                    Text(
                                        text = list[page].title,
                                        style = Typography.h5,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                    Text(
                                        text = list[page].body,
                                        style = Typography.body1,
                                        color = Gray400,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = dimensionResource(R.dimen.item_body_padding))
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Surface(
                                            color = Color.Transparent,
                                            contentColor = Pink400,
                                            border = BorderStroke(
                                                width = 1.dp,
                                                color = Pink400
                                            ),
                                            shape = Shapes.medium
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                modifier = Modifier
                                                    .width(dimensionResource(R.dimen.chip_width))
                                            ) {
                                                Text(
                                                    text = list[page].price,
                                                    textAlign = TextAlign.End,
                                                    style = Typography.body2,
                                                    modifier = Modifier
                                                        .padding(dimensionResource(R.dimen.chip_text_padding))
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreenContent(
        list = getAllFoodElements(),
        listCategory = getAllFoodCategories(),
        listBanner = getAllFoodBanners(),
        selectedCategory = FoodCategory.PizzaCategory,
        onSelectedChange = {}
    )
}