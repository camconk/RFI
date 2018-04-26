package items;

import java.util.Random;

public class Inventory 
{
	Weapon hand1;
	Weapon hand2;
	int extraWeight = 0;
	int totalWeight = 0;
	int maxWeight = 300;
	Random roll = new Random();
	
	
	public Inventory(Weapon hand1, Weapon hand2)
	{
		this.hand1 = hand1;
		this.hand2 = hand2;
	}
	
	
	public Weapon getHand1()
	{
		return hand1;
	}
	
	public Weapon getHand2()
	{
		return hand2;
	}
	
	public int getExtraWeight()
	{
		return extraWeight;
	}
	
	public int getTotalWeight()
	{
		return totalWeight;
	}
	
	public int getWeaponWeight()
	{
		if (hand1 == null && hand2 == null)
		{
			return extraWeight;
		}
		
		return totalWeight - extraWeight;
	}
	
	public int getMaxWeight()
	{
		return maxWeight;
	}
	
	public void setMaxWeight(int newMaxWeight)
	{
		maxWeight = newMaxWeight;
	}
	
	public String getWeaponName()
	{
		if (! isWeaponEquipped())
		{
			return "No Weapon Equipped";
		}
		
		return hand1.toString();
	}
	
	public String getSecondWeaponName()
	{
		if (! isDualWielding())
		{
			return "Not Currently Dual Wielding";
		}
		
		return hand2.toString();
	}
	
	public void addExtraWeight(int weightToAdd)
	{
		extraWeight += weightToAdd;
	}
	
	public void subtractExtraWeight(int weightToSubtract)
	{
		extraWeight -= weightToSubtract;
	}
	
	public void equipWeapon(Weapon equippedWeapon)
	{
		hand1 = equippedWeapon;
		hand2 = null;
	}
	
	public void equipTwoWeapons(Weapon equippedWeapon1, Weapon equippedWeapon2)
	{
		hand1 = equippedWeapon1;
		hand2 = equippedWeapon2;
	}
	
	public void equipSecondWeapon(Weapon equippedWeapon)
	{
		hand2 = equippedWeapon;
	}
	
	public boolean isWeaponEquipped()
	{
		return (hand1 != null);
	}
	
	public boolean isDualWielding()
	{
		return (hand1 != null && hand2 != null);
	}
	
	
	public boolean isUnderCarryingCapacity()
	{
		return (totalWeight < maxWeight);
	}
	
	public void checkCarryingCapacity()
	{
		if (isUnderCarryingCapacity())
		{
			System.out.println("You are not over your carrying capacity");
		}
		else
		{
			System.out.println("You are carrying too much and are over your carrying capacity!");
		}
	}
	
	
	public int damageRoll(int abilityModifier, int otherModifier)
	{
		int totalAttackRoll = 0;
		
		if (! isWeaponEquipped())
		{
			System.out.println("No weapon equipped");
			return 1; 											// unarmed attack is 1
		}
		else if (isDualWielding()) //dual wielding attack
		{
			System.out.println("Dual Wield attack");
			for (int i = 0; i < hand1.getDieCount(); i++)
			{
				totalAttackRoll += (roll.nextInt(hand1.getDieType()) + 1);
			}
			
			for (int i = 0; i < hand2.getDieCount(); i++)
			{
				totalAttackRoll += (roll.nextInt(hand2.getDieType()) + 1);
			}
		}
		else // one weapon attack
		{
			System.out.println("Single weapon attack");
			for (int i = 0; i < hand1.getDieCount(); i++)
			{
				totalAttackRoll += (roll.nextInt(hand1.getDieType()) + 1);
			}
		}
		
		
		totalAttackRoll += (abilityModifier + otherModifier);
		
		return totalAttackRoll;
	}
	
	
	public int damageRollVersatile(int abilityModifier, int otherModifier)
	{
		int totalAttackRoll = 0;
		
		if (! isWeaponEquipped())
		{
			return 1;
		}
		
		for (int i = 0; i < hand1.getVersatileCount(); i++)
		{
			totalAttackRoll += (roll.nextInt(hand1.getVersatileType()) + 1);
		}
	
		totalAttackRoll += (abilityModifier + otherModifier);
		
		return totalAttackRoll;
	}
}
