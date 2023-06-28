package app.junsu.wwwe

import android.app.Application
import app.junsu.wwwe.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WwweApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WwweApplication)
            modules(
                appModule,
            )
        }
    }
}
