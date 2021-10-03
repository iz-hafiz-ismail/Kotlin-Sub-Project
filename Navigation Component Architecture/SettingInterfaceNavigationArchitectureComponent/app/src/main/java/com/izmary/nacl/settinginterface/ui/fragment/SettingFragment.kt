package com.izmary.nacl.settinginterface.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.izmary.nacl.settinginterface.R
import com.izmary.nacl.settinginterface.databinding.FragmentSettingBinding
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentSettingBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)

        //receive data from ImageViewFragment(For this tutorial only) best practice is using view model
        var dataName:String? = try { requireArguments().getString("nameUpdate") } catch (e: Exception) { null }
        var dataStatus:String? = try { requireArguments().getString("statusUpdate") } catch (e: Exception) { null }

        //check data before assignment to avoid crash
        if (!dataName.isNullOrEmpty()&&!dataStatus.isNullOrEmpty()){
            binding.textViewName.setText(dataName)
            binding.textViewStatus.setText(dataStatus)
        }

        //click listener to move to next layout
        binding.relativeLayout.setOnClickListener{
            //animation stuff
            val extras = FragmentNavigatorExtras(
                binding.imageView to "sharedElementTransition"
            )
            //pass data to next fragment
            val bundle = bundleOf("name" to binding.textViewName.text.toString(), "status" to binding.textViewStatus.text.toString())
            //navigate to next fragment
            it.findNavController().navigate(R.id.action_settingFragment_to_imageViewFragment, bundle, null, extras)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}