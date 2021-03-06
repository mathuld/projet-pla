package edu.ricm3.game.whaler.Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import edu.ricm3.game.whaler.Location;
import edu.ricm3.game.whaler.Model;
import edu.ricm3.game.whaler.Game_exception.Game_exception;

public class Stone extends StaticEntity {

	/**
	 * @param pos
	 * @param sprite
	 * @param underSprite
	 * @param model
	 * @throws Game_exception
	 */
	public Stone(Location pos, BufferedImage sprite, BufferedImage underSprite, Model model) throws Game_exception {
		super(pos, true, sprite, underSprite, model);
	}

	@Override
	public void step(long now) {
	}

	@Override
	public void paint(Graphics g, Location map_ref) {
		g.drawImage(m_sprite, (this.getx() - map_ref.x) * 32, (this.gety() - map_ref.y) * 32, 32, 32, null);
	}

	@Override
	public void paint_under(Graphics g, Location map_ref) {
		g.drawImage(m_underSprite, (this.getx() - map_ref.x) * 32, (this.gety() - map_ref.y) * 32, 32, 32, null);
	}
	
	public boolean isSolidUnder() {
		return true;
	}

	@Override
	public EntityType getType() {
		return EntityType.STONE;
	}

}
