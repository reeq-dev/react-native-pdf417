import { Barcode } from '@reeq/react-native-pdf417';
import React from 'react';
import { Dimensions, SafeAreaView, StyleSheet, Text } from 'react-native';

const { width: windowWidth } = Dimensions.get('window');

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      <Barcode
        text="hello pdf417"
        style={styles.barcode}
        onPress={() => {
          console.log('barcode pressed');
        }}
      />
      <Text style={styles.text}>hello pdf417</Text>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  barcode: {
    height: windowWidth / 4,
    width: windowWidth,
  },
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
