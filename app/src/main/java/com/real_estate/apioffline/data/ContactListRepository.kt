package com.real_estate.apioffline.data

import androidx.room.withTransaction
import com.real_estate.apioffline.api.ContactListAPI
import com.real_estate.apioffline.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ContactListRepository @Inject constructor(
    private val api: ContactListAPI,
    private val db: ContactListDatabase
) {
    private val contactDao = db.contactDao()

    fun getContacts() = networkBoundResource(
        query = {
            contactDao.getAllContacts()
        },
        fetch = {
            delay(2000)
            api.getCarList()
        },
        saveFetchResult = { ContactList ->
            db.withTransaction {
                contactDao.deleteAllCars()
                contactDao.insertCars(ContactList)
            }
        }
    )
}