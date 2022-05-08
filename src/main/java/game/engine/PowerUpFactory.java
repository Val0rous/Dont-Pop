package game.engine;
import game.util.Point2D;
import game.util.RandomInt;
import game.model.PowerUpObj; //classe power up da mettere public

import game.model.AbstractGameObject;
import game.model.AbstractGameObject.ObjectType;
import game.util.WhereToSpawn;

/**
 * A factory for creating powerup objects using Factory method where it use a random type of powerup
 * and the class creates it.
 */
public class PowerUpFactory {
	
	/** The game engine. */
	private final GameEngine gameEngine; //da passare al costruttore
	
	/** The wheretospawn. */
	private final WhereToSpawn whereToSpawn = new WhereToSpawn();
	
	/**
	 * Instantiates a new poweup factory.
	 *
	 * @param gameEngine the game engine
	 */
	public PowerUpFactory(final GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	/**
	 * Instantiates a new poweup factory.
	 *
	 * @return the abstract game object
	 */
	public AbstractGameObject getPowerUpObj()  {

		final var pos = this.whereToSpawn.getPowerUpSpawnPoint();
		final Integer typeOfPowerUp = new RandomInt().getRandomInt(1, 3);
		
		return switch (typeOfPowerUp) {
    		case 1 -> createShield(pos);
    		case 2 -> createMultiplier(pos);
    		default -> createSweeper(pos);
		};
	}
	
	/**
	 * Creates a new Poweup object Shield.
	 * @param position
	 * @return the power up obj
	 */
	public PowerUpObj createShield(final Point2D position) {
		return new PowerUpObj(position, ObjectType.PWRUP_SHIELD, this.gameEngine);
	}
	
    /**
     * Creates a new Poweup object Multiplier.
     * @param position
     * @return the power up obj
     */
    public PowerUpObj createMultiplier(final Point2D position) {
        return new PowerUpObj(position, ObjectType.PWRUP_MULTIPLIER, this.gameEngine);
	}

    /**
     * Creates a new Poweup object Sweeper.
     * @param position
     * @return the power up obj
     */
    public PowerUpObj createSweeper(final Point2D position) {
        return new PowerUpObj(position, ObjectType.PWRUP_SWEEPER, this.gameEngine);
	}

}
