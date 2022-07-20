package Project;

public class Area {
String Area_id;
String name;
String pincode;
String farmer_id;
soil_props s;
weather w = new weather();

Area(String a,String n,String p,String f,String si, String t,double c,double ni,double pho,double ph,double php)
{
	Area_id = a;
	name = n;
	pincode = p;
	farmer_id = f;
	s = new soil_props(si,t,c,ni,pho,ph,php,a);
}

public void update(String n, String p,String si, double c ,double ni,double po,double ph,double php)
{
	name = n;
	pincode = p;
	s.update(si,  c , ni, po, ph, php);
}
}
