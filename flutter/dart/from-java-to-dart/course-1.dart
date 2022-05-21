import 'dart:html';

class Bicycle {
  int cadence;
  int _speed = 0;
  int get speed => _speed;
  int gear;

  Bicycle(this.cadence, this._speed, this.gear);

  // Bicycle(int cadence,int speed,int gear):this.cadence,this.speed,this.cadence;

  // =>使用粗箭头 ( ) 表示法缩短单行函数或方法。
  @override
  String toString() => 'Bicycle: $_speed mph';

  void applyBrake(int decrement) {
    _speed -= decrement;
  }

  void speedUp(int increment) {
    _speed += increment;
  }
}

void main() {
  var bike = Bicycle(2, 0, 1);
  print(bike);
}

class Rectangle {
  int width;
  int height;
  Point orgin;
  // 实现构造函数
  Rectangle({this.orgin = const Point(0, 0), this.width = 0, this.height = 0});
}
