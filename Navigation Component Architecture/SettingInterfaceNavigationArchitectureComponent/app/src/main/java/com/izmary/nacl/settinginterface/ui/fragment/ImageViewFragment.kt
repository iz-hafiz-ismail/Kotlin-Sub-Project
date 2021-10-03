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
import androidx.transition.TransitionInflater
import com.izmary.nacl.settinginterface.R
import com.izmary.nacl.settinginterface.databinding.FragmentImageViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var binding: FragmentImageViewBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ImageViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //animation stuff
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_image_view, container, false)

        //pass argument to variable from settingFragment
        var dataName:String? = requireArguments().getString("name")
        var dataStatus:String? = requireArguments().getString("status")
        binding.editTextTextPersonName.setText(dataName)
        binding.editTextTextStatus.setText(dataStatus)

        //pass data to settingFragment
        binding.buttonUpdateProfile.setOnClickListener {
            val bundle = bundleOf("nameUpdate" to binding.editTextTextPersonName.text.toString(), "statusUpdate" to binding.editTextTextStatus.text.toString())
            //navigate to settingFragment
            it.findNavController().navigate(R.id.action_imageViewFragment_to_settingFragment,bundle)
        }

        //view image in fullImageFragment
        binding.imageView.setOnClickListener {
            //animation stuff
            val extras = FragmentNavigatorExtras(
                binding.imageView to "sharedElementTransition"
            )
            //navigate to full image fragment
            it.findNavController().navigate(R.id.action_imageViewFragment_to_fullImageFragment,null,null,extras)
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
         * @return A new instance of fragment ImageViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImageViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}