import 'package:flutter/material.dart';

// main 函数调用了 runApp 方法，其功能是启动 Flutter应用
// runApp 接受的是一个 widget 参数，MyApp 是一个对象，是 flutter应用 的一个根组件
// void main() => runApp(MaterialApp(home: Text('Hello Word')));
void main() => runApp(
      // 文档说明：https://api.flutter.dev/flutter/material/material-library.html
      MaterialApp(
        // 脚手架小部件,有很多不同的属性
        // 文档说明：https://api.flutter.dev/flutter/material/Scaffold-class.html
        home: Scaffold(
          // 修改脚手架小部件的背景颜色属性
          backgroundColor: Colors.blueGrey,
          // 属性 AppBar，文档说明：https://api.flutter.dev/flutter/material/AppBar-class.html
          appBar: AppBar(
            // 标题
            title: Text('I Am Rich'),
            // 背景颜色
            backgroundColor: Colors.blueGrey[900],
          ),
          // 居中属性小部件
          // body: Center(
          // 文本小部件
          // child: Text('Hello Word'),
          // ),
          // body: Image(
          //   // 属性 图片小部件
          //   // 文档说明：https://api.flutter.dev/flutter/widgets/Image-class.html
          //   image: NetworkImage(
          //       'https://www.2011xa.com/uploads/allimg/c170512/1494523i104960-1c21.jpg'),
          // ),
          body: Center(
            child: Image(
              // 属性 图片小部件
              // 文档说明：https://api.flutter.dev/flutter/widgets/Image-class.html
              image: NetworkImage(
                  'https://www.2011xa.com/uploads/allimg/c170512/1494523i104960-1c21.jpg'),
            ),
          ),
        ),
      ),
    );
