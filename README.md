# react-native-pdf417

React-Native library which allows you to generate a barcode in pdf417 format

Android pdf417 writer is based on zxing library https://github.com/zxing/zxing

## Screenshots

<div>
  <img src="https://user-images.githubusercontent.com/26365596/185647050-5623f0a1-00ca-4c64-a279-866ca21cfad2.png" alt="iOS" width="200"/>
  <img src="https://user-images.githubusercontent.com/26365596/185647152-31297ea9-7014-49f0-a2af-1a0c61feba08.png" alt="Android" width="200"/>
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
import { Barcode } from '@reeq/react-native-pdf417';

// ...

const { width: windowWidth } = useWindowDimensions();

<Barcode
  text="hello pdf417"
  style={{ height: windowWidth / 4, width: windowWidth }}
/>;
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
