package com.application.iface_v5

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<EnrollmentModel>("enrollArg")?.let {
            it.imageUri?.let {
                view.imgTemplate.setImageURI(it)
            }
            it.template?.let {
                view.tvText.text = "Success\n $it"
            }

            if (it.errorCode != "0") {
                view.tvText.text = "${it.errorCode} : ${it.errorMessage}"
                view.imgTemplate.isVisible = false
            }

        }
    }
}