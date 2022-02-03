package com.krupnov.qrcovid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScannerActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var zxView: ZXingScannerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        zxView = ZXingScannerView(this)
        setContentView(zxView)
    }

    override fun onPause() {
        super.onPause()
        zxView.stopCamera()
    }

    override fun onResume() {
        super.onResume()
        zxView.setResultHandler(this)
        zxView.startCamera()
    }

    override fun handleResult(rawResult: Result?) {
        Log.d("MyLog", "Result:${rawResult?.text}")
        finish()
    }
}