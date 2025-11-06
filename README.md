# react-native-pdf417

React-Native library which allows you to generate a barcode in pdf417 format.

Android pdf417 writer is based on zxing library https://github.com/zxing/zxing

## Compatibility

- **v1.0.6** — compatible with both the old and the new React Native architectures
- **v2.0.0 and above** — compatible **only with the new architecture**

## Screenshots

<div>
  <img src="https://github.com/user-attachments/assets/4256e0d2-27aa-4684-89e5-a105c11507de" alt="iOS" width="200"/>
  <img src="https://github.com/user-attachments/assets/f8ff33a6-0a40-46b0-ada2-89dc93301b6f" alt="Android" width="200"/>
</div>

## Installation

```sh
npm install @reeq/react-native-pdf417
```

or

```sh
yarn add @reeq/react-native-pdf417
```

and

```sh
cd ios/
pod install
```

## Usage

```js
import { Pdf417View } from '@reeq/react-native-pdf417';
import { useWindowDimensions } from 'react-native';

const { width: windowWidth } = useWindowDimensions();

<Pdf417View
  text="hello pdf417"
  style={{ height: windowWidth / 4, width: windowWidth }}
/>
```

## Props

Supports most of the default `View` props and:

- `text` — text string you want to convert into a barcode (**required**)

## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)
- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)
- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
