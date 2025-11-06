import { codegenNativeComponent, type ViewProps } from 'react-native';

export interface Pdf417ViewProps extends ViewProps {
  text: string;
}

export default codegenNativeComponent<Pdf417ViewProps>('Pdf417View');
