#import "Pdf417View.h"

#import <react/renderer/components/Pdf417ViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/Pdf417ViewSpec/EventEmitters.h>
#import <react/renderer/components/Pdf417ViewSpec/Props.h>
#import <react/renderer/components/Pdf417ViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

using namespace facebook::react;

@interface Pdf417View () <RCTPdf417ViewViewProtocol>
@end

@implementation Pdf417View {
  UIView *_view;
  Pdf417ViewRenderer *_renderer;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
  return concreteComponentDescriptorProvider<Pdf417ViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const Pdf417ViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];
    self.contentView = _view;

    _renderer = [[Pdf417ViewRenderer alloc] initWithContainer:_view];
  }
  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
  const auto &oldViewProps = *std::static_pointer_cast<Pdf417ViewProps const>(_props);
  const auto &newViewProps = *std::static_pointer_cast<Pdf417ViewProps const>(props);

  if (oldViewProps.text != newViewProps.text) {
    NSString *newText = [NSString stringWithUTF8String:newViewProps.text.c_str()];
    [_renderer setText:newText];
  }

  [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> Pdf417ViewCls(void)
{
  return Pdf417View.class;
}

@end
