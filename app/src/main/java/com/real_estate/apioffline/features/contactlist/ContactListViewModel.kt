package com.real_estate.apioffline.features.contactlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.real_estate.apioffline.data.ContactListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactListViewModel @Inject constructor(
    repository: ContactListRepository
) : ViewModel() {
    val contacts = repository.getContacts().asLiveData()
}