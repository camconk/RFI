import java.util.Random;
import java.util.Scanner;

public class Character 
{
String Name;
String Role;
String Race;
int role;
int race;
int Lvl;
int[] Stats;
int Ac;
int hp;
int Prof;
int[] StatBonus;
int HD;
int Death;
int Life;

public void SetName()
{
	System.out.println("What is the name of the Character?");
	Scanner scan = new Scanner(System.in);
	Name = scan.nextLine();
	System.out.println("Wlecome to the world of Dnd " + Name + "!!");
	
}

public void RollStats(int[] stats)
{

}

public void SelectRace(int race, String Race)
{
	
}

public void SelectRole(int role, String Role)
{
	
}

public int Skill (int SkillID, int[] StatBonus, int Prof)
{
	int t = 5;
	return t;
}

public int Attack (int[] stats)
{
	int roll= 4;
	return roll;
}

public void RollDeathSave(int Life, int Death, int HP)
{
	Random roll = new Random();
	int deathsave = roll.nextInt((20)+1);
	
	System.out.println("You rolled a " + deathsave );
	
	if (deathsave>10)
		{Life++;
		System.out.println("Death save success!!");
		System.out.println("Successes: " + Life);
		System.out.println("Failures: " + Death);		
		}
	else 
		{Death++;
		System.out.println("Death save Failure...");
		System.out.println("Successes: " + Life);
		System.out.println("Failures: " + Death);
		}
	
	if (Life == 3) 
	{
		System.out.println(Name + " has stablized!!");
		Life = 0;
		Death = 0;
	}
		
	if (Death == 3)
	{
		System.out.println(Name + "has died...");
		Life = 0;
		Death = 0;
		HP = 0;
		
		
	}
		
		
		
	
				
}

}
