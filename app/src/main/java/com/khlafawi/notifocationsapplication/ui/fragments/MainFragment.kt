package com.khlafawi.notifocationsapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.khlafawi.notifocationsapplication.NotificationsHelper
import com.khlafawi.notifocationsapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        with(binding) {
            newNotification.setOnClickListener {
                NotificationsHelper.createSampleDataNotification(
                    requireContext(),
                    "This is a testing notification",
                    "This is a new testing notification description from the connect session",
                    "This is a new testing notification big text from the connect session",
                    false
                )
            }
        }
        return binding.root
    }

}