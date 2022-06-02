import 'package:flutter/material.dart';

void main() {
  // 1:Basic widgets：基础组件
  // runApp(const MyApp());
  ///runApp()函数接受给定Widiget，并且使其成为小部件树的根

// 2:Using Material Components：Material组件构建
  // runApp(const MaterialApp(
  //   title: 'My App',
  //   // home: SafeArea(child: MyScaffold()),
  //   home: TutorialHome(),
  // ));

  // 3:处理手势
  // runApp(const MaterialApp(
  //   home: Scaffold(
  //     body: Center(
  //       child: MyButton(),
  //     ),
  //   ),
  // ));

  // 4:放在一起
  // runApp(MaterialApp(
  //   home: Scaffold(
  //     body: Center(
  //       child: ShoppingListItem(
  //         product: const Product(name: 'Chips'),
  //         inCart: true,
  //         onCartChanged: ((product, inCart) {}),
  //       ),
  //     ),
  //   ),
  // ));
// 5:
  runApp(const MaterialApp(
    title: 'Shopping App',
    home: ShoppingList(
      products: [
        Product(name: 'Eggs'),
        Product(name: 'Flour'),
        Product(name: 'Chocolate chips'),
      ],
    ),
  ));
}

// Basic widgets：基础组件
class MyAppBar extends StatelessWidget {
  final Widget title;
  const MyAppBar({required this.title, super.key});

  @override
  Widget build(BuildContext context) {
    // Container小部件用来创建举行视觉元素，装饰BoxDecoration
    // 例如背景、边框、阴影
    // Container 还可以对其大小、边距、填充、约束
    // Container 也可以使用矩阵在三维空间中进行变换
    return Container(
      height: 56.0,
      padding: const EdgeInsets.symmetric(horizontal: 8.0),
      decoration: BoxDecoration(color: Colors.blue[500]),
      child: Row(
        children: [
          const IconButton(
            onPressed: null,
            icon: Icon(Icons.menu),
            tooltip: 'Nav menu',
          ),
          Expanded(child: title),
          const IconButton(
            onPressed: null,
            icon: Icon(Icons.search),
            tooltip: 'Search',
          ),
        ],
      ),
    );
  }
}

class MyScaffold extends StatelessWidget {
  const MyScaffold({super.key});

  @override
  Widget build(BuildContext context) {
    return Material(
      child: Column(
        children: [
          MyAppBar(
            title: Text(
              '菜单',
              style: Theme.of(context).primaryTextTheme.headline6,
            ),
          ),
          const Expanded(
            child: Center(
              child: Text('我是中间的页面内容'),
            ),
          ),
        ],
      ),
    );
  }
}

// Using Material Components：Material组件构建
class TutorialHome extends StatelessWidget {
  const TutorialHome({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: const IconButton(
          onPressed: null,
          icon: Icon(Icons.menu),
        ),
        title: const Text('菜单'),
        actions: const [
          IconButton(
            onPressed: null,
            icon: Icon(Icons.search),
          ),
        ],
      ),
      body: const Center(
        child: Text('我是中间页面内容'),
      ),
      floatingActionButton: const FloatingActionButton(
        onPressed: null,
        tooltip: 'Add',
        child: Icon(Icons.add),
      ),
    );
  }
}

// 处理手势
class MyButton extends StatelessWidget {
  const MyButton({super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        print('点击了按钮');
      },
      child: Container(
        height: 50.0,
        padding: const EdgeInsets.all(8.0),
        margin: const EdgeInsets.symmetric(horizontal: 8.0),
        decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(5.0),
            color: Colors.lightGreen[500]),
        child: const Center(
          child: Text('Engage'),
        ),
      ),
    );
  }
}

// 放在一起
class Product {
  final String name;

  const Product({required this.name});
}

typedef CartChangedCallback = Function(Product product, bool inCart);

class ShoppingListItem extends StatelessWidget {
  final Product product;
  final bool inCart;
  final CartChangedCallback onCartChanged;

  ShoppingListItem({
    required this.product,
    required this.inCart,
    required this.onCartChanged,
  }) : super(key: ObjectKey(product));

  Color _getColor(BuildContext context) {
    return inCart ? Colors.black54 : Theme.of(context).primaryColor;
  }

  TextStyle? _getTextStyle(BuildContext context) {
    if (!inCart) return null;

    return const TextStyle(
      color: Colors.black54,
      decoration: TextDecoration.lineThrough,
    );
  }

  @override
  Widget build(BuildContext context) {
    return ListTile(
      onTap: () {
        onCartChanged(product, inCart);
      },
      leading: CircleAvatar(
        backgroundColor: _getColor(context),
        child: Text(product.name[0]),
      ),
      title: Text(product.name, style: _getTextStyle(context)),
    );
  }
}

class ShoppingList extends StatefulWidget {
  const ShoppingList({required this.products, super.key});

  final List<Product> products;
  @override
  _ShoppingListState createState() => _ShoppingListState();
}

class _ShoppingListState extends State<ShoppingList> {
  final _shoppingCart = <Product>{};

  void _handleCartChanged(Product product, bool inCart) {
    setState(() {
      // When a user changes what's in the cart, you need
      // to change _shoppingCart inside a setState call to
      // trigger a rebuild.
      // The framework then calls build, below,
      // which updates the visual appearance of the app.

      if (!inCart) {
        _shoppingCart.add(product);
      } else {
        _shoppingCart.remove(product);
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Shopping List'),
      ),
      body: ListView(
        padding: const EdgeInsets.symmetric(vertical: 8.0),
        children: widget.products.map((product) {
          return ShoppingListItem(
            product: product,
            inCart: _shoppingCart.contains(product),
            onCartChanged: _handleCartChanged,
          );
        }).toList(),
      ),
    );
  }
}
