package com.example.notes.Model.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.w3c.dom.Text
import java.util.*


@Entity(tableName = "user")
data class EntityUser(
    @PrimaryKey(autoGenerate = true) val idUser: Int,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "cognome") val cognome: String
)


@Entity(
    tableName = "informazioni", foreignKeys = arrayOf(
        ForeignKey(
            entity = EntityUser::class,
            parentColumns = arrayOf("idUser"),
            childColumns = arrayOf("idUser"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class EntityInformazioni(
    @PrimaryKey(autoGenerate = false) val idUser: Int,
    @ColumnInfo(name = "genere") val genere: Char,
    @ColumnInfo(name = "luogo") val luogo: String,
    @ColumnInfo(name = "data") val data: Date,
    @ColumnInfo(name = "indirizzo") val indirizzo: String
)

@Entity(
    tableName = "note", foreignKeys = arrayOf(
        ForeignKey(
            entity = EntityUser::class,
            parentColumns = arrayOf("idUser"),
            childColumns = arrayOf("idUser"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class EntityNote(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "idUser") val idUser: Int,
    @ColumnInfo(name = "titolo") val titolo: String,
    @ColumnInfo(name = "testo") val testo: Text

)


@Entity(
    tableName = "modificaNote", foreignKeys = arrayOf(
        ForeignKey(
            entity = EntityNote::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class EntityModificaNote(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "dataCreazione") val dataCreazione: Date,
    @ColumnInfo(name = "dataModifica") val dataModifica: Date

)

@Entity(
    tableName = "Accesso", foreignKeys = arrayOf(
        ForeignKey(
            entity = EntityUser::class,
            parentColumns = arrayOf("idUser"),
            childColumns = arrayOf("idUser"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class EntityAccesso(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "idUser") val idUser: Int,
    @ColumnInfo(name = "dispositivo") val dispositivo: String,
    @ColumnInfo(name = "iP") val iP: String

    )

@Entity(
    tableName = "DataAccesso", foreignKeys = arrayOf(
        ForeignKey(
            entity = EntityUser::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class EntityDataAccesso(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "data") val data: Date,
    @ColumnInfo(name = "entrata") val entrata: String
    )