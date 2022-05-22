/**
 * Operators:运算符
 */
void main() {
  // a++
  // a+b
  // a=b
  // a==b
  // c?a:b
  // a is T

  // if((n%i==0)&&(d%i==0)) ...
  // if (n % i == 0 && d % i == 0) ...

  // 算数运算符
  // +	Add
  // -	Subtract
  // -expr	Unary minus, also known as negation (reverse the sign of the expression)
  // *	Multiply
  // /	Divide
  // ~/	Divide, returning an integer result
  // %	Get the remainder of an integer division (modulo)

  // Example：
  assert(2 + 3 == 5);
  assert(2 - 3 == -1);
  assert(2 * 3 == 6);
  assert(5 / 2 == 2.5); // Result is a double
  assert(5 ~/ 2 == 2); // Result is an int
  assert(5 % 2 == 1); // Remainder

  assert('5/2 = ${5 ~/ 2} r ${5 % 2}' == '5/2 = 2 r 1');

  // ++var	var = var + 1 (expression value is var + 1)
  // var++	var = var + 1 (expression value is var)
  // --var	var = var - 1 (expression value is var - 1)
  // var--	var = var - 1 (expression value is var)
  // Example：
  int a;
  int b;

  a = 0;
  b = ++a; // Increment a before b gets its value.
  assert(a == b); // 1 == 1

  a = 0;
  b = a++; // Increment a AFTER b gets its value.
  assert(a != b); // 1 != 0

  a = 0;
  b = --a; // Decrement a before b gets its value.
  assert(a == b); // -1 == -1

  a = 0;
  b = a--; // Decrement a AFTER b gets its value.
  assert(a != b); // -1 != 0

  // Equality and relational operators：等式关系运算符
  // ==	Equal; see discussion below
  // !=	Not equal
  // >	Greater than
  // <	Less than
  // >=	Greater than or equal to
  // <=	Less than or equal to

  // Type test operators：类型判断运算法
  // as	Typecast (also used to specify library prefixes) 类型转换，指定
  // is	True if the object has the specified type
  // is!	True if the object doesn’t have the specified type

  // (employee as Person).firstName = 'Bob';
  // if (employee is Person) {
  // Type check
  // employee.firstName = 'Bob';
  // }

  // Assignment operators：赋值运算符
  // Assign value to a :value的值赋值给a
  // a = value;
// Assign value to b if b is null; otherwise, b stays the same:如果 b 为空，则为 b 赋值；否则，b 保持不变
  // b ??= value;
  // For an operator op:	a op= b	        a = a op b
  // Example:	            a += b	        a = a + b

  var c = 2; // Assign using =
  c *= 3; // Assign and multiply: c = c * 3
  assert(c == 6);

  // Logical operators:逻辑运算符
  // !expr	inverts the following expression (changes false to true, and vice versa)
  // ||	logical OR
  // &&	logical AND
  // if (!done && (col == 0 || col == 3)) {}

  // Bitwise and shift operators：按位和移位运算符
  //   &	AND
  // |	OR
  // ^	XOR
  // ~expr	Unary bitwise complement (0s become 1s; 1s become 0s)
  // <<	Shift left
  // >>	Shift right
  // >>>	Unsigned shift right

  // Conditional expressions：条件表达式
  // if-else:condition ? expr1 : expr2
  // expr1 ?? expr2
  // var visibility = isPublic ? 'public' : 'private';
  // String playerName(String? name) => name ?? 'Guest';
// Slightly longer version uses ?: operator.
  String playerName1(String? name) => name != null ? name : 'Guest';

// Very long version uses if-else statement.
  String playerName2(String? name) {
    if (name != null) {
      return name;
    } else {
      return 'Guest';
    }
  }

  // Cascade notation:级联符号
  var paint = Paint()
    ..color = Colors.black
    ..strokeCap = StrokeCap.round
    ..strokeWidth = 5.0;

  var paint1 = Paint();
  paint.color = Colors.black;
  paint.strokeCap = StrokeCap.round;
  paint.strokeWidth = 5.0;

  var button = querySelector('#confirm');
  button?.text = 'Confirm';
  button?.classes.add('important');
  button?.onClick.listen((e) => window.alert('Confirmed!'));

  final addressBook = (AddressBookBuilder()
        ..name = 'jenny'
        ..email = 'jenny@example.com'
        ..phone = (PhoneNumberBuilder()
              ..number = '415-555-0100'
              ..label = 'home')
            .build())
      .build();

  var sb = StringBuffer();
  sb.write('foo')
    ..write('bar'); // Error: method 'write' isn't defined for 'void'.

    // Other operators
    // ()	Function application	Represents a function call
  // []	Subscript access	Represents a call to the overridable [] operator; example: fooList[1] passes the int 1 to fooList to access the element at index 1
  // ?[]	Conditional subscript access	Like [], but the leftmost operand can be null; example: fooList?[1] passes the int 1 to fooList to access the element at index 1 unless fooList is null (in which case the expression evaluates to null)
  // .	Member access	Refers to a property of an expression; example: foo.bar selects property bar from expression foo
  // ?.	Conditional member access	Like ., but the leftmost operand can be null; example: foo?.bar selects property bar from expression foo unless foo is null (in which case the value of foo?.bar is null)
  // !	Null assertion operator	Casts an expression to its underlying non-nullable type, throwing a runtime exception if the cast fails; example: foo!.bar asserts foo is non-null and selects the property bar, unless foo is null in which case a runtime exception is thrown
}

class StrokeCap {
  static var round;
}

class Colors {
  static var black;
}

Paint() {}
