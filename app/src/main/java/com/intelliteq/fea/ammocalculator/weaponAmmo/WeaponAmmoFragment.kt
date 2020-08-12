package com.intelliteq.fea.ammocalculator.weaponAmmo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.intelliteq.fea.ammocalculator.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WeaponAmmoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeaponAmmoFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var navController : NavController? = null
    var inputWeaponRecipient : String? = null
    var inputDescRecipient : String? = null
//    var inputDodicRecipient : String? = null
//    var inputTrainingRecipient : String? = null
//    var inputSecurityRecipient : String? = null
//    var inputSustainRecipient : String? = null
//    var inputLightRecipient : String? = null
//    var inputMediumRecipient : String? = null
//    var inputHeavyRecipient : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inputWeaponRecipient = arguments!!.getString("inputWeaponRecipient")
        inputDescRecipient = arguments!!.getString("inputDescRecipient")
//        inputDodicRecipient = arguments!!.getString("inputDescRecipient")
//        inputTrainingRecipient = arguments!!.getString("inputDescRecipient")
//        inputSecurityRecipient = arguments!!.getString("inputDescRecipient")
//        inputSustainRecipient = arguments!!.getString("inputDescRecipient")
//        inputLightRecipient = arguments!!.getString("inputDescRecipient")
//        inputMediumRecipient = arguments!!.getString("inputDescRecipient")
//        inputHeavyRecipient = arguments!!.getString("inputDescRecipient")


        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weapon_ammo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button).setOnClickListener(this)
        view.findViewById<Button>(R.id.button2).setOnClickListener(this)
        view.findViewById<Button>(R.id.verify).setOnClickListener(this)
        val weaponType = "$inputWeaponRecipient"
        val weaponDesc = "$inputDescRecipient"
        view.findViewById<TextView>(R.id.textInputLayout4).text = weaponType
        view.findViewById<TextView>(R.id.textInputLayout5).text = weaponDesc
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.add_another_ammo -> {
                navController!!.navigate(R.id.action_fragInputAmmo_to_fragInputAmmoComp)
            }
            R.id.add_component -> {
                navController!!.navigate(R.id.action_fragInputAmmo_to_fragInputComponent)
            }
            R.id.verify -> {
                val bundle = bundleOf("inputWeaponRecipient" to inputWeaponRecipient,
                    "inputWeaponDesc" to inputDescRecipient,
                    "inputDodicRecipient" to R.id.textInputLayout6.toString(),
                    "inputTrainingRecipient" to R.id.textInputLayout7.toString(),
                    "inputSecurityRecipient" to R.id.textInputLayout8.toString(),
                    "inputSustainRecipient" to R.id.textInputLayout10.toString(),
                    "inputLightRecipient" to R.id.textInputLayout12.toString(),
                    "inputMediumRecipient" to R.id.textInputLayout13.toString(),
                    "inputHeavyRecipient" to R.id.textInputLayout11.toString())

                navController!!.navigate(R.id.action_fragInputAmmo_to_fragConfirmInfo, bundle)
            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WeaponAmmoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WeaponAmmoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}