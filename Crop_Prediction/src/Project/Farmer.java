package Project;


public class Farmer{

	String name;
	String dob;
	String phone;
	String id;
	Area a[] = new Area[10];
	private String Password;
	
	Farmer (String n,String date,String p, String id, String pa)
	{
		name = n;
		dob = date;
		phone = p;
		this.id = id;
		Password = pa;
	}
}
