package com.talos.proyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.talos.proyectofinal.databinding.FragmentSendParmsBinding


class SendParmsFragment : Fragment() {

    private lateinit var binding : FragmentSendParmsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentSendParmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btLogin.setOnClickListener{
            val intent = Intent(requireContext(), LogedActivity::class.java)
            startActivity(intent)
        }

        binding.tvRegister.setOnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            val receiveParamsFragment = ReceiveParamsFragment()
            fragmentTransaction.replace(R.id.paramsContainer, receiveParamsFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = SendParmsFragment()

    }
}