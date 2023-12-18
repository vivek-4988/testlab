package com.vivek.daggerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.vivek.daggerexample.interfaces.MainTwo
import com.vivek.daggerexample.interfaces.MaineOne
import com.vivek.daggerexample.qualifiers.Test
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var com: Computer

    @Inject
    lateinit var maineOne: MaineOne

    @Inject
    lateinit var mainTwo: MainTwo

    @Inject
    lateinit var test: Test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivty_main)

        com.getComputer()

        maineOne.mainOne()

        mainTwo.mainTwo()

        test.getNames()

    }
}
