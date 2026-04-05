package com.example.tabuladores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tabuladores.ui.theme.TabuladoresTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TabuladoresTheme {
                Scaffold() { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding))
                    {
                        //PagerTabsAnt()
                        PagerTabs()
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerTabs() {

    val tabs = listOf(
        "Uno", "Dos", "Tres","cuatro","cinco",
        "seis","siete","ocho","nueve","diez","once"
    )

    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope()

    Column {

        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 8.dp,
            indicator = { tabPositions ->

                val currentTabPosition = tabPositions[pagerState.currentPage]

                Box(
                    Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                ) {
                    Box(
                        Modifier
                            .offset(x = currentTabPosition.left)
                            .width(currentTabPosition.width)
                            .height(4.dp) // 👈 más grueso (estilo moderno)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(50)
                            )
                    )
                }
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(title) }
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            Text("Página $page", modifier = Modifier.padding(16.dp))
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerTabsAnt() {
    val tabs = listOf("Uno", "Dos", "Tres","cuatro","cinco","seis","siete","ocho","nueve","diez","once")
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope() // 👈 correcto

    Column {
        ScrollableTabRow(selectedTabIndex = pagerState.currentPage, edgePadding = 8.dp) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(title) }
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            Text("Página $page")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TabuladoresTheme {
        PagerTabsAnt()
    }
}