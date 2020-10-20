<?php
$file='abc.exe.jpg';
//echo strrchr($file,'.');
//echo strrev(strstr(strrev($file),'.',true));

echo pathinfo($file,PATHINFO_EXTENSION);
