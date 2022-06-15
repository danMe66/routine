# Basic widgets：基础组件

runApp()函数接受给定Widiget，并且使其成为小部件树的根

## 代码示例

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}
```

```dart
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter layout demo',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter layout demo'),
        ),
        body: const Center(
          child: Text('Hello world'),
        ),
      ),
    );
  }
}
```