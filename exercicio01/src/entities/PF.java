package entities;

public final class PF extends Pessoa{
	
	private Double healthExpenditure;
	
	
	public PF()
	{super();}

	public PF(String name, Double rendaAnual, Double healthExpenditure) {
		super(name, rendaAnual);
		this.healthExpenditure = healthExpenditure;
	}

	public Double getHealthExpenditure() {
		return healthExpenditure;
	}

	public void setHealthExpenditure(Double healthExpenditure) {
		this.healthExpenditure = healthExpenditure;
	}
	
	
	@Override
	public Double tax() {
		if(rendaAnual < 20000.00)
		{
			return (rendaAnual * 0.15) - (healthExpenditure * 0.5);
		}
		else if (rendaAnual >= 20000.00)
		{
			return (rendaAnual * 0.25) - (healthExpenditure * 0.5);
		}
		else
		{
			return 0.0;	
		}
		
	}
	
}
