<?php
$str=1234567;
function t1($str){
 $str=strrev($str);
 $res=strrev(chunk_split($str,3,','));
 return $res;
}
echo t1($str);
