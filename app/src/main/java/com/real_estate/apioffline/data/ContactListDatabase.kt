package com.real_estate.apioffline.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContactList::class], version = 1)
abstract class ContactListDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}
