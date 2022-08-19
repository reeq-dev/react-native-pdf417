package com.reactnativepdf417

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ThemedReactContext
import com.google.zxing.BarcodeFormat

class BarcodeView(
    private var themedReactContext: ThemedReactContext,
    private var reactApplicationContext: ReactApplicationContext
): FrameLayout(themedReactContext){

    private lateinit var barcodeLayout: View
    private lateinit var barcodeImage: ImageView

    private var barcodeWriter: BarcodeWriter = BarcodeWriter()

    private var matrixHeight: Int = 144
    private var matrixWidth: Int = 420
    private var text: String? = null

    init {
        setupLayout()
    }

    private fun setupLayout(){
        val inflater: LayoutInflater =  themedReactContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        barcodeLayout = inflater.inflate(R.layout.barcode, this)

        barcodeImage = findViewById(R.id.barcode_image)
    }

    fun render() {
        text?.let {
            barcodeImage.setImageDrawable(null);

            val matrix = barcodeWriter.encode(it, BarcodeFormat.PDF_417, matrixWidth, matrixHeight)
            val bitmap: Bitmap = Bitmap.createBitmap(matrix.width, matrix.height, Bitmap.Config.ARGB_8888)

            for (x in 0 until matrix.width) {
                for (y in 0 until matrix.height) {
                    val color = if (matrix.get(x, y)) resources.getColor(R.color.black) else resources.getColor(R.color.white)
                    bitmap.setPixel(x, y, color)
                }
            }

            barcodeImage.setImageBitmap(bitmap)
        }
    }

    fun terminateResources() {}

    fun setText(text: String){ this.text = text }

    companion object {
        private const val TAG = "BarcodeView"
    }
}
