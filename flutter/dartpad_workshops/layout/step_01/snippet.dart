import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

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
        // body: const Center(
        //   child: Text('Hello world'),
        // ),
        // body: Center(child: buildRow()),
        // body: Center(child: buildColumn()),
        body: Center(
          child: Column(
            children: [
              buildRow(),
              buildColumn(),
              starRow(),
            ],
          ),
        ),
      ),
    );
  }

  Widget buildRow() => Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Expanded(child: Image.asset('images/pic1.jpeg')),
          // Expanded(flex: 2, child: Image.asset('images/pic2.jpeg')),
          Expanded(child: Image.asset('images/pic3.jpeg')),
        ],
      );

  Widget buildColumn() => Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Image.asset('images/pic1.jpeg'),
          Image.asset('images/pic2.jpeg'),
          Image.asset('images/pic3.jpeg'),
        ],
      );

  Widget starRow() => Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Icon(Icons.star, color: Colors.green[500]),
          Icon(Icons.star, color: Colors.green[500]),
          Icon(Icons.star, color: Colors.green[500]),
          const Icon(Icons.star, color: Colors.black),
          const Icon(Icons.star, color: Colors.black),
        ],
      );
}
