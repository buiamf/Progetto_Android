package com.example.notes.Model.dao

import androidx.room.*
import androidx.room.Dao
import java.util.*

@Dao
interface DaoUser {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg users: EntityUser)

    @Delete
    suspend fun deleteUser(vararg users: EntityUser)

    @Query("SELECT * FROM user WHERE email = :email")
    suspend fun checkEmail(email: String): Boolean

    @Query("SELECT * FROM user WHERE email =:email AND password = :password")
    suspend fun checkPassword(email: String, password: String): Boolean

    @Query("SELECT idUser FROM user WHERE email =:email")
    suspend fun returnID(email: String): Int


}

@Dao
interface DaoInformazioni {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInformation(vararg information: EntityInformazioni)

    @Query("SELECT * FROM information WHERE idUser = :id")
    suspend fun informationUserInformation(id: Int): List<EntityInformazioni>

    @Update
    suspend fun updateUser(vararg information: EntityInformazioni)
}


@Dao
interface DaoNote {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(vararg notes: EntityNote)

    @Delete
    suspend fun deleteNote(id: EntityNote)

    @Query("DELETE FROM note WHERE idUser = :idUser") // cancella tutte le note che si riferiscono a quell utente
    suspend fun deleteAllNotesforUser(idUser: Int)

    @Update
    suspend fun updateNotes(vararg notes: EntityNote)

    @Query("SELECT * FROM note WHERE idUser = :id  ")
    suspend fun getAllNoteforUser(id: Int): List<EntityNote>

}

@Dao
interface DaoModificaNote {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModificaNote(vararg notes: EntityModificaNote)

    @Query("SELECT dataModifica  FROM modificaNote WHERE id = :id  ")
    suspend fun printDate(id: Int): Date

}

@Dao
interface DaoAccesso {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccesso(vararg access: EntityAccesso)

}

@Dao
interface DaoDataAccesso {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataAccesso(vararg access: EntityDataAccesso)
}