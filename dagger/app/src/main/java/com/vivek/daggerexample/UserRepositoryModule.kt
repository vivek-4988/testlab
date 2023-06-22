package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun getSqlRepo(sQlRepository: SQlRepository):UserRepository
}