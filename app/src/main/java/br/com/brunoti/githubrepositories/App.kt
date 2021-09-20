package br.com.brunoti.githubrepositories

import android.app.Application
import br.com.brunoti.githubrepositories.data.di.DataModule
import br.com.brunoti.githubrepositories.data.di.DomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()

    }
}