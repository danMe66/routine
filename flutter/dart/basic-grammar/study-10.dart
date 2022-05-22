/**
 * Generators:生成器
 * Synchronous generator: Returns an Iterable object.
 * Asynchronous generator: Returns a Stream object.
 */
void main() {
  /**
   * sync
   */
  Iterable<int> naturalsTo(int n) sync* {
    int k = 0;
    while (k < n) yield k++;
  }

  /**
   * async
   */
  Stream<int> asynchronousNaturalsTo(int n) async* {
    int k = 0;
    while (k < n) yield k++;
  }
}
