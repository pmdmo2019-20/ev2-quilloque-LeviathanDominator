package es.iessaladillo.pedrojoya.quilloque

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private var viewModel: ViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupBottomNavigationView()
        if (savedInstanceState == null) {
            navigateToDial()
        }
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
    }

    private fun navigateToDial() {
        toolbar.title = getString(R.string.dial_title)
        supportFragmentManager.commit {
            replace(R.id.navHostFragment, DialFragment.newInstance())
        }
    }

    private fun navigateToRecent() {
        toolbar.title = getString(R.string.recent_title)
        supportFragmentManager.commit {
            replace(R.id.navHostFragment, RecentFragment.newInstance())
        }
    }

    private fun navigateToContacts() {
        toolbar.title = getString(R.string.contacts_title)
        supportFragmentManager.commit {
            replace(R.id.navHostFragment, ContactsFragment.newInstance())
        }
    }

    private fun setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            navigateToOption(it)
            true
        }

    }

    private fun navigateToOption(item: MenuItem) {
        Log.d("Text",item.itemId.toString() + " " +  R.id.dialFragment.toString())
        when (item.itemId) {
            R.id.navigation_dial -> navigateToDial()
            R.id.navigation_recent -> navigateToRecent()
            R.id.navigation_contacts -> navigateToContacts()
        }

    }

}
