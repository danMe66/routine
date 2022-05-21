// Exceptions：异常
import 'dart:io';

void main(List<String> args) {
  printWithDeploy("hello world");
  String staus = 'fail';
  if (staus == "fail") {
    throw StateError("fail fail fail");
  }
  try {
    throw StateError("fail fail fail");
  } catch (e) {
    print(e.toString());
  } finally {
    print('object');
  }
}

// Async
const oneSecond = Duration(seconds: 10);
Future<void> printWithDeploy(String message) async {
  // await:等待异步函数的执行结果,去掉await就会直接不需要等待，直接执行下边的逻辑
  await Future.delayed(oneSecond);
  print(message);
}
