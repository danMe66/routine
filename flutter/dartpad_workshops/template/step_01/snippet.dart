import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    title: 'My App',
    // home: SafeArea(child: MyScaffold()),
    home: EchoText(text: "Hello world"),
  ));
}

class EchoText extends StatelessWidget {
  final String text;
  final Color textColor;

  const EchoText({Key? key, required this.text, this.textColor = Colors.blue});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        color: textColor,
        child: Text(text),
      ),
    );
  }
}
