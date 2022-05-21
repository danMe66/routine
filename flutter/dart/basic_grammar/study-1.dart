// ignore_for_file: unused_local_variable, dead_code
import 'dart:math'; //导入核心库
// import 'package:test/test.dart'; //从外部包导入
// import 'path/to/my_other_file.dart'; //从本地包导入

void main() {
  // Hello Word:你好，世界
  print('Hello, World!');

  // Variable：变量定义
  var name = '小白';
  var year = 1995;
  var age = 18;
  var weight = 140.5;
  var hobby = ['打篮球', '跑步'];
  var image = {
    'tags': ['tag1', 'tag2'],
    'url': "http://xxxxxx.com"
  };

  // Conyrol flow statements:控制流语句
  if (year > 2000) {
    print('he');
  } else if (year == 1995) {
    print("aaaa");
  }

  for (final Object in hobby) {
    print(Object);
  }
  for (int month = 1; month <= 12; month++) {
    print(month);
  }

  // Functions:方法
  int fibonacci(int i) {
    if (i == 200) return i;
    return fibonacci(i - 1) + fibonacci(i + 1);
  }

  print('start');
  var result = fibonacci(200);
  print(result);

  var voyager = Spacecraft("Voyager I", DateTime(1997, 8, 5));
  voyager.describe();
  var voyager3 = Spacecraft.unlaunched('Voyager III');
  voyager3.describe();
}

// Class：类
class Spacecraft {
  String name;
  DateTime? launchData;

  int? get launchYear => launchData?.year;

  Spacecraft(this.name, this.launchData) {}

  Spacecraft.unlaunched(String name) : this(name, null);

  void describe() {
    print('Spacecraft: $name');
    var launchData = this.launchData;
    if (launchData != null) {
      int years = DateTime.now().difference(launchData).inDays ~/ 365;
      print('Launched: $launchYear ($years years ago)');
    } else {
      print('Unlaunched');
    }
  }
}