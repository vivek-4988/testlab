package com.vivek.daggerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vivek.daggerexample.ui.theme.DaggerExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivty_main)

        //todo manual DI
//        val userRepo = UserRepository()
//        val emailService = EmailService()
//
//        //construction injection
//        val userRegisterationService = UserRegisterationService(userRepo,emailService)

        //todo dagger DI
        val component = DaggerUserRegisterationComponent.builder().build()
        val userRegisterationService = component.getUserRegService()
        val emailService = component.getEmailService()
        val repo = component.getUserRepo()
        userRegisterationService.register("vivektest@gmail.com","111111")

    }
}
