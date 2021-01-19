package main

import "fmt"

func main() {
	//var声明一个变量格式
	// var 变量名 类型 = 表达式
	var a int = 10
	fmt.Println(a)
	//也可以不指定变量的类型
	var b = 20
	fmt.Println(b)
	//一次声明多个变量
	var (
		c = 1
		d = 2
	)
	fmt.Println(c)
	fmt.Println(d)
	//因为是同类型的变量，可以简写为
	var (
		j = 0
		k = 1
	)

	fmt.Println(j)
	fmt.Println(k)
	//TODO::Go的基础类型学习
	//TODO::整型，整型可分为：
	//TODO::有符号整型：int、int8、int16、int32和int64

	//TODO::浮点型
	fmt.Println("---------浮点型-------")
	var f32 float32 = 2.2
	var f64 float64 = 10.3456
	fmt.Println("f32:", f32, "f64:", f64)
	//TODO::布尔型
	fmt.Println("---------布尔型-------")
	var bf bool = false
	var bt bool = true
	fmt.Println("bf:", bf, "bt:", bt)
	//TODO::字符串
	fmt.Println("---------字符串-------")
	var s1 string = "世界"
	var s2 string = "hello"
	fmt.Println("say:", s1+s2)
	//TODO::零值
	fmt.Println("---------零值-------")
	var z1 int
	var z2 float64
	var z3 bool
	var z4 string
	fmt.Println(z1, z2, z3, z4)
	//TODO::变量
	fmt.Println("---------变量的简短声明-------")
	//变量名:=b表达式（等于 var 变量名=表达式）
	i := 10
	//bf1: = true
	//s1 := "Hello"
	fmt.Println("简短声明：", i)
	//TODO::指针
	fmt.Println("---------指针-------")
	pi := &i
	fmt.Println(*pi)
	//TODO::赋值
	fmt.Println("---------赋值-------")
	i = 20
	fmt.Println("i的新值为：", i)
	//TODO::常量【在 Go 语言中，只允许布尔型、字符串、数字类型这些基础类型作为常量】
	fmt.Println("---------常量-------")
	const name = "飞雪无情"
	//TODO::常量生成器iota
	fmt.Println("---------常量生成器-------")
	const (
		one   = 1
		two   = 2
		three = 3
		four  = 4
	)
	fmt.Println("常量生成器：", one, two, three, four)
	const (
		oneI = iota + 1
		twoI
		threeI
		fourI
	)
	fmt.Println("常量生成器(递增)：", oneI, twoI, threeI, fourI)
}
