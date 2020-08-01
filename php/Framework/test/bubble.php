<?php
echo "<pre>";
$arr=[1,5,3,7];
$len=count($arr);
for($i=0;$i<$len-1;$i++){
  for($j=0;$j<$len-$i-1;$j++){
    if($arr[$j]>$arr[$j+1]){
      $tmp=$arr[$j+1];
      $arr[$j+1]=$arr[$j];
      $arr[$j]=$tmp;
    }
  }
}
print_r($arr);
