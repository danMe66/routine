import 'dart:async';
import 'dart:io';

/**
 * usage
 */
void main() {
  // 修改类型
  var numbers = [1, 2, 3, 4];
  numbers.removeAt(1);
  var ints = List<int>.from(numbers);
  print(ints);

  // 使用whereType()按类型过滤
  var objects = [1, 'a', 2, 'b', 3];
  var intss = objects.whereType<int>();
  print(intss);

  // map
  var stuff = <dynamic>[1, 2];
  var reciprocals = stuff.map<double>((n) => 1 / n);
  print(reciprocals);

  List<int> singletonList(int value) {
    var list = <int>[];
    list.add(value);
    return list;
  }

  print(singletonList(1));

  // 在访问时强制转换每个元素
  void printEvens(List<Object> objects) {
    // We happen to know the list only contains ints.
    for (final n in objects) {
      if ((n as int).isEven) print(n);
    }
  }

  // 将命名参数与其默认值分开。
  void insert(Object item, {int at = 0}) {}
}

///this 重定向到命名构造函数
class ShadeOfGray {
  final int brightness;

  ShadeOfGray(int val) : brightness = val;

  ShadeOfGray.black() : this(0);

  // But now it will!
  ShadeOfGray.alsoBlack() : this.black();
}

// 异步
Future<bool> fileContainsBear(String path) async {
  var contents = await File(path).readAsString();
  return contents.contains('bear');
}

Future<T> logValue<T>(FutureOr<T> value) async {
  if (value is Future<T>) {
    var result = await value;
    print(result);
    return result;
  } else {
    print(value);
    return value;
  }
}
