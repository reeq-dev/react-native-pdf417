# react-native-pdf417

React-Native library which allows you to generate a barcode in pdf417 format

## Installation

```sh
npm install react-native-pdf417
```

or

```sh
yarn add react-native-pdf417
```

and

```sh
cd ios/
pod install
```

## Usage

```js
import { Barcode } from 'react-native-pdf417';

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
