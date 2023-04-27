package app.junsu.wwwe

import android.app.Application
import app.junsu.wwwe.di.appModule
import org.koin.core.context.startKoin

class WwweApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                appModule,
            )
        }
    }
}
