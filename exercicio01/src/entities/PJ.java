package entities;

public final class PJ extends Pessoa{

	private Integer employeeNumber;
	
	
	public PJ()
	{super();}
	
	public PJ(String name, Double rendaAnual, Integer employeeNumber) {
		super(name, rendaAnual);
		this.employeeNumber = employeeNumber;
	}
	

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}


	@Override
	public Double tax() {
		if (employeeNumber > 10)
		{
			return rendaAnual * 0.14;
		}
		else
		{
			return rendaAnual * 0.16;
		}
	}

	
}
