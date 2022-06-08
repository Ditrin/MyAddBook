package com.example.myadbook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.myadbook.databinding.ContactBinding

class AdapterContact : RecyclerView.Adapter<MyViewHolder>() {
    private var contacts: List<Contact> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ContactBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(contacts[position])
        holder.itemView.setOnClickListener { onItemClickListener?.let { it(contacts[position]) } }
    }
    override fun getItemCount(): Int = contacts.size

    fun setContact(list: List<Contact>){
        contacts = list
    }
    private var onItemClickListener: ((Contact) -> Unit)? = null

    fun setOnClickListener(listener: (Contact) -> Unit) {
        onItemClickListener = listener
    }
}
private val intPool: List<Char> = ('1'..'9') + ('1'..'9') + ('1'..'9')

class MyViewHolder(private val binding: ContactBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(contact: Contact){
        with(binding){
            name.text = contact.name
            telephone.text = contact.phone
            secName.text = contact.secName
            Glide
                .with(itemView)
                .load("https://picsum.photos/seed/" + "${randomNum()}" + "/200/300")
                .transform(CircleCrop())
                .into(avatar)
        }
    }
    fun randomNum(): String {
        return ((1..3)
            .map { i -> kotlin.random.Random.nextInt(0, intPool.size) }
            .map(intPool::get)
            .joinToString(""))
    }
}