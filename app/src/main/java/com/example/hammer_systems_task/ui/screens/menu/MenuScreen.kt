package com.example.hammer_systems_task.ui.screens.menu

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hammer_systems_task.ui.theme.Typography
import com.example.hammer_systems_task.R
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.MutableStateFlow

data class PizzaElement(
    val title: String,
    val body: String,
    val image: Painter,
    val price: String
)

class PizzaRepository() {
    fun getListOfPizza() {
        // TODO
    }
}

//class MenuViewModel() {
//
//   val listOfPizza = MutableStateFlow()
//
//
//    fun getPizza() {
//        listOfPizza.loadOrError {
//            PizzaRepository.getListOfPizza()
//        }
//    }
//}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MenuScreen(
    navController: NavHostController
) {

//    val viewModel: MenuViewModel = viewModel()
//
//    LaunchedEffect(Unit){
//        viewModel.getPizza()
//    }
//
//    val listOfPizza by viewModel.listOfPizza.subcribe...

    val listOfPizza = listOf(
        PizzaElement("Ветчина и грибы", "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус", painterResource(R.drawable.ic_buffalo),"от 345 р"),
        PizzaElement("Баварские колбаски", "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус", painterResource(R.drawable.ic_buffalo),"от 345 р"),
        PizzaElement("Нежный лосось", "Лосось, томаты, оливки,соус песто,помидорки черри", painterResource(R.drawable.ic_buffalo),"от 345 р")
    )

    val listOfCategory = listOf(
        "Пицца", "Комбо", "Десерты", "Напитки"
    )

    MenuScreenContent(
        list = listOfPizza,
        listCategory = listOfCategory
    )
}

@ExperimentalPagerApi
@Composable
fun MenuScreenContent(
   list: List<PizzaElement>,
   listCategory: List<String>
) = LazyColumn(
) {
    item {
         //AppBar
         Row(
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(20.dp),
             horizontalArrangement = Arrangement.SpaceBetween
         ){
             Row{
                Text("Москва")
                 Icon(
                     imageVector = Icons.Default.Person,
                     contentDescription = "Navigation Icon"
                 )
             }
             Icon(
                 imageVector = Icons.Default.Settings,
                 contentDescription = "Navigation Icon"
             )
         }
    }
    item {
        LazyRow(
            modifier = Modifier.padding(20.dp)
        ){
            items(count = 3, itemContent = { page ->
                Text(
                    text =  list[page].title,
                    modifier = Modifier.fillMaxWidth()
                )
            })
        }
    }
    item {
        val pagerState = rememberPagerState()
        HorizontalPager(state = pagerState, count = 4){ page ->
            Text(
                text =  listCategory[page],
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
    items(count = 3, itemContent = { page ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(
                painter = list[page].image,
                contentDescription = "buffalo",
                modifier = Modifier.size(135.dp)
            )
            Column(modifier = Modifier.fillMaxHeight()) {

                Text(
                    text =  list[page].title,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text =  list[page].body,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text =  list[page].price,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    })
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreenContent(
        listOf(
        PizzaElement("Ветчина и грибы", "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус", painterResource(R.drawable.ic_buffalo),"от 345 р"),
        PizzaElement("Баварские колбаски", "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус", painterResource(R.drawable.ic_buffalo),"от 345 р"),
        PizzaElement("Нежный лосось", "Лосось, томаты, оливки,соус песто,помидорки черри", painterResource(R.drawable.ic_buffalo),"от 345 р")
    ),
        listOf(
            "Пицца", "Комбо", "Десерты", "Напитки"
        )
    )
}