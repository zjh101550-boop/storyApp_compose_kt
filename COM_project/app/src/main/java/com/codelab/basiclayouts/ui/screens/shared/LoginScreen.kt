package com.codelab.basiclayouts.ui.screens.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.codelab.basiclayouts.R
import com.codelab.basiclayouts.ui.components.BottomComponent
import com.codelab.basiclayouts.ui.components.BottomLoginTextComponent
import com.codelab.basiclayouts.ui.components.ForgotPasswordTextComponent
import com.codelab.basiclayouts.ui.components.HeadingTextComponent
import com.codelab.basiclayouts.ui.components.ImageComponent
import com.codelab.basiclayouts.ui.components.MainPageButton
import com.codelab.basiclayouts.ui.components.MyTextField
import com.codelab.basiclayouts.ui.components.PasswordInputComponent
import com.codelab.basiclayouts.ui.viewmodel.reader.ReaderFavouriteScreenViewModel

@Composable
fun LoginScreen(navController: NavHostController) {
    val loginViewModel  = viewModel<ReaderFavouriteScreenViewModel>()
    val value by loginViewModel.uiState.collectAsState()
    var selectedIdentity by remember { mutableStateOf(Identity.READER) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        color = Color.White
    ) {
        Column {
            ImageComponent(image = R.drawable.share_sweet_franky)
            Spacer(modifier = Modifier.height(10.dp))
            HeadingTextComponent(heading = "Login")
            Spacer(modifier = Modifier.height(20.dp))
            Column {
                MyTextField(labelVal = "email ID", R.drawable.share_at_symbol)
                Spacer(modifier = Modifier.height(15.dp))
                PasswordInputComponent(labelVal = "Password")
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ForgotPasswordTextComponent(navController)
                }
                IdentityOptions(selectedIdentity = selectedIdentity, onIdentitySelected = { selectedIdentity = it })
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Column {
                        MainPageButton(labelVal = "Continue", identity = selectedIdentity, navController = navController){
                            loginViewModel.tFavoriteAuthorList(3)
                        }
                        BottomComponent()
                        Spacer(modifier = Modifier.height(5.dp))
                        BottomLoginTextComponent(
                            initialText = "        Haven't we seen you around here before? ",
                            action = "Join us!",
                            navController
                        )
                    }
                }
            }
        }
    }
}
enum class Identity {
    READER,
    AUTHOR
}
@Composable
fun IdentityOptions(selectedIdentity: Identity, onIdentitySelected: (Identity) -> Unit) {
    Column {
        RadioOption(
            text = "Reader",
            selected = selectedIdentity == Identity.READER,
            onSelect = { onIdentitySelected(Identity.READER) }
        )
        RadioOption(
            text = "Author",
            selected = selectedIdentity == Identity.AUTHOR,
            onSelect = { onIdentitySelected(Identity.AUTHOR) }
        )
    }
}

@Composable
fun RadioOption(text: String, selected: Boolean, onSelect: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(onClick = onSelect)
    ) {
        RadioButton(selected = selected, onClick = onSelect)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
