package com.intelliteq.fea.ammocalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragConfirmInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragConfirmInfo : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var navController : NavController? = null
    var inputWeaponRecipient : String? = null
    var inputDescRecipient : String? = null
    var inputDodicRecipient : String? = null
    var inputTrainingRecipient : String? = null
    var inputSecurityRecipient : String? = null
    var inputSustainRecipient : String? = null
    var inputLightRecipient : String? = null
    var inputMediumRecipient : String? = null
    var inputHeavyRecipient : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inputWeaponRecipient = requireArguments().getString("inputWeaponRecipient")
        inputDescRecipient = requireArguments().getString("inputDescRecipient")
        inputDodicRecipient = requireArguments().getString("inputDodicRecipient")
        inputTrainingRecipient = requireArguments().getString("inputTrainingRecipient")
        inputSecurityRecipient = requireArguments().getString("inputSecurityRecipient")
        inputSustainRecipient = requireArguments().getString("inputSustainRecipient")
        inputLightRecipient = requireArguments().getString("inputLightRecipient")
        inputMediumRecipient = requireArguments().getString("inputMediumRecipient")
        inputHeavyRecipient = requireArguments().getString("inputHeavyRecipient")

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
        return inflater.inflate(R.layout.frag_confirm_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weaponType = "$inputWeaponRecipient"
        val weaponDesc = "$inputDescRecipient"
        val weaponDodic = "$inputDodicRecipient"
        val training = "$inputTrainingRecipient"
        val security = "$inputSecurityRecipient"
        val sustain = "$inputSustainRecipient"
        val lightWeapon = "$inputLightRecipient"
        val mediumWeapon = "$inputMediumRecipient"
        val heavyWeapon = "$inputHeavyRecipient"
        view.findViewById<TextView>(R.id.fragment5).text = weaponType
        //Need to add labels and concatenate
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragConfirmInfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragConfirmInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}