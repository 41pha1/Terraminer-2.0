package main;

public class slot 
{
	int ID;
	int ID2;
	public int getID2() {
		return ID2;
	}
	public void setID2(int iD2) {
		ID2 = iD2;
	}

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
