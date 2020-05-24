// 引包：此行代码作用是导入了材质UI组件库。
// 材料是一种标准的移动端和网页端的视觉设计语言，扑默认提供了一套丰富的材质风格的UI组件。
import 'package:flutter/material.dart';

// 应用程序入口
void main() {
  // main 函数调用了 runApp 方法，其功能是启动 Flutter应用
  // runApp 接受的是一个 widget 参数，MyApp 是一个对象，是 flutter应用 的一个根组件
  runApp(MyApp());
}

// 笔记备注：
// ① 在 Flutter 中，大多数东西都是widget（后同“组件”或“部件”），
//    包括对齐（alignment），填充（padding）和布局（layout）等，它们都是以widget的形式提供；
// ② Flutter在合并页面时，会调用组件的build方法，
//    widget 的主要工作是提供一个 build() 方法来描述如何构建UI界面（通常是通过组合，拼装其他基础widget）；
// ③ MaterialApp是材质库中提供的 Flutter APP 框架，
//    通过它可以设置应用的名称，主题，语言，首页和路由列表等。也是MaterialApp一个小部件；
// ④home 为Flutter应用的首页，它也是一个 widget。

// MyApp类代表Flutter应用，它继承了StatelessWidget类，这也就意味着应用本身也是一个小部件
class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // 应用程序名称
      title: 'Flutter Demo',
      // 主题
      theme: ThemeData(
        // 蓝色主题
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      // 应用首页路由
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

// 笔记备注①：
// 有状态组件和无状态组件的介绍：
// ①：有状态的小部件可以拥有状态，这些状态在小部件生命周期中是可以变的，而无状态的小部件是不可变的
// ②：有状态的小部件至少由两个类组成：StatefulWidget 类和 State 类；

// MyHomePage 是 Flutter 应用的首页，它继承自 StatefulWidget 类，表示它是一个有状态的组件（状态控件）
// StatefulWidget 类本身是不变的，但是 State 类中持有的状态在小部件生命周期中可能会发生变化
class MyHomePage extends StatefulWidget {
  // 在这里，MyHomePage 这个类中并没有 build 方法，
  // 取而代之的是，build方法被挪到了 _MyHomePageState 方法中
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  // 用于记录按钮点击的总次数
  int _counter = 0;

// 笔记备注②：
// 当按钮点击时，会调用此函数，该函数的作用是先自增_counter，然后调用setState 方法，
// setState方法的作用是通知Flutter框架，有状态发生了改变，
// Flutter框架收到通知后，会执行build方法来根据新的状态重新构建界面，
// Flutter 对此方法做了优化，使重新执行变的很快，所以你可以重新构建任何需要更新的东西，而无需分别去修改各个widget。

// 设置状态的自增函数,点击加号按钮就会调用此函数
  void _incrementCounter() {
    setState(() {
      // 为保存屏幕右下角带“+”号按钮点击次数的状态
      _counter++;
    });
  }

// 备注笔记③
// 构建UI界面的逻辑在build方法中，当MyHomePage第一次创建时，
// _MyHomePageState类会被创建，当初始化完成后，Flutter框架会调用Widget的build方法来构建widget树，
// 最终将widget树渲染到设备屏幕上。

// 构建 UI 界面
// MyHomePage 这个类中的 build 方法被移到此处
  @override
  Widget build(BuildContext context) {
    // Scaffold 是 Material 库中提供的页面脚手架，
    // 它提供了默认的导航栏、标题和包含主屏幕widget树（后同“组件树”或“部件树”）的body属性。（组件树可以很复杂）
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headline4,
            ),
          ],
        ),
      ),
      // floatingActionButton是页面右下角的带“+”的悬浮按钮，
      // 它的 onPressed 属性接受一个回调函数，代表它被点击后的处理器，
      floatingActionButton: FloatingActionButton(
// 备注笔记④
// 在_incrementCounter方法中，首先会自增_counter计数器（状态），
// 然后setState会通知Flutter框架状态发生变化，
// 接着，Flutter框架会调用build方法以新的状态重新构建UI，最终显示在设备屏幕上。
        //回调函数调用设置状态的自增函数（本业代码第69行）
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }
}

// 备注笔记⑤
// 为什么要将 build 方法放在 State（本页代码第58行）中，而不是放在 StatefulWidget（本页代码第48行）中？
// 目的：提高开发的灵活性
// 如果将build()方法放在StatefulWidget中则会有两个问题：
// ①：状态访问不便
// ②：继承 StatefulWidget 不便
//
