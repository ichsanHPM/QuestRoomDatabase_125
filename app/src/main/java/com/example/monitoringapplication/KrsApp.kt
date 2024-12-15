package com.example.monitoringapplication

import android.app.Application
import com.example.monitoringapplication.dependenciesinjection.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        //membuat instance ContainerApp
        containerApp = ContainerApp(this)
        //instance adalah object yang dibuat dari class
    }

}