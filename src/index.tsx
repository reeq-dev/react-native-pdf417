import React from 'react';
import { requireNativeComponent, ViewProps } from 'react-native';

interface BarcodeViewNativeProps extends ViewProps {
  text: string;
}

interface BarcodeProps extends BarcodeViewNativeProps {}

const BarcodeViewNative =
  requireNativeComponent<BarcodeViewNativeProps>('BarcodeView');

export const Barcode: React.FC<BarcodeProps> = ({ ...props }) => {
  return <BarcodeViewNative {...props} />;
};
