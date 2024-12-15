package com.example.monitoringapplication.dependenciesinjection

import android.content.Context
import com.example.monitoringapplication.data.database.KrsDatabase
import com.example.monitoringapplication.repository.RepositoryMhs
import com.example.monitoringapplication.repository.LocalRepositoryMhs

interface InterfaceContaineerApp{
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContaineerApp{
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}
