package com.ocs.cleanarch.ui.home

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ocs.cleanarch.R
import com.ocs.cleanarch.databinding.ActivityHomeBinding
import com.ocs.cleanarch.ui.base.BaseActivity
import com.ocs.cleanarch.ui.home.adapter.AdapterHome
import com.ocs.cleanarch.ui.home.presenter.PHome
import com.ocs.cleanarch.ui.home.usecase.ICHome

class HomeActivity : BaseActivity(), ICHome.IVHome {
    lateinit var ipHome: ICHome.IPHome<ICHome.IVHome>

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ipHome = PHome(getBaseActivity())
        ipHome.onAttach(this)
        initUI()
    }

    override fun initUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        addToolBar(binding.tbHome, 0, false)
        binding.rvHome.adapter = AdapterHome(getBaseActivity())
        binding.rvHome.layoutManager = LinearLayoutManager(getBaseActivity())
    }

}
