import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.Model.dao.*


@Database(
    entities = [EntityUser::class, EntityInformazioni::class,
        EntityNote::class, EntityModificaNote::class,
        EntityAccesso::class, EntityDataAccesso::class],
    version = 1,
    exportSchema = false
)
abstract class DatabaseAndroid : RoomDatabase() {

    abstract fun userDao(): DaoUser
    abstract fun informazioniDao(): DaoInformazioni
    abstract fun noteDao(): DaoNote
    abstract fun ModificaNoteDao(): DaoModificaNote
    abstract fun accessoDao(): DaoAccesso
    abstract fun accessoDataDao(): DaoDataAccesso

    companion object {
        @Volatile
        private var instance: DatabaseAndroid? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            DatabaseAndroid::class.java, "App_Android.db"
        )
            .build()
    }


}
