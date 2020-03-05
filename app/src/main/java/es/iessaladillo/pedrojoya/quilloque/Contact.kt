package es.iessaladillo.pedrojoya.quilloque

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @ColumnInfo(name = "number") var number: String,
    @ColumnInfo(name = "name") var name: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
