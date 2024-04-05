package edu.missouri.finalproject.math;

import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double
{
	/**
	 * Needed for {@code Serializable} interface.
	 */
	private static final long serialVersionUID = -7470806918456085105L;
	
	/**
	 * Create a {@code Circle} with all fields set to 0.0.
	 */
	public Circle()
	{
		// Set all zeros
		super(0.0, 0.0, 0.0, 0.0);
	}
	
	/**
	 * Creates a {@code Circle} with set position and dimensions.
	 * 
	 * @param x The X of the upper-left corner of the new {@code Circle}.
	 * @param y The Y of the upper-left of the new {@code Circle}.
	 * @param diameter The width of the new {@code Circle}.
	 */
	public Circle(double x, double y, double diameter)
	{
		// Set all values
		super(x, y, diameter, diameter);
	}
	
	/**
	 * Set the X of the upper-left corner of this.
	 * 
	 * @param value The new X of the upper-left corner of this.
	 * @return Returns {@code this}.
	 */
	public Circle setX(double value)
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
	public Circle setY(double value)
	{
		// Set the value
		this.y = value;

		// Return this
		return this;
	}
	
	/**
	 * Set the diameter of this.
	 * 
	 * @param value The new diameter of this.
	 * @return Returns {@code this}.
	 */
	public Circle setDiameter(double value)
	{
		// Set the values
		this.height = value;
		this.width = value;

		// Return this
		return this;
	}
	
	/**
	 * Return the diameter in {@code double} precision.
	 * 
	 * @return The diameter of the {@code Circle}.
	 */
	public double getDiameter()
	{
		// Return the height
		return this.height;
	}
	
	/**
	 * Check if this circle is below the upper height bound of another Rectangle.
	 * 
	 * @param bound The {@code Rectangle} used as a bounding box.
	 * @return Returns {@code true} if the circle is below the upper bound.
	 */
	public boolean withinRectangleTop(Rectangle bound)
	{
		// Return whether top side is below top bound
		return this.getY() > bound.getY();
	}
	
	/**
	 * Check if this circle is above the lower height bound of another Rectangle.
	 * 
	 * @param bound The {@code Rectangle} used as a bounding box.
	 * @return Returns {@code true} if the circle is above the lower bound.
	 */
	public boolean withinRectangleBottom(Rectangle bound)
	{
		// Return whether bottom side is below top bound
		return this.getY() + this.getHeight() < bound.getY() + bound.getHeight();
	}
	
	/**
	 * Check if this circle is right of the left bound of another Rectangle.
	 * 
	 * @param bound The {@code Rectangle} used as a bounding box.
	 * @return Returns {@code true} if the circle is right of the left bound.
	 */
	public boolean withinRectangleLeft(Rectangle bound)
	{
		// Return whether left side is to the right of left bound
		return this.getX() > bound.getX();
	}
	
	/**
	 * Check if this circle is left of the right bound of another Rectangle.
	 * 
	 * @param bound The {@code Rectangle} used as a bounding box.
	 * @return Returns {@code true} if the circle is left of the right bound.
	 */
	public boolean withinRectangleRight(Rectangle bound)
	{
		// Return whether right side is to the left of right bound
		return this.getX() + this.getWidth() < bound.getX() + bound.getWidth();
	}
}
