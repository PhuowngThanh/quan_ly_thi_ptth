package dao;

import java.util.ArrayList;

public interface DaoInterface<O>{
	
	public O read(O x);
	
	public ArrayList<O> readAll();
	
	public int create(O x);
	
	public int update(O x);
	
	public int delete(O x);

}
