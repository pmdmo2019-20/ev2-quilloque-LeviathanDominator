package es.iessaladillo.pedrojoya.quilloque

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class ViewModel(application: Application) : AndroidViewModel(application){

    private val contactRepository: ContactRepository = ContactRepository(application)

    internal val allContacts: LiveData<List<Contact>> = contactRepository.getAllContacts()
    internal val allCalls: LiveData<List<Call>> = contactRepository.getAllCalls()

    private val _currentNumber: MutableLiveData<String> =
        MutableLiveData("")
    val currentNumber: LiveData<String>
        get() = _currentNumber

    private val _searchQuery: MutableLiveData<String> =
        MutableLiveData("")
    val searchQuery: LiveData<String>
        get() = _searchQuery

    val suggestions = contactRepository.findByNumber(currentNumber.value!!.toString())

    val searchedContacts = contactRepository.findByName(searchQuery.value!!.toString())

    fun insert(contact: Contact) {
        contactRepository.insert(contact)
    }

    fun insertCharacter(character: Char) {
        _currentNumber.value = StringBuilder().append(currentNumber.value).append(character).toString()
    }

    fun deleteCharacter() {
        _currentNumber.value = currentNumber.value!!.dropLast(1)
    }

    fun insertCall(call: Call) {
        contactRepository.insertCall(call)
    }
}