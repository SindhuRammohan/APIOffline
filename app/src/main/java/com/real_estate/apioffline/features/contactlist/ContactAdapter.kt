package com.real_estate.apioffline.features.contactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.real_estate.apioffline.data.ContactList
import com.real_estate.apioffline.databinding.ContactlistItemBinding


class ContactAdapter : ListAdapter<ContactList, ContactAdapter.ContactViewHolder>(ContactListComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class ContactViewHolder(private val binding: ContactlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contactlist: ContactList) {
            binding.apply {
                contactName.text = contactlist.id
                contactTransmission.text = contactlist.zip
                contactColor.text = contactlist.city
                contactDriveType.text = "b"
                contactFuelType.text = "c"
                contactType.text = "d"

            }
        }
    }

    class ContactListComparator : DiffUtil.ItemCallback<ContactList>() {
        override fun areItemsTheSame(oldItem: ContactList, newItem: ContactList) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ContactList, newItem: ContactList) =
            oldItem == newItem
    }

}
