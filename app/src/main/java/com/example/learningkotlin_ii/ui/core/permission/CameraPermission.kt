package com.example.learningkotlin_ii.ui.core.permission

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.lifecycle.LifecycleOwner

class CameraPermission(
    private val context: Context,
    activityResultCaller: ActivityResultCaller,
    private val lifecycleOwner: LifecycleOwner,
    private val pvFinder: PreviewView
) {
    companion object {
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }
    private val requestForPermissionLauncher: ActivityResultLauncher<String>
    init {
        requestForPermissionLauncher = activityResultCaller.registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            registerPermissionResultHandler(isGranted)
        }
    }
    private fun showDeniedPermissionMessage() {
        Toast.makeText(
            context,
            "Camera permission is required for palmistry :/",
            Toast.LENGTH_SHORT
        ).show()
    }
    private fun registerPermissionResultHandler(isGranted: Boolean) {
        if (isGranted) {
            startCamera()
            return
        }
        showDeniedPermissionMessage()
    }
    private fun hasCameraPermission(): Boolean {
        val state = PermissionChecker.checkSelfPermission(
            context,
            CAMERA_PERMISSION
        )
        return state == PermissionChecker.PERMISSION_GRANTED
    }
    private fun startCamera() {
        val providerFuture = ProcessCameraProvider.getInstance(context)
        providerFuture.addListener({
            val provider = providerFuture.get()
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(pvFinder.surfaceProvider)
                }
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                provider.unbindAll()
                provider.bindToLifecycle(lifecycleOwner, cameraSelector, preview)
            }
            catch (ex: Exception) {
                Log.i("manuel", "Error al iniciar la cámara ${ex.message}")
            }
        }, ContextCompat.getMainExecutor(context))
    }
    fun start() {
        if (hasCameraPermission()) {
            startCamera()
            return
        }
        requestForPermissionLauncher.launch(CAMERA_PERMISSION)
    }
}