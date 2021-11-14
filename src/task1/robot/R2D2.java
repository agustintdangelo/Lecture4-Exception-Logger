package task1.robot;

import java.util.logging.Level;
import java.util.logging.Logger;

import task1.exception.UnitNullException;
import task1.unit.Unit;

public final class R2D2 {
	int battery, fuel;
	
	private final int batteryCharge = 100; 								//final attribute
	private final static String phrase = "Beep Bloop Blop Bleep Boop";	//final static attribute
	static int FLAMETHROWER_DAMAGE;										//static attribute
	private final static Logger LOG = Logger.getLogger(R2D2.class.getName());

	static {
		FLAMETHROWER_DAMAGE = 15;										//static block
	}

	public R2D2() {
		this.battery = 100;
		this.fuel = 100;
	}

	public void chargeBattery() {
		if(battery<100) {
			this.battery = batteryCharge;
			LOG.log(Level.INFO,"Charging... \nCharging...\nThe battery is fully charged.");
		}else {
			LOG.log(Level.INFO,"The battery is fully charged.");
		}
	}
	
	public static void talk() {
		//static method
		LOG.log(Level.INFO,phrase);
	}

	public final void useFlamethrower(Unit enemyUnit) {
		//final method
		try {
			if(enemyUnit == null) {
				throw new UnitNullException();
			}
			if (enemyUnit.getHealth() > 0) {
				enemyUnit.setHealth(enemyUnit.getHealth() - FLAMETHROWER_DAMAGE);
				this.fuel -= 25;
				this.battery -= 25;
				LOG.log(Level.INFO,"R2D2 uses flamethrower and does " + FLAMETHROWER_DAMAGE + " damage to the enemy number: "
						+ enemyUnit.getUnitId());
				if (enemyUnit.getHealth() <= 0) {
					LOG.log(Level.WARNING,"An enemy has been defeated!");
					enemyUnit.setHealth(0);
					enemyUnit.setAlive(false);
				}
				LOG.log(Level.INFO,"The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
						+ enemyUnit.getHealth());
			} else {
				LOG.log(Level.INFO,"The enemy unit " + enemyUnit.getUnitId() + " is dead so you can't attack it.");
			}
		}catch(UnitNullException e) {
			LOG.log(Level.INFO,e.getMessage());
		}
		
	}
	
}
