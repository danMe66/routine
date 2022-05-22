/**
 * Callable classes:可调用的类
 */
class WannabeFunction {
  String call(String a, String b, String c) => '$a $b $c!';
}

var wf = WannabeFunction();
var out = wf('Hi', 'there,', 'gang');

// void main() => print(out);

/**
 * Typedefs:类型定义
 */
typedef IntList = List<int>;
IntList il = [1, 2, 3];

typedef ListMapper<X> = Map<X, List<X>>;
Map<String, List<String>> m1 = {}; // Verbose.
ListMapper<String> m2 = {}; // Same thing but shorter and clearer.

typedef Compare<T> = int Function(T a, T b);
int sort(int a, int b) => a - b;

void main() {
  assert(sort is Compare<int>); // True!
  // TODO: refactor into an AbstractLlamaGreetingFactory?
  print('Welcome to my Llama farm!');
}

// Metadata:元数据
class Television {
  /// Use [turnOn] to turn the power on instead.
  @Deprecated('Use turnOn instead')
  void activate() {
    turnOn();
  }

  /// Turns the TV's power on.
  void turnOn() {
    print('...');
  }
  // ···
}

// 自定义元数据
// library todo;
class Todo {
  final String who;
  final String what;

  const Todo(this.who, this.what);
}
// import 'todo.dart';

@Todo('seth', 'make this do something')
void doSomething() {
  print('do something');
}
// Documentation comments：文档注释、说明
/*
   * This is a lot of work. Consider raising chickens.

  Llama larry = Llama();
  larry.feed();
  larry.exercise();
  larry.clean();
   */

/// A domesticated South American camelid (Lama glama).
///
/// Andean cultures have used llamas as meat and pack
/// animals since pre-Hispanic times.
///
/// Just like any other animal, llamas need to eat,
/// so don't forget to [feed] them some [Food].
class Llama {
  String? name;

  /// Feeds your llama [food].
  ///
  /// The typical llama eats one bale of hay per week.
  void feed(Food food) {
    // ...
  }

  /// Exercises your llama with an [activity] for
  /// [timeLimit] minutes.
  void exercise(Activity activity, int timeLimit) {
    // ...
  }
}

class Food {
}

class Activity {
}
