import React from 'react';
import {
  useWindowDimensions,
  SafeAreaView,
  Text,
  StyleSheet,
} from 'react-native';
import { Barcode } from 'react-native-pdf417';

export default function App() {
  const { width: windowWidth } = useWindowDimensions();

  return (
    <SafeAreaView style={styles.container}>
      <Barcode
        text="hello pdf417"
        style={{ height: windowWidth / 4, width: windowWidth }}
      />
      <Text style={styles.text}>[hello pdf417]</Text>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#161616',
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  text: {
    fontSize: 24,
    marginTop: 8,
    color: '#ffffff',
  },
});
