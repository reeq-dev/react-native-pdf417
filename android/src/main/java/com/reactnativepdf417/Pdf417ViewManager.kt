package com.reactnativepdf417


import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp

class Pdf417ViewManager(private var reactApplicationContext: ReactApplicationContext) : SimpleViewManager<BarcodeView>() {
    private lateinit var themedReactContext: ThemedReactContext

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(themedReactContext: ThemedReactContext): BarcodeView {
        this.themedReactContext = themedReactContext
        return BarcodeView(themedReactContext, reactApplicationContext)
    }

    override fun onAfterUpdateTransaction(view: BarcodeView) {
        super.onAfterUpdateTransaction(view)
        view.render()
    }

    override fun onDropViewInstance(view: BarcodeView) {
        super.onDropViewInstance(view)
        view.terminateResources()
    }

    override fun getExportedCustomDirectEventTypeConstants(): Map<String, Any>? {
        val REGISTRATION_NAME = "registrationName"
        val builder: MapBuilder.Builder<String, Any> = MapBuilder.builder()

        builder.put(BarcodeProps.Companion.ON_BARCODE_PRESS, MapBuilder.of(REGISTRATION_NAME, BarcodeProps.Companion.ON_BARCODE_PRESS))

        return builder.build()
    }

    @ReactProp(name = BarcodeProps.Companion.TEXT)
    fun setText(view: BarcodeView, text: String){
        view.setText(text)
    }

    @ReactMethod
    fun addListener(eventName: String?) {
    }

    @ReactMethod
    fun removeListeners(count: Int?) {
    }

    companion object {
        private const val REACT_CLASS = "BarcodeView"
    }
}
