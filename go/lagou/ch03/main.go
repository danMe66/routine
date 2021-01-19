package main

import (
	"fmt"
)

func main() {
	//上节课作业
	//i := strings.Index("飞雪无情", "飞雪")
	//fmt.Println(i)

	//TODO::控制结构
	//if条件语句1
	i := 6
	if i > 10 {
		fmt.Println("i>10")
	} else {
		fmt.Println("i<=10")
	}
	//if条件语句2
	c := 6
	if c > 10 {
		fmt.Println("c>10")
	} else if c > 5 && c < 10 {
		fmt.Println("5<c<=10")
	} else {
		fmt.Println("c<=5")
	}
}
