package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_activity.*

class RecentFragment: Fragment(R.layout.recent_fragment) {

    private lateinit var viewModel: ViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        viewModel = ViewModel(application = Application())
    }

    companion object {
        fun newInstance(): RecentFragment =
            RecentFragment()
    }
}
