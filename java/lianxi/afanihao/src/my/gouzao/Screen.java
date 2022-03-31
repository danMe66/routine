package my.gouzao;

public class Screen {
    public int width;
    public int heigth;

    // 第一种求像素的方法
    public int pixel(int w, int h) {
        int p = w * h;
        return p;
    }

    // 第二种求像素的方法
    public int pixel1(Screen that) {
        int p = that.width * that.heigth;
        return p;
    }

    // 第三种求像素的方法
    public int pixel2() {
        int p = this.width * this.heigth;
        return p;
    }
}
