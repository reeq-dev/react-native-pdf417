import UIKit

@objc(Pdf417ViewRenderer)
public class Pdf417ViewRenderer: NSObject {
  private weak var container: UIView?

  @objc public init(container: UIView) {
      self.container = container
  }

  @objc public func setText(_ text: String) {
    render(text)
  }

  private func render(_ text: String) {
    guard let container = container else { return } // safe capture
    
    container.subviews.forEach { $0.removeFromSuperview() }
    
    guard let data = text.data(using: .ascii) else { return }
    
    DispatchQueue.global(qos: .userInitiated).async {
      if let filter = CIFilter(name: "CIPDF417BarcodeGenerator") {
        filter.setValue(data, forKey: "inputMessage")
        let transform = CGAffineTransform(scaleX: 3, y: 3)
        
        if let output = filter.outputImage?.transformed(by: transform) {
          let image = UIImage(ciImage: output)
            
          DispatchQueue.main.async {
              let imageView = UIImageView(image: image)
              imageView.frame = CGRect(
                x: 0,
                y: 0,
                width: container.bounds.width,
                height: container.bounds.height
              )
              imageView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
              container.addSubview(imageView)
          }
        }
      }
    }
  }
}
