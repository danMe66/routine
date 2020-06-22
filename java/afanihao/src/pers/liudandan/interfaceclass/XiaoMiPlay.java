package pers.liudandan.interfaceclass;

/**
 * 一个类可以实现多个接口
 * 
 * @author mini
 *
 */
public class XiaoMiPlay implements AudioPlayer, VideoPlay {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

	}

	@Override
	public void play(int[] data) {
		System.out.println("XiaoMiPlay 播放▶️歌曲");
	}

	@Override
	public void mp4(String name) {
		System.out.println("XiaoMiPlay 播放▶️：" + name);
	}

}
