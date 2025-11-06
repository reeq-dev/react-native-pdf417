package com.pdf417

import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.Pdf417ViewManagerInterface
import com.facebook.react.viewmanagers.Pdf417ViewManagerDelegate

@ReactModule(name = Pdf417ViewManager.NAME)
class Pdf417ViewManager : SimpleViewManager<Pdf417View>(),
  Pdf417ViewManagerInterface<Pdf417View> {
  private val mDelegate: ViewManagerDelegate<Pdf417View>

  init {
    mDelegate = Pdf417ViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<Pdf417View>? {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): Pdf417View {
    return Pdf417View(context)
  }

  override fun onAfterUpdateTransaction(view: Pdf417View) {
    super.onAfterUpdateTransaction(view)
    view.render()
  }

  @ReactProp(name = "text")
  override fun setText(view: Pdf417View?, text: String?) {
    if (text.isNullOrEmpty()) {
      return
    }
    view?.setText(text)
  }

  companion object {
    const val NAME = "Pdf417View"
  }
}
