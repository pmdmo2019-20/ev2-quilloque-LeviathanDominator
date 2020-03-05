package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.contact_creation_fragment.*
import kotlinx.android.synthetic.main.dial_fragment.*
import kotlinx.android.synthetic.main.dial_fragment_item.*
import kotlinx.android.synthetic.main.main_activity.*

class DialFragment: Fragment(R.layout.dial_fragment) {

    private lateinit var viewModel: ViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupToolbar()
        viewModel = ViewModel(application = Application())
        lstSuggestions.adapter = ContactListAdapter()
        lblCreateContact.setOnClickListener{
            view!!.findNavController().navigate(R.id.contactCreationFragment)
        }
        lblOne.setOnClickListener{
            viewModel.insertCharacter('1')
        }
        lblTwo.setOnClickListener{
            viewModel.insertCharacter('2')
        }
        lblThree.setOnClickListener{
            viewModel.insertCharacter('3')
        }
        lblFour.setOnClickListener{
            viewModel.insertCharacter('4')
        }
        lblFive.setOnClickListener{
            viewModel.insertCharacter('5')
        }
        lblSix.setOnClickListener{
            viewModel.insertCharacter('6')
        }
        lblSeven.setOnClickListener{
            viewModel.insertCharacter('7')
        }
        lblEight.setOnClickListener{
            viewModel.insertCharacter('8')
        }
        lblNine.setOnClickListener{
            viewModel.insertCharacter('9')
        }
        lblAstherisc.setOnClickListener{
            viewModel.insertCharacter('*')
        }
        lblZero.setOnClickListener{
            viewModel.insertCharacter('0')
        }
        lblPound.setOnClickListener{
            viewModel.insertCharacter('#')
        }
        imgBackspace.setOnClickListener{
            viewModel.deleteCharacter()
        }
        fabCall.setOnClickListener{
            viewModel.insertCall(Call(txtPhoneNumber.text.toString(), null))
        }
        setupObserver()
    }

    private fun setupObserver() {
        val numberObserver = Observer<String> {
            lblNumber.text = it
            if (it.isEmpty()){
                imgVideo.visibility = View.INVISIBLE
                imgBackspace.visibility = View.INVISIBLE
            } else {
                imgVideo.visibility = View.VISIBLE
                imgBackspace.visibility = View.VISIBLE
            }
        }
        viewModel.currentNumber.observe(viewLifecycleOwner, numberObserver)
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).run {
            title = getString(R.string.dial_title)
            setSupportActionBar(toolbar)
        }

    }

    companion object {
        fun newInstance(): DialFragment =
            DialFragment()
    }
}
