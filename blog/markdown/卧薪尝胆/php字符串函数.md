# php字符串函数

## 打印字符串的第一个字符

```php
$a='abcdr';
//截取
echo substr($a,0,1);
//字符串还有类数组的特性，可以用索引下标
echo $a[0];
```

## 如何实现字符串反转

```php
$str='abcde';
function reu($str){
  $len=-strlen($str);//-5
  for($new='',$start=-1;$start>=$len;$start--){
    $new.=substr($str,$start,1);
  }
  return $new;
}
echo reu($str),'<br>';
//系统自带的字符串函数
echo strrev($str);
```

## 将 1234567 转成 1，234，567

```php
$str=1234567;
//第一种思路：首先反转字符串->将字符串长度和符号进行分割->反转回原样
function t1($str){
  //反转
  $str=strrev($str);
  $res=strrev(chunk_split($str,3,','));
  return $res;
}
var_dump(t1($str));//,1,234,567

//第二种思路：反转->按三个分成数组->再将数组，转换为字符串->再反转回原样
function t2($str){
  $str=str_split(strrev($str),3);
  $res=strrev(implode(',',$str));
  return $res;
}
var_dump(t2($str));//string(9) "1,234,567"

//第三种
echo number_format($str);//1,234,567
```

## 获取文件的后缀名

```php
$file='abc.exce.jpg';
//第一种：使用系统函数，查找的文件名
echo strchr($file,'.').'<br>';//.jpg
//第二种：strstr()返回的是字符串首次出现，加上true表示返回的是. 之前的字符串
echo strrev(strstr(strrev($file),'.',true));//jpg
//第三种：strrpos()返回的是最后一次.出现的位置,然后在进行截取
echo substr($file,strrops($file,'.'));
//第四种：pathinfo()函数返回的是文件的路径的信息
echo pathinfo($file,PATHINFO_EXTENSION);//jpg

```

