package com.example.mywishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
){
    Scaffold(topBar = {AppBarView(title =
            if (id != 0L) stringResource(id = R.string.update_wish)
        else
            stringResource(id = R.string.add_wish))
    {navController.navigateUp()}},
    ) {
        Column (modifier = Modifier
            .padding(it)
            .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
          Spacer(modifier = Modifier.height(10.dp))

            WishTextFeild(label = "Title",
                value =viewModel.wishTitleState ,
                onValueChange ={
                    viewModel.onWishTitleChanged(it)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            WishTextFeild(label = "Description",
                value =viewModel.wishDescriptionState ,
                onValueChange ={
                    viewModel.onWishDescriptionChanged(it)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if (viewModel.wishTitleState.isNotEmpty() &&
                    viewModel.wishDescriptionState.isNotEmpty()){
                    //TODO update wish
                }else{
                    //TODO add Wish
                }
            }) {
                Text(text = if (id != 0L)
                    stringResource(id = R.string.update_wish)
                else
                    stringResource(id = R.string.add_wish),
                    style = androidx.compose.ui.text.TextStyle(fontSize = 18.sp)
                )

            }
        }
    }
}

@Composable
fun WishTextFeild(
    label : String,
    value : String,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.Black)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black
        )
    )
}