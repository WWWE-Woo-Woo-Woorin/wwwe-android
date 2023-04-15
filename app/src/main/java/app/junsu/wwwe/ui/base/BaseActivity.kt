package app.junsu.wwwe.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initObserver()
    }

    protected fun initView() {
        /* explicit blank */
    }

    protected fun initObserver() {
        /* explicit blank */
    }
}
