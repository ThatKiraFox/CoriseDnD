package net.kira.coriseDnD

import android.app.Application
import net.kira.coriseDnD.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CoriseDnDApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoriseDnDApp)
            modules(appModule)
        }
    }
}