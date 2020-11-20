import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.blueGrey,
        appBar: AppBar(
          title: Text("I am rich"),
          backgroundColor: Colors.blueGrey[900],
        ),
        body: Center(
          child: Image(
            // 使用网络图像
            // image: NetworkImage('https://www.nasa.gov/sites/default/files/thumbnails/image/blackhole.png'),
            // 使用本地资源图像
            image: AssetImage('images/diamond.png'),
          ),
        ),
      ),
    ),
  );
}
