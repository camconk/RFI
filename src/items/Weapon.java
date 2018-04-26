package items;

public enum Weapon 
{
	Club (2,1,4,0,0),
	Dagger (1,1,4,0,0),
	Greatclub (10,1,8,0,0),
	Handaxe (2,1,6,0,0),
	Javelin (2,1,6,0,0),
	Light_hammer (2,1,4,0,0),
	Mace (4,1,6,0,0),
	Quarterstaff (4,1,6,1,8),
	Sickle (2,1,4,0,0),
	Spear (3,1,6,1,8);
	
	private final int weight;
    private final int dieCount;
    private final int dieType;
    private final int versatileCount;
    private final int versatileType;
    
    Weapon(int weight, int dieCount, int dieType, int versatileCount, int versatileType)
    {
        this.weight = weight;
        this.dieCount = dieCount;
        this.dieType = dieType;
        this.versatileCount = versatileCount;
        this.versatileType = versatileType;
    }

	public int getWeight() 
	{
		return weight;
	}

	public int getDieCount() 
	{
		return dieCount;
	}

	public int getDieType() 
	{
		return dieType;
	}

	public int getVersatileCount() 
	{
		return versatileCount;
	}

	public int getVersatileType() 
	{
		return versatileType;
	}
    
    
}
