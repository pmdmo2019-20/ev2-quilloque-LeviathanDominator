package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.contact_creation_fragment.*
import kotlinx.android.synthetic.main.main_activity.*

class ContactCreationFragment: Fragment(R.layout.contact_creation_fragment){

    private lateinit var viewModel: ViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupToolbar()
        viewModel = ViewModel(application = Application())
        Log.d("List size", viewModel.allContacts.value?.size.toString())
        fabSave.setOnClickListener{
            when {
                txtName.text.isEmpty() -> {
                    Toast.makeText(context, getString(R.string.emptyName), Toast.LENGTH_LONG).show()
                }
                txtPhoneNumber.text.isEmpty() -> {
                    Toast.makeText(context, getString(R.string.emptyNumber), Toast.LENGTH_LONG).show()
                }
                else -> {
                    viewModel.insert(Contact(txtName.text.toString(), txtPhoneNumber.text.toString()))
                    view!!.findNavController().navigate(R.id.dialFragment)
                }
            }
        }
        //txtName.text = viewModel.searchQuery.value.toString()
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).run {
            title = getString(R.string.contact_creation_title)
            setSupportActionBar(toolbar)
        }

    }
}