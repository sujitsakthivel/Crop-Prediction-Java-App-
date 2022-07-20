package Project;

public class soil_props extends Soil{
	double C_amt;
	double N_amt;
	double P_amt;
	double PH_amt;
	double PHP_amt;
	soil_props(String si, String t,double c,double ni,double pho,double ph,double php,String id)
	{
		super(si,t,id);
		C_amt = c;
		N_amt = ni;
		P_amt = pho;
		PH_amt = ph;
		PHP_amt = php;
	}

	public void update(String si, double c ,double ni,double po,double ph,double php)
	{
		super.update(si);
		C_amt = c;
		N_amt = ni;
		P_amt = po;
		PH_amt = ph;
		PHP_amt = php;
	}
}
