import 'dart:ffi';

/**
 * 类型
 */
void main() {
  // 类型强制转换
  const Object i = 3;
  const list = [i as int];
  const map = {if (i is int) i: 'int'};
  const set = {if (list is List<int>) ...list};

  // String
  var s1 = 'String';
  assert(s1 == 'String');

  var s2 = 'String';
  assert(s2 == 'String.' + 'String 1');

  // Booleans
  var fullName = '';
  assert(fullName.isEmpty);

  var hitPoints = 0;
  assert(hitPoints == 0);

  var unicorn;
  assert(unicorn == null);

  var iMeanToDoThis = 0 / 0;
  assert(iMeanToDoThis.isNaN);

  // List
  var lists = [1, 2, 3];
  var listStr = ['Car', 'Boat', 'Planes'];
  assert(lists.length == 3);
  assert(listStr.length == 4);
  var constantList = const [1, 2, 3];

  var list2 = [0, ...list];
  assert(list2.length == 4);

  // Sets
  var halogens = {'fluorine', 'chlorine', 'bromine', 'iodine', 'astatine'};
  var names = <String>{};

  var elements = <String>{};
  elements.add('fluorine');
  print(elements);
  elements.addAll(halogens);
  assert(elements.length == 5);
  print(elements);

  var constantelements = const {
    'fluorine',
    'chlorine',
    'bromine',
    'iodine',
    'astatine'
  };
  // constantelements.add("hi");
  print(constantelements);

  // Maps
  var gifts = {'first': '1', 'second': '2', 'fifth': '2'};
  var nobleGases = {1: 'first', 2: 'second', 3: 'fifth'};

  var gifts1 = Map<String, String>();
  gifts1['first'] = 'p';
  gifts1['second'] = 'd';
  gifts1['fifth'] = 'f';
  print(gifts1);

  var gifts2 = Map<int, String>();
  gifts2[1] = 'first';
  gifts2[2] = 'second';
  gifts2[3] = 'fifth';
  print(gifts2);

  var constantMap = const {1: 'a', 2: 'b', 3: 'c'};
  print(constantMap);
}
