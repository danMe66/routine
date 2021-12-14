package my.file;

import java.io.File;

public class HelloWord {

    public static void main(String[] args) {
        String filename = "/Users/mini/tmp/test.text";
        File file = new File(filename);
        if (file.isFile()) {
            System.out.println("我是文件");
        } else {
            System.out.println("我是非文件");
        }
        if (file.exists()) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

        long size = file.length();
        System.out.println("文件长度：" + size);

        long lastDate = file.lastModified();
        System.out.println("文件最后更新时间：" + lastDate);

    }

}
