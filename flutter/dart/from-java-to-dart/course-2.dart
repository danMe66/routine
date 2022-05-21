import 'dart:math';

void main() {
  // 实例化类
  print(Rectangle(origin: const Point(10, 20), width: 100, height: 200));
  print(Rectangle(origin: const Point(10, 10)));
  print(Rectangle(width: 30));
  print(Rectangle());
}

class Rectangle {
  int width;
  int height;
  Point origin;
  // 实现构造函数
  Rectangle({this.origin = const Point(0, 0), this.width = 0, this.height = 0});

  // 重写toString()方法
  @override
  String toString() =>
      'Origin:(${origin.x},${origin.y}),width:$width,height:$height';
}
