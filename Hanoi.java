import java.util.Stack;

public class Hanoi {
	static class Tower
	{
		Stack<Integer> plates;
		Tower()
		{
			plates = new Stack<Integer>();
		}
		public void add(int plate) throws Exception
		{
			if(plate<1) throw new Exception("plate size less than 1: "+plate);
			if(plates.isEmpty())
			{
				plates.push(plate);
			}
			else
			{
				if(plate>=plates.peek()) throw new Exception("plate size not less than the top plate: "+plate+">"+plates.peek());
				else plates.push(plate);
			}
		}
		public int takeAway() throws Exception
		{
			if(plates.isEmpty()) throw new Exception("no plates to take.");
			return plates.pop();
		}
	}
	public static void hanoiGame(Tower from, Tower to, Tower intermediate, int platesToMove) throws Exception
	{
		if(platesToMove>from.plates.size()) throw new Exception("no enough plates to move: "+platesToMove+">"+from.plates.size());
		if(platesToMove<1) throw new Exception("count of plates to move should be positive: "+platesToMove);
		if(platesToMove>1) hanoiGame(from, intermediate, to, platesToMove-1);
		to.add(from.takeAway());
		if(platesToMove>1) hanoiGame(intermediate, to, from, platesToMove-1);
	}
	public static void main(String[] args) throws Exception
	{
		Tower[] towers = new Tower[3];
		for(int i=0; i<3; i++)
		{
			towers[i] = new Tower();
		}
		for(int i=9; i>0; i--)
		{
			towers[0].add(i);
		}
		hanoiGame(towers[0], towers[1], towers[2], 9);
		for(int i=0; i<9; i++)
		{
			System.out.println(towers[1].takeAway());
		}
	}
}
