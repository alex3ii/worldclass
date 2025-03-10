package com.example.worldclass.ui.theme.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx. compose. ui. unit.dp
import kotlinx.coroutines.launch
import androidx. compose. runtime. getValue
import androidx.compose.runtime.remember
import androidx. compose. runtime. setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import com.example.worldclass.Data.Model.MenuModel
import androidx. compose. foundation. lazy. items
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.worldclass.ui.theme.Components.PostCardComponent

@Composable
fun ComponentsScreen (navController:NavHostController){
    val menuOptions= arrayOf(
        MenuModel(1,"Buttons","buttons",Icons.Filled.Home),
        MenuModel(2,"Floating Buttons","floating-buttons",Icons.Filled.AddCircle),
        MenuModel(3,"Progress","progress",Icons.Filled.Home),
        MenuModel(4,"chips","progress",Icons.Filled.Home),
        MenuModel(5,"sliders","progress",Icons.Filled.Home),
        MenuModel(6,"switches","progress",Icons.Filled.Home),
        MenuModel(7,"Badges","progress",Icons.Filled.Home),
        MenuModel(8,"SnackBars","progress",Icons.Filled.Home),
        MenuModel(9,"AlertDialogs","progress",Icons.Filled.Home),

    )
    var option by rememberSaveable{ mutableStateOf("bars") }
    var drawerState= rememberDrawerState(initialValue= DrawerValue.Closed)
    var scope= rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent={
            ModalDrawerSheet{
                Text("Menu",modifier= Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOptions) { item ->
                        NavigationDrawerItem(
                            icon = { Icon(item.icon, contentDescription = "") },
                            label = { Text(item.tittle) },
                            selected = false,
                            onClick = {
                                option = item.option
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )
                    }
                }
                NavigationDrawerItem(
                    icon={ Icon(Icons.Filled.AccountBox,contentDescription="") },
                    label={Text("floating buttons")},
                    selected=false,
                    onClick = {
                        option="floating-buttons"
                        scope.launch {
                            drawerState.apply{
                                close()
                            }
                        }
                    }
                )
                /*
                NavigationDrawerItem(
                    icon={ Icon(Icons.Filled.AccountBox,contentDescription="") },
                    label={Text("floating buttons")},
                    selected=false,
                    onClick = {
                        option="floating-buttons"
                        scope.launch {
                            drawerState.apply{
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon={ Icon(Icons.Filled.AccountBox,contentDescription="") },
                    label={Text("floating buttons")},
                    selected=false,
                    onClick = {
                        option="floating-buttons"
                        scope.launch {
                            drawerState.apply{
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon={ Icon(Icons.Filled.AccountBox,contentDescription="") },
                    label={Text("floating buttons")},
                    selected=false,
                    onClick = {
                        option="floating-buttons"
                        scope.launch {
                            drawerState.apply{
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon={ Icon(Icons.Filled.AccountBox,contentDescription="") },
                    label={Text("floating buttons")},
                    selected=false,
                    onClick = {
                        option="floating-buttons"
                        scope.launch {
                            drawerState.apply{
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon={ Icon(Icons.Filled.AccountBox,contentDescription="") },
                    label={Text("floating buttons")},
                    selected=false,
                    onClick = {
                        option="floating-buttons"
                        scope.launch {
                            drawerState.apply{
                                close()
                            }
                        }
                    }
                )

                 */
            }
        }
    ) {
        Column{
            when(option){
                "first"->{
                   // Butt
                }
                "second"->{
                  //  FloatingButtons()
                }
            }
        }
    }
    //@Preview(showBackground = true)
    @Composable
    fun Buttons (){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick = {}) {
                Text ("Filled")
            }
            FilledTonalButton (onClick = {}) {
                Text ("Tonal")
            }
            OutlinedButton (onClick = {}) {
                Text ("Outline")
            }
            ElevatedButton (onClick = {}) {
                Text ("Elevated")
            }
            TextButton(onClick = {}) {
                Text ("Text")
            }
        }
    }
    //@Preview(showBackground = true)
    @Composable
    fun FloatingButtons () {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            FloatingActionButton(onClick = {}){
                Icon(Icons.Filled.Add, "Add Button")
            }
            SmallFloatingActionButton(onClick = {}){
                Icon(Icons.Filled.Add, "Add Button")
            }
            LargeFloatingActionButton(onClick = {}){
                Icon(Icons.Filled.Add, "Add Button")
            }
            ExtendedFloatingActionButton(onClick = {}){
                Icon(Icons.Filled.Add, "Add Button")
                Text ("Button")

            }
        }
    }
    //@Preview(showBackground = true)
    @Composable
    fun Progress() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            LinearProgressIndicator(
                modifier= Modifier
                    .fillMaxWidth()
            )
            CircularProgressIndicator(
                modifier = Modifier
                    .width (64.dp)
            )
        }
    }
    //@Preview(showBackground = true)
    @Composable
    fun Chips() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            AssistChip(
                onClick = {},
                label = { Text("Asist Chip") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.AccountBox, contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }

            )
            var selected by remember { mutableStateOf(false) }
            FilterChip(
                selected = selected,
                onClick = {},
                label = { Text("Filter Chip") },
                leadingIcon = if (selected) {
                    {
                        Icon(
                            Icons.Filled.AccountBox, contentDescription = "Assist Chip",
                            modifier = Modifier
                                .size(AssistChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                }
            )
            InputChipExample("dismiss",{})
        }

    }


    //@Preview(showBackground = true)
    @Composable
    fun Sliders () {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            var SliderPosition by remember {mutableStateOf(50f)}
            Slider(
                value = SliderPosition,
                onValueChange = {SliderPosition = it },
                steps = 10,
                valueRange= 0f .. 100f
            )
            Text(
                textAlign= TextAlign.Center,
                modifier=Modifier.fillMaxWidth(),
                text = SliderPosition.toString()
            )
        }
    }
   // @Preview(showBackground = true)
    @Composable
    fun Switches () {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            var checked by remember { mutableStateOf(true) }
            Switch(
                checked = checked,
                onCheckedChange = {checked = it}
            )
            var checked2 by remember { mutableStateOf(true) }
            Switch(
                checked = checked2,
                onCheckedChange = {checked2 = it},
                thumbContent = if (checked2){
                    {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = "Switch Check",
                            Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    }
                }else {
                    null
                }
            )
            var checked3 by remember { mutableStateOf(true) }
            Checkbox(
                checked =checked3,
                onCheckedChange = {checked3 =it}
            )
        }
    }
   // @Preview(showBackground = true)
    @Composable
    fun Badges() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            var itemCount by remember { mutableStateOf(0) }
            BadgedBox(
                badge = {
                    if (itemCount > 0) {
                        Badge(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ) {
                            Text(itemCount.toString())
                        }
                    }
                }
            )
            {
                Icon(
                    imageVector= Icons.Filled.ShoppingCart,
                    contentDescription = "Shopping cartr icon"
                )
            }
            Button(
                onClick= {itemCount++}
            ){
                Text("Add item")
            }
        }
    }
}
@Composable
fun InputChipExample (
    text: String,
    onDismiss : () -> Unit
){
    var enable by remember{mutableStateOf(true)}
    if (!enable)return

    InputChip(
        label = { Text(text) },
        selected = enable,
        onClick = {
            onDismiss()
            enable = !enable
        },
        avatar ={
            Icon (
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon (
                Icons.Filled.Close,
                contentDescription = "Icon Close",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(){
    Column (modifier=Modifier
        .fillMaxSize()){
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.White
            ),
            title ={Text("screen title")},
            actions={
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "search button")
                }
            }
        )
        Column (modifier=Modifier
            .fillMaxSize()
            .weight(1f)){
            PostCardComponent()
        }
    BottomAppBar (
        containerColor = Color.Black,
        contentColor = Color.White
    ){
       // IconButton(
            //modifier=Modifier
       // ) { }
    }
    }
}