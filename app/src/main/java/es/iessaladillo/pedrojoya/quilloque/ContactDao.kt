package es.iessaladillo.pedrojoya.quilloque

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    @Query("SELECT * FROM contacts")
    fun getAll(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts WHERE number LIKE :number")
    fun findByNumber(number: String): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts WHERE name LIKE :name")
    fun findByName(name: String): LiveData<List<Contact>>

    @Query("SELECT * FROM calls")
    fun getAllCalls(): LiveData<List<Call>>

    @Insert
    fun insertAll(vararg contacts: Contact)

    @Delete
    fun delete(contact: Contact)

    @Insert
    fun insert(call: Call)

}