import Foundation
import UIKit
import React

final class BarcodeView: UIView {
  
    @objc var onBarcodePress: RCTBubblingEventBlock?
    @objc var text: NSString = ""
  
    private var gestureRecognizer: UITapGestureRecognizer?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        gestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.onPress))
        self.addGestureRecognizer(gestureRecognizer!)
    }
  
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    deinit {
        if(gestureRecognizer != nil){
            self.removeGestureRecognizer(gestureRecognizer!)
        }
    }
  
    override func didSetProps(_ changedProps: [String]!) {
        self.setNeedsLayout()

        if (changedProps.contains("text")){
            render()
        }
    }
  
    @objc func onPress(sender : UITapGestureRecognizer) {
        if sender.state == .ended {
            onBarcodePress?([:])
        }
    }
    
    private func render(){
        subviews.forEach({ $0.removeFromSuperview() })
        
        let data = (self.text as String).data(using: String.Encoding.ascii)
        
        DispatchQueue.global(qos: .userInitiated).async {
            if let filter = CIFilter(name: "CIPDF417BarcodeGenerator") {
                filter.setValue(data, forKey: "inputMessage")
                let transform = CGAffineTransform(scaleX: 3, y: 3)
                
                if let output = filter.outputImage?.transformed(by: transform) {
                    let image = UIImage(ciImage: output)
                    
                    DispatchQueue.main.async {
                        let imageView = UIImageView(image: image)
                        imageView.frame = CGRect(x: 0, y: 0, width: self.bounds.width, height: self.bounds.height)
                        imageView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
                        self.addSubview(imageView)
                    }
                }
            }
        }
    }
}
