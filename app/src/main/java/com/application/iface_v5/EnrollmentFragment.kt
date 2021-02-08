package com.application.iface_v5

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.innovatrics.android.dot.face.dto.FaceCaptureArguments
import com.innovatrics.android.dot.face.fragment.FaceCaptureFragment
import com.teravin.android.biometric.fragment.FaceBiometricEnrollmentFragment

class EnrollmentFragment : FaceBiometricEnrollmentFragment() {
    override fun onBiometricEnrollmentSuccess(p0: Uri?, p1: ByteArray?) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.navHost) as NavHostFragment
        val navController = navHostFragment.navController
        val model = EnrollmentModel(p1,p0,"0","Success")
        val arg = bundleOf("enrollArg" to model)
        navController.navigate(R.id.action_enrollmentFragment_to_mainFragment,arg)
    }

    override fun onBiometricCaptureFailed(p0: String?, p1: String?) {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.navHost) as NavHostFragment
        val navController = navHostFragment.navController
        val model = EnrollmentModel(null,null,p0!!,p1!!)
        val arg = bundleOf("enrollArg" to model)
        navController.navigate(R.id.action_enrollmentFragment_to_mainFragment,arg)
    }
}