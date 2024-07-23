package com.example.mbanking

import android.app.Application
import com.example.mbanking.data.AppDataBase

class App : Application() {
    val dataBase by lazy{AppDataBase.createDataBase(this)}
}