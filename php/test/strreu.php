<?php
$str='abcde';
function reu($str){
 $len=-strlen($str);
 for($new='',$start=-1;$start>=$len;$start--){
   $new.=substr($str,$start,1);
 }
  return $new;
}
echo reu($str),'<br>';
