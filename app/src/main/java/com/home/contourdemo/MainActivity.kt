package com.home.contourdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(EnterMobileNumberContourLayout(this))
    }
}
