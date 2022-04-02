package com.example.coppeltest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.coppeltest.ui.main.MainFragment
import com.example.coppeltest.ui.main.SuperHeroViewModel
import com.example.coppeltest.ui.main.WebViewActivity

val FRAGMENT_TAG = "fragment_service"
class MainActivity : AppCompatActivity() {

    val viewModel: SuperHeroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = MainFragment.newInstance()
        onRequestChangeFragment(fragment, true, FRAGMENT_TAG)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_info)
            if (viewModel.checkForInternet(this)) {
                val intent = Intent(this, WebViewActivity::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, getString(R.string.lost_network), Toast.LENGTH_LONG).show()
        return true
    }

    fun onRequestChangeFragment(fragment: Fragment, saveInStack: Boolean, tag: String?) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(android.R.id.content, fragment, tag)
        if (saveInStack) {
            ft.addToBackStack(tag)
        }
        ft.commit()
    }

    fun removeFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

}