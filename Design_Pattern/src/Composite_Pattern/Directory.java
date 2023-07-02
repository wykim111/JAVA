package Composite_Pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
	private String name;//디렉터리의 이름
	private ArrayList directory = new ArrayList();//디렉터리 엔트리의 집합
	
	public Directory(String name)
	{
		this.name = name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int size = 0;
		Iterator it = directory.iterator();
		
		while(it.hasNext())
		{
			Entry entry = (Entry)it.next();
			size += entry.getSize();
		}
		
		return size;
	}
	
	public Entry add(Entry entry)
	{
		directory.add(entry);
		
		return this;
	}
	
	@Override
	protected void printList(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + "/" + this);
		Iterator it = directory.iterator();
		
		while(it.hasNext())
		{
			Entry entry = (Entry)it.next();
			entry.printList(prefix + "/" + name);
		}
		
	}
	
}
