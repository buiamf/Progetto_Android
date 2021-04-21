package com.example.notes.Model.dao

import android.provider.ContactsContract
import androidx.room.*
import androidx.room.Dao

@Dao
interface DaoUser {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg users: EntityUser)

    @Delete
    suspend fun deleteUser(vararg users: EntityUser)

    @Query("SELECT * FROM user WHERE email = :email")
    suspend fun controllEmail(email:String): Boolean

    @Query("SELECT * FROM user WHERE email =:email AND password = :password")
    suspend fun controllPassword(email:String, password:String) : Boolean

    @Query("SELECT idUser FROM user WHERE email =:email")
    suspend fun returnID(email: String): Int

}

@Dao
interface DaoNote {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg users: EntityNote)

    @Delete
    suspend fun deleteUser(vararg users: EntityNote)

    @Query("SELECT * FROM note WHERE idUser = :id  ")
    suspend fun getAllNoteforUser(id: Int): List<EntityNote>

}