package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//return all subsets of a certain set
public class AllSubsets {
	//integer version, recursively
	public static List<Set<Integer>> solveRe(Set<Integer> set)
	{
		List<Set<Integer>> ret = new LinkedList<Set<Integer>>();
		if(set.isEmpty())
		{
			ret.add(new HashSet<Integer>());
		}
		else
		{
			int theOne = set.iterator().next();
			set.remove(theOne);
			for(Set<Integer> sub:solveRe(set))
			{
				Set<Integer> newSubset = new HashSet<Integer>();
				newSubset.addAll(sub);
				newSubset.add(theOne);
				ret.add(sub);
				ret.add(newSubset);
			}
		}
		return ret;
	}
	
	//generic version, dynamic programming
	public static <T> List<Set<T>> solveDp(Set<T> set)
	{
		List<Set<T>> ret = new ArrayList<Set<T>>();
		Set<T> nullSet = new HashSet<T>();
		ret.add(nullSet);
		for(T t:set)
		{
			int size = ret.size();
			for(int i=0; i<size; i++)
			{
				Set<T> subSet = new HashSet<T>();
				subSet.addAll(ret.get(i));
				subSet.add(t);
				ret.add(subSet);
			}
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		Set<Integer> origin = new HashSet<Integer>();
		origin.add(1);
		origin.add(2);
		origin.add(3);
		for(Set<Integer> set:solveDp(origin))
		{
			System.out.println(set);
		}
	}
}
