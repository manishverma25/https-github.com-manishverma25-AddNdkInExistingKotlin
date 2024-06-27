package com.example.ndkinexistingkotlinsample3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ndkinexistingkotlinsample3.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initview()
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }


    fun initview(){

        binding.buttonFirst.text =   (  activity as MainActivity).jniData


        Log.d("mvv"," frag  activity as MainActivity).jniData   ${ (  activity as MainActivity).jniData}")
        Log.d("mvv","    binding.buttonFirst.text  ${      binding.buttonFirst.text}")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}