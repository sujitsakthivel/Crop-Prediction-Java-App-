package Project;

public class crops_props extends crops{
	double C_req;
	double N_req;
	double P_req;
	double Ph_req;
	double Php_req;
	double temp_req;
	double water_req;
	crops_props( String id,String name, String type, double C,double N,double P,double Ph,double Php,double temp,double water)
	{
		super(id,name,type);
		 C_req=C;
		 N_req=N;
		 P_req=P;
		 Ph_req=Ph;
		 Php_req=Php;
		 temp_req=temp;
		 water_req=water;
	}
	
}
