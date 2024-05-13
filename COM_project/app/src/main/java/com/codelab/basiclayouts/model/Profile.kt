package com.codelab.basiclayouts.model

import androidx.compose.runtime.mutableStateOf
import com.codelab.basiclayouts.ui.components.Sex
import com.codelab.basiclayouts.ui.screens.shared.Identity

data class Profile(
    val username: String = "",
    val realName: String = "",
    val selfDescription: String = "",
    val email: String = "",
    val telephone: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val profilePictureLink: String = ""
)

object SelectedIdentity {
    var selectedIdentity = Identity.READER
}
object SelectedSex {
    var selectedSex = Sex.MALE
}

object LoginUser {
    var email: String = ""
    var password: String = ""
}