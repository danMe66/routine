// Enums:枚举
import 'study-1.dart';

enum Color { red, green, blue }

// dart的with、implements、extendsdart的with、implements、extends
// extends：能重写父类属性或者方法，同时能通过super引用父类field
// implements：必须重写所有属性和方法，且无法调用父类field
// with：无需super关键字能直接调用父类方法或者属性
void main() {
  final my_color = 'red';
  if (Color.red == my_color) {
    print('The color is red');
  } else {
    print('The color is not red');
  }

  if (my_color == 'red') {
    print('The color is red');
  }
}

// Inheritance:继承
class Orbiter extends Spacecraft {
  double altitude;

  Orbiter(super.name, DateTime super.launchDate, this.altitude);
}

// mixin:混合
mixin Piloted {
  int astronauts = 1;

  void describeCrew() {
    print('Number of astronauts:$astronauts');
  }
}

class PilotedCraft extends Spacecraft with Piloted {
  void print_astronauts() {
    // with:，如下：↓
    print('Number of astronauts:$astronauts');
  }
}

// implements：必须重写所有属性和方法，且无法调用父类field
class MockSpaceship implements Spacecraft {
  @override
  DateTime? launchData;

  @override
  String name;

  @override
  void describe() {
    // TODO: implement describe
  }

  @override
  // TODO: implement launchYear
  int? get launchYear => throw UnimplementedError();
}

// 被abstract关键字修饰的抽象类
// 抽象类可以被继承：
// 1：其子类必须重写抽象类中的抽象方法
// 2：抽象类子类可以不用重写抽象方法
// URL:抽象类介绍：https://blog.csdn.net/zhao_to/article/details/111241995
abstract class Describable {
  void describe();
}
