#import "React/RCTViewManager.h"
#import "React/RCTUIManager.h"
#import "React/RCTLog.h"
#import "React/RCTEventEmitter.h"

@interface RCT_EXTERN_MODULE(BarcodeViewManager, RCTViewManager)

// props
RCT_EXPORT_VIEW_PROPERTY(text, NSString)

// events
RCT_EXPORT_VIEW_PROPERTY(onBarcodePress, RCTDirectEventBlock)

@end
