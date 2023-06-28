package app.junsu.wwwe

import android.app.Application
import app.junsu.wwwe.di.appModule
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WwweApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initFlipper()
    }

    private fun initFlipper() {
        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            AndroidFlipperClient.getInstance(this).apply {
                addPlugin(
                    InspectorFlipperPlugin(this@WwweApplication, DescriptorMapping.withDefaults()),
                )
            }.start()
        }
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@WwweApplication)
            modules(
                appModule,
            )
        }
    }
}
