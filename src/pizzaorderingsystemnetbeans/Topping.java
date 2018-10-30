/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.awt.*;

/**
 * Super Class to create a Topping
 * @author 872640
 */
public class Topping {
    
    protected String name;
    protected double price;
    protected Canvas window;
    protected double startX;
    protected double startY;
    protected Color col;
    
    /**
     * Create a Topping
     * @param nam the name of the topping
     * @param pric the price of the topping
     * @param colour the colour of the topping
     * @param win the window where the topping will be drawn
     * @param x specifies where to draw the topping
     * @param y specifies where to draw the topping
     */
    public Topping(String nam, double pric, Color colour, Canvas win, double x, double y)
    {
        name = nam;
        price = pric;
        col = colour;
        window = win;
        startX = x;
        startY = y;
    }
    
    /**
     * Method to return a String containing the name of the Topping
     * @return name of the Topping
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to return a double containing the price of the Topping
     * @return price of the Topping
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Draw topping getting the X and the Y of the related Pizza
     * @param centreX X related to the specific Pizza
     * @param centreY Y related to the specific Pizza
     */
    public void draw(double centreX, double centreY){};
    
}
