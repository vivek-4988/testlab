package com.vivek.daggerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userRegisterationService: UserRegisterationService
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
        //todo when  minimum objects injected in component
//        val userRegisterationService = component.getUserRegService()
//        val emailService = component.getEmailService()
//        val repo = component.getUserRepo()

        //todo when bunch of objects want to inject
        component.injectAll(this)
        userRegisterationService.register("vivektest@gmail.com","111111")

    }
}
