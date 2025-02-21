package com.talos.proyectofinal
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.talos.proyectofinal.databinding.FragmentReceiveParamsBinding

class ReceiveParamsFragment : Fragment() {
    private lateinit var binding : FragmentReceiveParamsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiveParamsBinding.inflate(inflater,

            container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.tvMessages.text=""

        setHasOptionsMenu(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        (activity as AppCompatActivity).supportActionBar?.hide()

        binding.btRegister.setOnClickListener{
//val intent = Intent(requireContext(), LogedActivity::class.java)
            val etUser= binding.etUser.text
            val etName = binding.etName.text
            val etSecondName = binding.etSecondName.text

            val etEmail = binding.etEmail.text
            val etPass= binding.etPass.text
            val etPassConfirm=binding.etPassConfirm.text
            val selectRgGroup=getRgLabel(binding.rgSex.checkedRadioButtonId,true)

            val tvMessages=binding.tvMessages

            binding.rgSex.setOnCheckedChangeListener { group,checkedId ->

                val name=getRgLabel(checkedId,false)
            }

            val logedActivity = Intent(requireContext(),
                LogedActivity::class.java).apply {

                putExtra("EXTRA_USERNAME","$etUser")
                putExtra("EXTRA_NAME", "$etName")
                putExtra("EXTRA_SECOND_NAME", "$etSecondName")

                putExtra("EXTRA_EMAIL", "$etEmail")
                putExtra("EXTRA_PASSWORD","$etPass")
                putExtra("EXTRA_GENDER", "$selectRgGroup")
            }

//AQUÍ VAN LAS VALIDACIONES Y EL ENVÍO DE LOS DATOS
            if (etUser.toString().isEmpty()){

                tvMessages.text = "The Field is required"
                tvMessages.setTextColor(Color.parseColor("#FF0000"));
                binding.etUser.setHintTextColor(Color.parseColor("#FF0000"))

                binding.etUser.requestFocus()
            }else if (etName.toString().isEmpty()){
                tvMessages.text = "The Field is required"
                tvMessages.setTextColor(Color.parseColor("#FF0000"));
                binding.etName.setHintTextColor(Color.parseColor("#FF0000"))

                binding.etName.requestFocus()
            }else if (etSecondName.toString().isEmpty()){
                tvMessages.text = "The Field is required"
                tvMessages.setTextColor(Color.parseColor("#FF0000"));
                binding.etSecondName.setHintTextColor(Color.parseColor("#FF0000"))

                binding.etSecondName.requestFocus()
            } else if (etEmail.toString().isEmpty()){

                tvMessages.text = "The Field is required"
                tvMessages.setTextColor(Color.parseColor("#FF0000"));

                binding.etEmail.setHintTextColor(Color.parseColor("#FF0000"))

                binding.etEmail.requestFocus()
            }else if (etPass.toString().isEmpty()){
                tvMessages.text = "The Field is required"
                tvMessages.setTextColor(Color.parseColor("#FF0000"));
                binding.etPass.setHintTextColor(Color.parseColor("#FF0000"))

                binding.etPass.requestFocus()
            }else if (etPassConfirm.toString().isEmpty()){
                tvMessages.text = "The Field is required"
                tvMessages.setTextColor(Color.parseColor("#FF0000"));
                binding.etPassConfirm.setHintTextColor(Color.parseColor("#FF0000"))

                binding.etPassConfirm.requestFocus()
            }
            else {
                startActivity(logedActivity)

            }
            val fragmentTransaction = parentFragmentManager.beginTransaction()
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()

        }
        val btCancel: Button= view.findViewById(R.id.btCancel)
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
    private fun getRgLabel(checkedId: Int, isFromButton :
    Boolean): String {
        return when(checkedId){
            binding.rbWomen.id->{
                if (isFromButton) "Woman" else "Woman"
            }
            binding.rbMen.id->{
                if (isFromButton) "Men" else "Men"
            }
            else ->"Género no seleccionado"
        }
    }



}