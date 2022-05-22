/**
 * 泛型
 */
void main() {
  var names = <String>[];
  names.addAll(['Seth', 'Kathy', 'Lars']);
  // names.add(42); // Error

  // Using generic methods
  T first<T>(List<T> ts) {
    // Do some initial work or error checking, then...
    T tmp = ts[0];
    // Do some additional checking or processing...
    return tmp;
  }
}

abstract class ObjectCache {
  Object getByKey(String key);
  void setByKey(String key, Object value);
}

abstract class StringCache {
  String getByKey(String key);
  void setByKey(String key, String value);
}

abstract class Cache<T> {
  T getByKey(String key);
  void setByKey(String key, T value);
}

var pages = <String, String>{
  'index.html': 'Homepage',
  'robots.txt': 'Hints for web robots',
  'humans.txt': 'We are people, not machines'
};

// var nameSet = Set<String>.from(names);
// var nameSet = Set<String>.from(names);
// var views = Map<int, View>();
