package com.intelliteq.fea.ammocalculator.component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.intelliteq.fea.ammocalculator.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComponentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComponentFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var navController : NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        return inflater.inflate(R.layout.fragment_component, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
//        view.findViewById<Button>(R.id.button).setOnClickListener(this)
//        view.findViewById<Button>(R.id.button2).setOnClickListener(this)
//        view.findViewById<Button>(R.id.verify).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
//            R.id.add_another_ammo -> {
//                navController!!.navigate(R.id.action_fragInputAmmo_to_fragInputAmmoComp)
//            }
//            R.id.add_component -> {
//                navController!!.navigate(R.id.action_fragInputAmmo_to_fragInputComponent)
//            }
//            R.id.verify -> {
//                navController!!.navigate(R.id.action_fragInputAmmo_to_fragConfirmInfo)
//            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComponentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComponentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}