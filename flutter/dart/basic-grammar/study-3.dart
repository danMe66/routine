import 'dart:ffi';

List<String> arguments = ['hello'];
bool topLevel = true;
void foo() {}

class A {
  static void bar() {}
  void baz() {}
}

/**
 * 方法
 */
void main(List<String> arguments) {
  print(arguments);

  var _nobleGases = [1, 2, 3];
  // Functions
  // bool isNoble(int atomicNumber) {
  //   return _nobleGases[atomicNumber] != null;
  // }

  // isNoble(atomicNumber) {
  //   return _nobleGases[atomicNumber] != null;
  // }

  bool isNoble(int atomicNumber) => _nobleGases[atomicNumber] != null;

  print(isNoble(1));

  // Parameters:参数
  void enableFlags({bool? t, bool? t1 = false}) {
    if (t == t1) {
      print('t=t1');
    } else {
      print('t!=t1');
    }
  }

  enableFlags(t: true, t1: true);

  //参数可选
  String say(String from, String msg, [String? device]) {
    var result = '$from says $msg';
    if (device != null) {
      result = '$result with a $device';
    }
    return result;
  }

  print(say('Bob', 'I love You'));
  print(say('Bob', 'I love You', 'Mac'));

  void doStuff(
      {List<int> list = const [1, 2, 3],
      Map<String, String> gifts3 = const {'first': '一', 'two': '二'}}) {
    print('list:$list');
    print('map:$gifts3');
  }

  doStuff();

  // Anonymous functions:匿名函数
  const list = ['apples', 'bananas', 'oranges'];
  list.forEach((item) => print(item));

  list.forEach((item) => print('${list.indexOf(item)}: $item'));

  // Lexical scope
  var insideMain = true;
  void myFunction() {
    var insideMyFunction = true;
    void nextedFunction() {
      var insideNextedFunction = true;

      assert(topLevel);
      assert(insideMain);
      assert(insideMyFunction);
      assert(insideNextedFunction);
    }
  }

  // Lexical closures
  var add2 = makeAdder(2);
  var add4 = makeAdder(4);
  assert(add2(3) == 5);
  assert(add4(3) == 7);

  Function x;
  x = foo;
  assert(foo == x);
  x = A.bar;
  assert(A.bar == x);
}

// Lexical closures
Function makeAdder(int addby) {
  return (int i) => addby + i;
}
