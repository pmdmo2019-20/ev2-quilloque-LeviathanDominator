package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class ContactListAdapter : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private val contacts = ViewModel(application = Application()).allContacts.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.contacts_fragment_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (contacts != null) {
            holder.bind(contacts[position])
        }
        holder.itemView.setOnClickListener {

        }
    }


    override fun getItemCount(): Int {
        return contacts!!.size
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(contact: Contact) {
            contact.run {

            }

        }

    }

}