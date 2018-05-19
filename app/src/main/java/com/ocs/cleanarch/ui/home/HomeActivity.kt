package com.ocs.cleanarch.ui.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.ocs.cleanarch.R
import com.ocs.cleanarch.databinding.ActivityHomeBinding
import com.ocs.cleanarch.ui.base.BaseActivity
import com.ocs.cleanarch.ui.home.adapter.AdapterHome
import com.ocs.cleanarch.ui.home.presenter.PHome
import com.ocs.cleanarch.ui.home.usecase.ICHome
import com.ocs.cleanarch.utils.TempImages

class HomeActivity : BaseActivity(), ICHome.IVHome {
    lateinit var ipHome: ICHome.IPHome<ICHome.IVHome>

    lateinit var binding: ActivityHomeBinding
    lateinit var adapterHome: AdapterHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ipHome = PHome(getBaseActivity())
        ipHome.onAttach(this)
        initUI()
    }

    override fun initUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        addToolBar(binding.tbHome, 0, false)
        adapterHome = AdapterHome(getBaseActivity())
        adapterHome.setImages(TempImages.images.reversedArray())
        binding.rvHome.layoutManager = LinearLayoutManager(getBaseActivity())
        binding.rvHome.adapter = adapterHome
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.menu_home_shuffle) {
            adapterHome.shuffle()
            Toast.makeText(getBaseActivity(), "shuffled", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}
