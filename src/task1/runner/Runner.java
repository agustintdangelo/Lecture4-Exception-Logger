package task1.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import task1.exception.DeadUnitException;
import task1.exception.HealthNegativeException;
import task1.exception.WrongNameException;
import task1.robot.R2D2;
import task1.spaceArmy.Alliance;
import task1.spaceArmy.Empire;
import task1.unit.DemolitionRebel;
import task1.unit.DemolitionTrooper;
import task1.unit.Leader;
import task1.unit.RebelCommando;
import task1.unit.RebelTrooper;
import task1.unit.StormCommando;
import task1.unit.Stormtrooper;
import task1.unit.Unit;

public class Runner {
	private final static Logger LOG = Logger.getLogger(Runner.class.getName());
	public static void main(String[] args) throws DeadUnitException, HealthNegativeException, WrongNameException {
		Unit soldierE1 = new Stormtrooper(1);
		Unit soldierE2 = new StormCommando(2);
		Unit soldierE3 = new DemolitionTrooper(3);
		List<Unit> unitsE = new ArrayList<>();
		unitsE.add(soldierE1);
		unitsE.add(soldierE2);
		unitsE.add(soldierE3);

		Leader darthVader = new Leader("Darth Vader", 400, 0, "Empire");

		Empire empire = new Empire(darthVader, unitsE, "Tatooine");

		Unit soldierR1 = new RebelTrooper(1);
		Unit soldierR2 = new RebelCommando(2);
		Unit soldierR3 = new DemolitionRebel(3);
		List<Unit> unitsR = new ArrayList<>();
		Leader lukeSkywalker = new Leader("Luke Skywalker", 600, 0, "Alliance");

		unitsR.add(soldierR1);
		unitsR.add(soldierR2);
		unitsR.add(soldierR3);

		Alliance alliance = new Alliance(lukeSkywalker, unitsR, "Tatooine");
		
		
		LOG.log(Level.INFO,"      ________________.  ___     .______\r\n"
				+ "     /                | /   \\    |   _  \\\r\n"
				+ "    |   (-----|  |----`/  ^  \\   |  |_)  |\r\n"
				+ "     \\   \\    |  |    /  /_\\  \\  |      /\r\n"
				+ ".-----)   |   |  |   /  _____  \\ |  |\\  \\-------.\r\n"
				+ "|________/    |__|  /__/     \\__\\| _| `.________|\r\n"
				+ " ____    __    ____  ___     .______    ________.\r\n"
				+ " \\   \\  /  \\  /   / /   \\    |   _  \\  /        |\r\n"
				+ "  \\   \\/    \\/   / /  ^  \\   |  |_)  ||   (-----`\r\n"
				+ "   \\            / /  /_\\  \\  |      /  \\   \\\r\n"
				+ "    \\    /\\    / /  _____  \\ |  |\\  \\---)   |\r\n"
				+ "     \\__/  \\__/ /__/     \\__\\|__| `._______/");

		System.out.println(empire);
		System.out.println(alliance);
		
		alliance.attackEnemyUnitsWithUnits(empire);
		empire.travelToAnotherPlanet("Death Star");
		alliance.allUnitsRun();
		Unit soldierE4 = new Stormtrooper(4);
		empire.addUnit(soldierE4);

		lukeSkywalker.attack(soldierE3);
		lukeSkywalker.forceAttack(darthVader);
	
		System.out.println(lukeSkywalker.equals(darthVader));//use of equals		
		System.out.println(lukeSkywalker.hashCode());//use of hashcode
		
		R2D2 r2d2 = new R2D2();
		R2D2.talk();          				//static method
		r2d2.useFlamethrower(null);    //final method
		r2d2.chargeBattery(); //use of final attribute
//		soldierE1.staminaRecover(-5);
		soldierE3.healthRecover(5);
		soldierE3.healthRecover(-5);
		Leader EmperorPalpatine = new Leader("", 400, 0, "Empire");
	}
}
