import 'package:flutter/material.dart';

void main() {
  // runApp(const MyApp());
  ///runApp()函数接受给定Widiget，并且使其成为小部件树的根
  runApp(const MaterialApp(
    title: 'My App',
    home: SafeArea(child: MyScaffold()),
  ));
}

class MyAppBar extends StatelessWidget {
  final Widget title;
  const MyAppBar({required this.title, super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 56.0,
      padding: const EdgeInsets.symmetric(horizontal: 8.0),
      decoration: BoxDecoration(color: Colors.blue[500]),
      child: Row(
        children: [
          const IconButton(
            onPressed: null,
            icon: Icon(Icons.menu),
            tooltip: 'Nav menu',
          ),
          Expanded(child: title),
          const IconButton(
            onPressed: null,
            icon: Icon(Icons.search),
            tooltip: 'Search',
          ),
        ],
      ),
    );
  }
}

class MyScaffold extends StatelessWidget {
  const MyScaffold({super.key});

  @override
  Widget build(BuildContext context) {
    return Material(
      child: Column(
        children: [
          MyAppBar(
            title: Text(
              '菜单',
              style: Theme.of(context).primaryTextTheme.headline6,
            ),
          ),
          const Expanded(
            child: Center(
              child: Text('我是中间的页面内容'),
            ),
          ),
        ],
      ),
    );
  }
}
