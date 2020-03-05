package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.dial_fragment.*

class ContactsFragment: Fragment(R.layout.contacts_fragment) {

    private lateinit var viewModel: ViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        viewModel = ViewModel(application = Application())
        lstSuggestions.adapter = ContactListAdapter()
        setupObserver()
    }

    private fun setupObserver() {
        val searchObserver = Observer<String> {
            /*lblNumber.text = it
            if (it.isEmpty()){
                imgVideo.visibility = View.INVISIBLE
                imgBackspace.visibility = View.INVISIBLE
            } else {
                imgVideo.visibility = View.VISIBLE
                imgBackspace.visibility = View.VISIBLE
            }*/
        }
        //viewModel.currentNumber.observe(viewLifecycleOwner, numberObserver)
    }

    companion object {
        fun newInstance(): ContactsFragment =
            ContactsFragment()
    }
}
