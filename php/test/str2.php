<?php
$str=1234567;
function t2($str){
 $str=str_split(strrev($str),3);
 $res=strrev(implode(',',$str));
 return $res;
}
var_dump(t2($str));
