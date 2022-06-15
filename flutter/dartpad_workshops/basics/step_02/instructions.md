# Using Material Components 使用Material组件构建

## 代码示例

```dart
void main() {
  runApp(const MaterialApp(
    title: 'My App',
    home: TutorialHome(),
  ));
}
```

Container小部件用来创建举行视觉元素，装饰BoxDecoration，例如背景、边框、阴影

Container 还可以对其大小、边距、填充、约束

Container 也可以使用矩阵在三维空间中进行变换


```dart
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
}
```