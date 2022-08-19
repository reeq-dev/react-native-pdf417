import {
  requireNativeComponent,
  UIManager,
  Platform,
  ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-pdf417' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

type Pdf417Props = {
  color: string;
  style: ViewStyle;
};

const ComponentName = 'Pdf417View';

export const Pdf417View =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<Pdf417Props>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
