package com.example.myadbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myadbook.databinding.FragmentContactBinding

const val STRING_LENGTH = 7;

class ContactFragment : Fragment(R.layout.fragment_contact) {
    private lateinit var binding: FragmentContactBinding
    private var listAdapter = AdapterContact()
    private val charPool: List<Char> = ('a'..'z') + ('a'..'z')
    private val intPool: List<Char> = ('0'..'9') + ('0'..'9')
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = getContact()


        binding.list.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val dividerItemDecoration = DividerItemDecoration(
                context,
                (layoutManager as LinearLayoutManager).orientation
            )
            addItemDecoration(dividerItemDecoration)
        }
        listAdapter.setContact(list)
        listAdapter.setOnClickListener {
            So.contact = it
            findNavController().navigate(R.id.action_contactFragment_to_infoFragment)
        }
    }

    object So {
        var contact: Contact? = null
    }

    fun randomString(): String {
        return ((1..STRING_LENGTH)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString(""))
    }

    fun randomNum(): String {
        return ((1..11)
            .map { i -> kotlin.random.Random.nextInt(0, intPool.size) }
            .map(intPool::get)
            .joinToString(""))
    }

    private fun getContact() = List<Contact>(100) {
        Contact(randomString(), randomString(), randomNum())
    }
}


