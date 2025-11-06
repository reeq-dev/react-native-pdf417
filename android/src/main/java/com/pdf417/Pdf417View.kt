package com.pdf417

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.facebook.react.uimanager.ThemedReactContext
import com.google.zxing.BarcodeFormat
import androidx.core.graphics.set
import androidx.core.graphics.createBitmap

class Pdf417View : ViewGroup {

  private var barcodeImage: AppCompatImageView = AppCompatImageView(context)
  private var barcodeWriter: Pdf417ViewWriter = Pdf417ViewWriter()

  private var matrixHeight: Int = 144
  private var matrixWidth: Int = 420
  private var text: String? = null

  constructor(context: Context?) : super(context) {
    configureComponent()
  }

  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    configureComponent()
  }

  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  ) {
    configureComponent()
  }

  private fun configureComponent() {
    layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    barcodeImage.apply {
      scaleType = ImageView.ScaleType.FIT_XY
      adjustViewBounds = false
    }
    val layoutParams = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(
      androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.MATCH_PARENT,
      androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.MATCH_PARENT
    ).apply {
      topToTop = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
      bottomToBottom = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
      startToStart = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
      endToEnd = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
    }
    addView(barcodeImage, layoutParams)
  }

  fun setText(text: String) {
    this.text = text
  }

  fun render() {
    text?.let { barcodeText ->
      barcodeImage.setImageDrawable(null)

      Thread {
        val matrix = barcodeWriter.encode(barcodeText, BarcodeFormat.PDF_417, matrixWidth, matrixHeight)
        val bitmap: Bitmap = createBitmap(matrix.width, matrix.height)

        for (x in 0 until matrix.width) {
          for (y in 0 until matrix.height) {
            val color = if (matrix.get(x, y)) context.getColor(android.R.color.black) else context.getColor(android.R.color.white)
            bitmap[x, y] = color
          }
        }

        val themedReactContext = context as ThemedReactContext
        themedReactContext.currentActivity?.runOnUiThread {
          barcodeImage.setImageBitmap(bitmap)
        }
      }.start()
    }
  }

  override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    for (i in 0 until childCount) {
      val child = getChildAt(i)
      child.layout(0, 0, r - l, b - t)
    }
  }
}
