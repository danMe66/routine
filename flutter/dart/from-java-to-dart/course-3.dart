import 'dart:math';

abstract class Shape {
  num get area;

  // 工厂构造函数
  factory Shape(String type) {
    if (type == 'cicle') return Circle(2);
    if (type == 'square') return Square(2);
    throw 'Can\'t create $type';
  }
}

class Circle implements Shape {
  final num radius;
  Circle(this.radius);
  num get area => pi * pow(radius, 2);
}

class Square implements Shape {
  final num side;
  Square(this.side);
  num get area => pow(side, 2);
}

// 在最高级别（任何类之外）添加以下函数，将工厂实现为顶级函数
Shape shapeFactory(String type) {
  if (type == 'cicle') return Circle(2);
  if (type == 'square') return Square(2);
  throw 'Can\'t create $type';
}

// Dart 语言不包含interface关键字，因为每个类都定义了一个 interface。
class CircleMock implements Circle {
  num area = 0;
  num radius = 0;
}

main() {
  // final circle = Circle(2);
  // final circle = shapeFactory('cicle');
  final circle = Shape('circle');
  print(circle.area);
  // final square = Square(2);
  // final square = shapeFactory('square');
  final square = Shape('square');
  print(square.area);
}
