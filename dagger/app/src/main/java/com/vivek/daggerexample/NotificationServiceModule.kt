package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named

@Module
class NotificationServiceModule {

    @Named("msg")
    @Provides
    fun getMsg():NotificationService{
        return MessageService();
    }

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService):NotificationService{
        return emailService;
    }
}