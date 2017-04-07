package main;

public class craftingRecipie 
{
	boolean shaped;
	int s1; 
	int s2; 
	int s3; 
	int s4;
	int r1;
	int c1;
	craftingRecipie(int S1,	int S2,	int S3,	int S4,	int R1, int C1, boolean shpd)
	{
		s1=S1;
		s2=S2;
		s3=S3;
		s4=S4;
		r1=R1;
		c1=C1;
		shaped=shpd;
	}
	public int getC1() {
		return c1;
	}
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public int getS1() {
		return s1;
	}
	public void setS1(int s1) {
		this.s1 = s1;
	}
	public int getS2() {
		return s2;
	}
	public void setS2(int s2) {
		this.s2 = s2;
	}
	public int getS3() {
		return s3;
	}
	public void setS3(int s3) {
		this.s3 = s3;
	}
	public int getS4() {
		return s4;
	}
	public void setS4(int s4) {
		this.s4 = s4;
	}
	public int getR1() {
		return r1;
	}
	public void setR1(int r1) {
		this.r1 = r1;
	}
	public boolean isShaped() {
		return shaped;
	}
	public void setShaped(boolean shaped) {
		this.shaped = shaped;
	}
}
