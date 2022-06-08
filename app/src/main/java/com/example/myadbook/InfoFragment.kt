package com.example.myadbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myadbook.databinding.InfoContactBinding

class InfoFragment : Fragment(R.layout.info_contact) {
    private lateinit var binding: InfoContactBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InfoContactBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name2.text = ContactFragment.So.contact?.name
        binding.surname.text = ContactFragment.So.contact?.secName
        binding.infoContactPhoneNumber.text = ContactFragment.So.contact?.phone
    }
}