package task1.spaceArmy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import task1.robot.R2D2;
import task1.unit.Leader;
import task1.unit.Unit;

public abstract class SpaceArmy {
	protected Leader leader;
	protected List<Unit> units = new ArrayList<>();
	private String name ;
	static String location = "Endor";
	private final static Logger LOG = Logger.getLogger(SpaceArmy.class.getName());

	public SpaceArmy(String name, Leader leader, List<Unit> units2, String location) {
		this.name = name;
		this.leader = leader;
		this.units = units2;
		SpaceArmy.location = location;
	}

	public void attackEnemyLeaderWithUnits(SpaceArmy enemySpaceArmy) {
		for (Unit unit : this.units) {
			unit.attack(enemySpaceArmy.leader);
		}
	}

	public void attackEnemyUnitsWithUnits(SpaceArmy enemySpaceArmy) {
		for (Unit unit : this.units) {
			for (Unit enemyUnit : enemySpaceArmy.units) {
				unit.attack(enemyUnit);
			}
		}
	}

	public void travelToAnotherPlanet(String planet) {
		SpaceArmy.location = planet;
		LOG.log(Level.INFO,"You travelled through hyperspeed and arrived at the planet " + planet + ".");
	}

	public void allUnitsRun() {
		leader.run();
		for (Unit unit : this.units) {
			unit.run();
		}
	}
	
	public void addUnit(Unit unitToAdd) {
		this.units.add(unitToAdd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(leader, name, units);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceArmy other = (SpaceArmy) obj;
		return Objects.equals(leader, other.leader) && Objects.equals(name, other.name)
				&& Objects.equals(units, other.units);
	}

	@Override
	public String toString() {
		return "SpaceArmy [leader=" + leader + ", unit=" + units + ", name=" + name + "]";
	}

	public String getLocation() {
		return location;
	}

}
