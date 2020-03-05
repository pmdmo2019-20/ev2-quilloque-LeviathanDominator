package es.iessaladillo.pedrojoya.quilloque

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

companion object {
    private var INSTANCE: AppDatabase? = null
    fun getInstance(context: Context): AppDatabase? {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "AppDatabase"
            ).allowMainThreadQueries().build()
        }
        return INSTANCE
    }
}

    abstract fun contactDao(): ContactDao

}