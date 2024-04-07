package edu.missouri.finalproject.math;

import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D.Double
{
	/**
	 * Needed for {@code Serializable} interface.
	 */
	private static final long serialVersionUID = -2974445949810095451L;
	
	/**
	 * Create a {@code Rectangle} with all fields set to 0.0.
	 */
	public Rectangle()
	{
		// Set all zeros
		super(0.0, 0.0, 0.0, 0.0);
	}
	
	/**
	 * Creates a {@code Rectangle} with set position and dimensions.
	 * 
	 * @param x The X of the upper-left corner of the new {@code Rectangle}.
	 * @param y The Y of the upper-left of the new {@code Rectangle}.
	 * @param width The width of the new {@code Rectangle}.
	 * @param height The height of the new {@code Rectangle}.
	 */
	public Rectangle(double x, double y, double width, double height)
	{
		// Set all values
		super(x, y, width, height);
	}
	
	/**
	 * Translate the X of this.
	 * 
	 * @param value The X to translate this by.
	 * @return Returns {@code this}.
	 */
	public Rectangle translateX(double value)
	{
		// Set the value
		this.x += value;
		
		// Return this
		return this;
	}
	
	/**
	 * Translate the Y of this.
	 * 
	 * @param value The Y to translate this by.
	 * @return Returns {@code this}.
	 */
	public Rectangle translateY(double value)
	{
		// Set the value
		this.y += value;

		// Return this
		return this;
	}
	
	/**
	 * Set the X of the upper-left corner of this.
	 * 
	 * @param value The new X of the upper-left corner of this.
	 * @return Returns {@code this}.
	 */
	public Rectangle setX(double value)
	{
		// Set the value
		this.x = value;
		
		// Return this
		return this;
	}
	
	/**
	 * Set the Y of the upper-left corner of this.
	 * 
	 * @param value The new Y of the upper-left corner of this.
	 * @return Returns {@code this}.
	 */
	public Rectangle setY(double value)
	{
		// Set the value
		this.y = value;

		// Return this
		return this;
	}
	
	/**
	 * Set the width of this.
	 * 
	 * @param value The new width of this.
	 * @return Returns {@code this}.
	 */
	public Rectangle setWidth(double value)
	{
		// Set the value
		this.width = value;

		// Return this
		return this;
	}
	
	/**
	 * Set the height of this.
	 * 
	 * @param value The new height of this.
	 * @return Returns {@code this}.
	 */
	public Rectangle setHeight(double value)
	{
		// Set the value
		this.height = value;

		// Return this
		return this;
	}
	
	/**
	 * Check if this rectangle is below the upper height bound of another Rectangle.
	 * 
	 * @param bound The Rectangle used as a bounding box.
	 * @return Returns {@code true} if the rectangle is below the upper bound.
	 */
	public boolean withinRectangleTop(Rectangle bound)
	{
		// Return whether top side is below top bound
		return this.getY() > bound.getY();
	}
	
	/**
	 * Check if this rectangle is above the lower height bound of another Rectangle.
	 * 
	 * @param bound The Rectangle used as a bounding box.
	 * @return Returns {@code true} if the rectangle is above the lower bound.
	 */
	public boolean withinRectangleBottom(Rectangle bound)
	{
		// Return whether bottom side is below top bound
		return this.getY() + this.getHeight() < bound.getY() + bound.getHeight();
	}
	
	/**
	 * Check if this rectangle is right of the left bound of another Rectangle.
	 * 
	 * @param bound The Rectangle used as a bounding box.
	 * @return Returns {@code true} if the rectangle is right of the left bound.
	 */
	public boolean withinRectangleLeft(Rectangle bound)
	{
		// Return whether left side is to the right of left bound
		return this.getX() > bound.getX();
	}
	
	/**
	 * Check if this rectangle is left of the right bound of another Rectangle.
	 * 
	 * @param bound The Rectangle used as a bounding box.
	 * @return Returns {@code true} if the rectangle is left of the right bound.
	 */
	public boolean withinRectangleRight(Rectangle bound)
	{
		// Return whether right side is to the left of right bound
		return this.getX() + this.getWidth() < bound.getX() + bound.getWidth();
	}
}
