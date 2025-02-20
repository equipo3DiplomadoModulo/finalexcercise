package com.talos.proyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity.RESULT_OK
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

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)


        binding.btLogin.setOnClickListener{

            val user = binding.etUser.text
            val password = binding.etPassword.text

            val loginEmpty : String = getString(R.string.login_empty)

            if (user.toString() == "" || password.toString() == ""){
                Toast.makeText(requireContext(), loginEmpty, Toast.LENGTH_LONG  ).show()
            }else{
                val intent = Intent(requireContext(), LogedActivity::class.java).apply {
                    putExtra("EXTRA_USER", user.toString())
                    //Toast.makeText(requireContext(), "name: $name", Toast.LENGTH_LONG).show()
                }
                startActivity(intent)
            }
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