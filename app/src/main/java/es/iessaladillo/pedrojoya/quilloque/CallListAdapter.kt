package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class CallListAdapter : RecyclerView.Adapter<CallListAdapter.ViewHolder>() {

    private val calls = ViewModel(application = Application()).allCalls.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recent_fragment_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (calls != null) {
            holder.bind(calls[position])
        }
    }


    override fun getItemCount(): Int {
        return calls!!.size
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(call: Call) {
            call.run {

            }

        }

    }

}
