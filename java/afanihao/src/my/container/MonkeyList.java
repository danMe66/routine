package my.container;

public class MonkeyList {
	private Monkey heade = new Monkey(0, "石猴");

	// 添加一个对象
	public void add(Monkey m)
	{
		m.next = heade.next;
		heade.next = m;
	}

	// 按照id查询一个对象
	public Monkey get(int id)
	{
		Monkey m = heade.next;
		while (m != null)
		{
			if (m.id == id)
			{
				return m;
			}
			m = m.next;
		}
		return null;
	}
}
