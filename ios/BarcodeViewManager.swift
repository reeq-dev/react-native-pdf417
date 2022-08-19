import Foundation

@objc (BarcodeViewManager)
final class BarcodeViewManager : RCTViewManager {
  
  override static func requiresMainQueueSetup() -> Bool {
    return true
  }
  
  override func view() -> UIView! {
    return BarcodeView()
  }
}
