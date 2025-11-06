import { Pdf417View } from '@reeq/react-native-pdf417';
import { useState } from 'react';
import {
  ScrollView,
  StyleSheet,
  Text,
  TouchableWithoutFeedback,
  useWindowDimensions,
  View,
} from 'react-native';

export default function App() {
  const { width: windowWidth } = useWindowDimensions();
  const [randomText, setRandomText] = useState('Generate random code');

  const sizes = [
    { height: windowWidth / 4, width: windowWidth, text: 'large barcode' },
    {
      height: windowWidth / 5,
      width: windowWidth / 1.2,
      text: 'medium barcode',
    },
    {
      height: windowWidth / 6,
      width: windowWidth / 1.4,
      text: randomText,
      onPress: () => setRandomText(Date.now().toString()),
    },
  ];

  return (
    <View style={styles.container}>
      <ScrollView contentContainerStyle={styles.scroll}>
        {sizes.map(({ width, height, text, onPress }) => {
          return (
            <View key={text}>
              <TouchableWithoutFeedback onPress={onPress}>
                <Pdf417View text={text} style={{ height, width }} />
              </TouchableWithoutFeedback>
              <Text style={styles.label}>{text}</Text>
            </View>
          );
        })}
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#4f4f4fff',
    paddingTop: 60,
  },
  scroll: {
    flex: 1,
    gap: 16,
    alignItems: 'center',
    justifyContent: 'center',
  },
  label: {
    color: '#ffffff',
    textAlign: 'center',
  },
});
