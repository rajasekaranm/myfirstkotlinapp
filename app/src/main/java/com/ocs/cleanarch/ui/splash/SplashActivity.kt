package com.ocs.cleanarch.ui.splash

import android.content.Intent
import android.os.Bundle
import com.ocs.cleanarch.R
import com.ocs.cleanarch.ui.home.HomeActivity
import com.ocs.cleanarch.ui.base.BaseActivity
import com.ocs.cleanarch.ui.splash.presenter.PSplash
import com.ocs.cleanarch.ui.splash.usecase.ICSplash

class SplashActivity : BaseActivity(), ICSplash.IVSplash {
    override fun onNavigateToHome() {
        val intent: Intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    lateinit var ipSplash: ICSplash.IPSplash<ICSplash.IVSplash>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ipSplash = PSplash(getBaseActivity());
        ipSplash.onAttach(this)
        setContentView(R.layout.activity_splash)
        ipSplash.onNavigateToNextViewWithDelay()
    }
}
