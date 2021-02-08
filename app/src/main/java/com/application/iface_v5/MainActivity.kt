package com.application.iface_v5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.innovatrics.android.dot.face.dto.FaceCaptureArguments
import com.innovatrics.android.dot.face.fragment.FaceCaptureFragment
import com.teravin.android.biometric.util.BiometricLicenceInitialization
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val biometricLicenceInitialization = BiometricLicenceInitialization()
        biometricLicenceInitialization.initialize(
            this,
            R.raw.sample_license,
            object :
                BiometricLicenceInitialization.ActivationCallback {
                override fun onActivationSuccess() {
                    Toast.makeText(this@MainActivity, "init license success", Toast.LENGTH_SHORT)
                        .show()
                    val navHostFragment =
                        supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
                    val navController = navHostFragment.navController
                    val faceCaptureArgument = FaceCaptureArguments.Builder().lightScoreThreshold(0.4).build()
                    val bundle = Bundle().apply {
                        putSerializable(FaceCaptureFragment.ARGUMENTS,faceCaptureArgument)
                    }
                    navController.navigate(R.id.action_mainFragment_to_enrollmentFragment,bundle)
                }

                override fun onActivationFailed(code: String?, message: String?) {
//                    Toast.makeText(this@MainActivity, "init license failed", Toast.LENGTH_SHORT).show()
                }
            })
    }

}