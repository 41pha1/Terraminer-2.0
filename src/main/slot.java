package main;

public class slot 
{
	int ID;
	int count;
	
	public int getID() {
		return ID;
	}
	public void addItem(int iD) {
		count+=1;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	slot(int id, int c)
	{
		ID=id;
		count=c;
	}
}
