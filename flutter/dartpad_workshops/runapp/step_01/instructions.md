## runApp 方法的结构

```dart
void runApp(
Widget app
)
```

## runApp 方法的作用

给给定的 widget 小部件充气并将其渲染添加到屏幕上。

最小的 Flutter 程序只需 runApp() 渲染小部件即可：

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(
    const Center(
      child: Text(
        'Hello, world!',
        textDirection: TextDirection.ltr,
      ),
    ),
  );
}
```

![image-20220604102217124](http://images-warehouse.test.upcdn.net/uPic/image-20220604102217124.png)

runApp() 函数接受给定 Widget 并使其成为小部件树的根。

在上边的 Demo 中，小部件树由两个小部件组成，小 Center 部件以及 Text 小部件。

Flutter 强制小部件覆盖屏幕，所以就导致文本 “Hello world” 位于屏幕中心。

在编写程序时，会根据小部件是否管理任何状态来创建属于（继承）StatelessWidget 的新的小部件。

StatefulWidget 小部件的主要作用是实现 build() 功能。
