package my.polymorphic;

public class MyVideoFile extends MyFile {
	
	public int duration;

	public void play()
	{
		System.out.println("播放视频:" + name);
	}

	@Override
	public void info()
	{
		System.out.println("文件:" + name + " 大小：" + size+ " 时长：" + duration);
	}

	public void stop()
	{
		System.out.println("停止播放:" + name);
	}
}
