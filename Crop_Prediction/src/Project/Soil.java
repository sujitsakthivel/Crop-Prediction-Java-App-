package Project;

public class Soil {
String Soil_id;
String type;
String Area_id;

Soil(String si, String t, String id)
{
	Soil_id = si;
	type = t;
	Area_id = id;
}

public void update(String si)
{
	type = si;
	
	
}
}
