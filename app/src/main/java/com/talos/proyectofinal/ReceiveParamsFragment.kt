package com.talos.proyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.talos.proyectofinal.databinding.FragmentReceiveParamsBinding
import com.talos.proyectofinal.databinding.FragmentSendParmsBinding


class ReceiveParamsFragment : Fragment() {

    private lateinit var binding : FragmentReceiveParamsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiveParamsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.btRegister.setOnClickListener{
            val intent = Intent(requireContext(), LogedActivity::class.java)
            startActivity(intent)
        }

        val btCancel: Button=  view.findViewById(R.id.btCancel)
        btCancel.setOnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            val sendParmsFragment = SendParmsFragment()

            fragmentTransaction.replace(R.id.paramsContainer, sendParmsFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = ReceiveParamsFragment()
    }
}