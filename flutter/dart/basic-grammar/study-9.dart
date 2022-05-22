/**
 * Libraries and visibility
 */
import 'dart:html';
import 'package:test/test.dart';

// Specifying a library prefix
import 'package:lib1/lib1.dart';
import 'package:lib2/lib2.dart' as lib2;

// Importing only part of a library
// Import only foo.
import 'package:lib1/lib1.dart' show foo;

// Import all names EXCEPT foo.
import 'package:lib2/lib2.dart' hide foo;

// 延迟加载库
// To lazily load a library, you must first import it using deferred as.
import 'package:greetings/hello.dart' deferred as hello;

void main() {}

class A {
  // Declaring async functions:声明异步函数
  Future<String> lookUpVersion() async => '1.0.0';
}
