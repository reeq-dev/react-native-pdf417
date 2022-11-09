import React from 'react';
import { requireNativeComponent, ViewProps } from 'react-native';

interface BarcodeViewNativeProps extends ViewProps {
  text: string;
  onBarcodePress?: () => void;
}

interface BarcodeProps extends Omit<BarcodeViewNativeProps, 'onBarcodePress'> {
  onPress?: () => void;
}

const BarcodeViewNative =
  requireNativeComponent<BarcodeViewNativeProps>('BarcodeView');

export const Barcode: React.FC<BarcodeProps> = ({ onPress, ...props }) => {
  return <BarcodeViewNative {...props} onBarcodePress={onPress} />;
};
