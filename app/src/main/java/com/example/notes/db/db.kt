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
        private var INSTANCE: DatabaseAndroid? = null

        fun getDatabase(context: Context): DatabaseAndroid {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseAndroid::class.java,
                    "android_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}
