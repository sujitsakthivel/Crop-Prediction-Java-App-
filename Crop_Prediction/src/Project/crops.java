package Project;

public class crops {	
	String crop_id;
	String crop_name;
	String crop_type;
	double C_req;
	double N_req;
	double P_req;
	double Ph_req;
	double Php_req;
	double temp_req;
	double water_req;
	crops( String id,String name, String type)
	{
		crop_type = type;
		crop_name = name;
		crop_id = id;
	}
}
