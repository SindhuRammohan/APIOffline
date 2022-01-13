package com.real_estate.apioffline.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Data Class to store the data
@Entity(tableName = "contacts")
data class ContactList(
    @PrimaryKey val id: String,
    val zip: String,
    val city: String
)