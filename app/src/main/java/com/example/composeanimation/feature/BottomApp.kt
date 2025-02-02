package com.example.composeanimation.feature

import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.composeanimation.ui.theme.Purple40
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.ShapeCornerRadius

@Composable
fun BottomNavigate() {

    var NavigationBarItems = remember { NavigationBarItems.values() }
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier.height(65.dp),
                selectedIndex = selectedIndex,
                cornerRadius = ShapeCornerRadius(
                    topLeft = 70f,
                    topRight = 70f,
                    bottomLeft = 0f,
                    bottomRight = 0f
                ),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                ballColor = Purple40,
                barColor = Purple40
            ) {
                NavigationBarItems.forEach { item ->
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .clickable { selectedIndex = item.ordinal },
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            imageVector = item.icon,
                            contentDescription = "",
                            tint = if (selectedIndex == item.ordinal) Color.White
                                else Color.Gray
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        paddingValues
    }
}

enum class NavigationBarItems(val icon : ImageVector){
    Person(icon = Icons.Default.Person),
    Settings(icon = Icons.Default.Settings),
    Home(icon = Icons.Default.Home),
    Favorite(icon = Icons.Default.Favorite),
    Notifications(icon = Icons.Default.Notifications),
}

//fun Modifier.noOnclick(onClick: () -> Unit): Modifier = composed{
//    clickable (
//        indication = null,
//
//    )
//}