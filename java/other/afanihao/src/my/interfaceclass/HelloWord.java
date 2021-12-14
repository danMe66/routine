package my.interfaceclass;

public class HelloWord {

    public static void main(String[] args) {

        XiaoMiPlay xiaoMiPlay = new XiaoMiPlay();
        xiaoMiPlay.play(null);
        xiaoMiPlay.mp4("纪录片.mp4");

        LeiDiPlay leiDiPlay = new LeiDiPlay();
        leiDiPlay.play(null);

    }

}
