void printInteger(int aNumber) {
  print('The number is $aNumber');
}

// Late variables:后期变量
late String description;
/**
 * 变量
 */
void main() {
  var number = 42;
  printInteger(number);

  int? lineCount;
  assert(lineCount == null);

  description = 'hihihihi';
  print(description);

  final name = 'Bob';
  // name = 'Adam';//final 修饰的变量只能设置一次。

  const bar = 100000;
  const double atm = 1.2020 * bar;

  var foo = const [];
  final bar1 = const [];
  const baz = [];

  foo = [1, 2, 3];
  // baz = [42];//不能为常量变量赋值
}
