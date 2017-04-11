package main;

public class slot 
{
	int ID;
	int ID2;
	boolean changed=false;
	public boolean getChanged() {
		return changed;
	}
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	public int getID2() {
		return ID2;
	}
	public void setID2(int iD2) {
		ID2 = iD2;
	}

	int count;
	int oldCount;
	
	public int getOldCount() {
		return oldCount;
	}
	public void setOldCount(int oldCount) {
		this.oldCount = oldCount;
	}
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
