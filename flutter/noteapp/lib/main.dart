import 'package:flutter/material.dart';

// main 函数调用了 runApp 方法，其功能是启动 Flutter应用
// runApp 接受的是一个 widget 参数，MyApp 是一个对象，是 flutter应用 的一个根组件
// void main() => runApp(MaterialApp(home: Text('Hello Word')));
void main() => runApp(
      MaterialApp(
        home: Center(
          child: Text('Hello Word'),
        ),
      ),
    );
