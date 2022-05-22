import 'dart:math';

/**
 * Classes
 */
void main() {
  // var p = Point(2, 2);
  // var p2 = Point.fromJson({'x': 1, 'y': 2});
  // var a = p?.y;
  var p = Point(2, 3);
  print(p.distanceFromOrigin);

  assert(p.y == 2);

  var employee = Employee.fromJson({});
  print(employee);

  var logger = Logger('UI');
  logger.log('Button clicked');

  var logMap = {'name': 'UI'};
  var loggerJson = Logger.fromJson(logMap);

  final v = Vector(2, 3);
  final w = Vector(2, 2);

  assert(v + w == Vector(4, 5));
  assert(v - w == Vector(0, 1));

  var rect = Rectangle(3, 4, 20, 15);
  assert(rect.left == 3);
  rect.right = 12;
  assert(rect.left == -8);

  assert(Queue.initialCapacity == 16);
}

class Point {
  // double? x; // Declare instance variable x, initially null.
  // double? y; // Declare y, initially null.
  // // Instance variables
  // double z = 0; // Declare z, initially 0.

  final double x;
  final double y;
  final double distanceFromOrigin;

  // Using constructors
  Point(double x, double y)
      : x = x,
        y = y,
        distanceFromOrigin = sqrt(x * x + y * y);

  // Methods
  double distanceTo(Point other) {
    var dx = x - other.x;
    var dy = y - other.y;
    return sqrt(dx * dx + dy * dy);
  }
}

class ProfileMark {
  // Initializing formal parameters
  final String name;
  final DateTime start = DateTime.now();

  ProfileMark(this.name);
  ProfileMark.unnamed() : name = '';
}

class Person {
  String? firstName;

  Person.fromJson(Map data) {
    print('in Person');
  }
}

class Employee extends Person {
  // Person does not have a default constructor;
  // you must call super.fromJson().
  Employee.fromJson(super.data) : super.fromJson() {
    print('in Employee');
  }
}

// Operators
class Vector {
  final int x, y;

  Vector(this.x, this.y);

  Vector operator +(Vector v) => Vector(x + v.x, y + v.y);
  Vector operator -(Vector v) => Vector(x - v.x, y - v.y);

  // Operator == and hashCode not shown.
  // ···
}

class Vector2d {
  final double x;
  final double y;
  Vector2d(this.x, this.y);

  Vector2d.named({required this.x, required this.y});
}

class Vector3d extends Vector2d {
  final double z;
  Vector3d(super.x, super.y, this.z);

  // Forward the y parameter to the named super constructor like:
  // Vector3d.yzPlane({required double y, required this.z})
  //       : super.named(x: 0, y: y);
  Vector3d.yzPlane({required super.y, required this.z}) : super.named(x: 0);
}

// Constant constructors
class ImmutablePoint {
  static const ImmutablePoint origin = ImmutablePoint(0, 0);

  final double x, y;

  const ImmutablePoint(this.x, this.y);
}

// Factory constructors
class Logger {
  final String name;
  bool mute = false;

  // _cache is library-private, thanks to
  // the _ in front of its name.
  static final Map<String, Logger> _cache = <String, Logger>{};

  factory Logger(String name) {
    return _cache.putIfAbsent(name, () => Logger._internal(name));
  }

  factory Logger.fromJson(Map<String, Object> json) {
    return Logger(json['name'].toString());
  }

  Logger._internal(this.name);

  void log(String msg) {
    if (!mute) print(msg);
  }
}

// Getters and setters
class Rectangle {
  double left, top, width, height;

  Rectangle(this.left, this.top, this.width, this.height);

  // Define two calculated properties: right and bottom.
  double get right => left + width;
  set right(double value) => left = value - width;
  double get bottom => top + height;
  set bottom(double value) => top = value - height;
}

// Abstract methods
abstract class Doer {
  // Define instance variables and methods...

  void doSomething(); // Define an abstract method.
}

class EffectiveDoer extends Doer {
  void doSomething() {
    // Provide an implementation, so the method is not abstract here...
  }
}

// Abstract classes
// This class is declared abstract and thus
// can't be instantiated.
abstract class AbstractContainer {
  // Define constructors, fields, methods...

  void updateChildren(); // Abstract method.
}

// Adding features to a class: mixins
class Musician extends Performer with Musical {
  // ···
}

class Maestro extends Person with Musical, Aggressive, Demented {
  Maestro(String maestroName) {
    name = maestroName;
    canConduct = true;
  }
}

mixin Musical {
  bool canPlayPiano = false;
  bool canCompose = false;
  bool canConduct = false;

  void entertainMe() {
    if (canPlayPiano) {
      print('Playing piano');
    } else if (canConduct) {
      print('Waving hands');
    } else {
      print('Humming to self');
    }
  }
}

// Static variables
class Queue {
  static const initialCapacity = 16;
  // ···
}
