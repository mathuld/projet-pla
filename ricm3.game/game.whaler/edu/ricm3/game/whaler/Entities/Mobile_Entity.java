package edu.ricm3.game.whaler.Entities;

import java.awt.image.BufferedImage;

import edu.ricm3.game.whaler.Direction;
import edu.ricm3.game.whaler.Location;
import edu.ricm3.game.whaler.Model;
import edu.ricm3.game.whaler.Game_exception.Map_exception;
import edu.ricm3.game.whaler.Game_exception.Tile_exception;
import edu.ricm3.game.whaler.Interpretor.IAutomata;
import edu.ricm3.game.whaler.Interpretor.IState;

public abstract class Mobile_Entity extends Entity {

	long m_lastStep;
	public Direction m_direction;
	
	//L'automate associé à l'entité mobile
	public IAutomata m_automata;
	public IState m_current; //!\ Ne pas initialiser, l'initialisation aura lieu au premier step de l'automate
	

	/**
	 * @param pos
	 * @param solid
	 * @param sprite
	 * @param model
	 */
	protected Mobile_Entity(Location pos, boolean solid, BufferedImage sprite, BufferedImage underSprite, Model model,
			Direction dir) throws Map_exception {
		super(pos, solid, sprite, underSprite, model);
		m_direction = dir;
	}

	/**
	 * @throws Map_exception
	 * @throws Tile_exception
	 */
	public void movenorth() throws Map_exception, Tile_exception {
		m_model.map().tile(this.getx(), this.gety()).remove(this); // We remove the entity from the map //TODO vérifier si Mouvement valide (Solidité du bloc)
		this.m_pos.up(); // We update its location
		m_model.map().tile(this.getx(), this.gety()).addForeground(this); // We add it at the top of the Tile for its
																			// new location
	}

	/**
	 * @throws Map_exception
	 * @throws Tile_exception
	 */
	public void movesouth() throws Map_exception, Tile_exception {
		m_model.map().tile(this.getx(), this.gety()).remove(this); //TODO vérifier si Mouvement valide
		this.m_pos.down();
		m_model.map().tile(this.getx(), this.gety()).addForeground(this);
	}

	/**
	 * @throws Map_exception
	 * @throws Tile_exception
	 */
	public void moveeast() throws Map_exception, Tile_exception {
		m_model.map().tile(this.getx(), this.gety()).remove(this); //TODO vérifier si Mouvement valide
		this.m_pos.right();
		m_model.map().tile(this.getx(), this.gety()).addForeground(this);
	}

	/**
	 * @throws Map_exception
	 * @throws Tile_exception
	 */
	public void movewest() throws Map_exception, Tile_exception {
		m_model.map().tile(this.getx(), this.gety()).remove(this); //TODO vérifier si Mouvement valide
		this.m_pos.left();
		m_model.map().tile(this.getx(), this.gety()).addForeground(this);
	}

	/**
	 * 
	 */
	public void turnright() {
		switch(m_direction) {
		case SOUTH:
			m_direction = Direction.WEST;
			break;
		case NORTH:
			m_direction = Direction.EAST;
			break;
		case WEST:
			m_direction = Direction.NORTH;
			break;
		case EAST:
			m_direction = Direction.SOUTH;
			break;
		default:
			break;
		}
	}
	
	//Specific Actions
	public abstract void pop();

	public abstract void wizz();

	public abstract void hit();
	
	//TODO
	//Placebo actions (decide if Specific or Generic)
	//public abstract void jump();
	//public abstract void protect();
	//public abstract void pick();
	//public abstract void throw();
	//public abstract void store();
	//public abstract void get();
	//public abstract void power();
	//public abstract void kamikaze();
	
	

}
