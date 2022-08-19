import Foundation
import UIKit

final class BarcodeView: UIView {
  
  @objc var text: NSString = ""
  
  override init(frame: CGRect) {
    super.init(frame: frame)
  }
  
  required init?(coder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }
  
  override func didSetProps(_ changedProps: [String]!) {
    self.setNeedsLayout()
    
    if (changedProps.contains("text")){
      render()
    }
  }
  
  private func render(){
    guard let barcode = generatePDF417Barcode(from: text as String) else {
      return
    }
    
    subviews.forEach({ $0.removeFromSuperview() })
    
    let imageView = UIImageView(image: barcode)
    imageView.frame = CGRect(x: 0, y: 0, width: bounds.width, height: bounds.height)
    imageView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
    addSubview(imageView)
  }
  
  func generatePDF417Barcode(from string: String) -> UIImage? {
      print ("generating new barcode: \(string)")
      let data = string.data(using: String.Encoding.ascii)

      if let filter = CIFilter(name: "CIPDF417BarcodeGenerator") {
          filter.setValue(data, forKey: "inputMessage")
          let transform = CGAffineTransform(scaleX: 3, y: 3)

          if let output = filter.outputImage?.transformed(by: transform) {
              return UIImage(ciImage: output)
          }
      }

      return nil
  }
  
}
