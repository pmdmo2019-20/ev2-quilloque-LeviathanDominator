package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData

class ContactRepository(application: Application) {

    private val contactDao: ContactDao

    init {
        val appDatabase: AppDatabase? = AppDatabase.getInstance(application)
        contactDao = appDatabase!!.contactDao()
    }

    fun insert(contact: Contact) {
        contactDao.insertAll(contact)
    }

    fun getAllContacts(): LiveData<List<Contact>> {
        return contactDao.getAll()
    }

    fun findByNumber(number: String): LiveData<List<Contact>> {
        return contactDao.findByNumber(number)
    }

    fun findByName(name: String): LiveData<List<Contact>> {
        return contactDao.findByName(name)
    }

    fun insertCall(call: Call) {
        Log.d("Insert call", contactDao.insert(call).toString())
    }

    fun getAllCalls(): LiveData<List<Call>> {
        return contactDao.getAllCalls()
    }

}
