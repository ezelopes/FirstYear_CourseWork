/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 * SubClass of Topping to create Prawn Toppings
 * @author 872640
 */
public class ToppingPrawn extends Topping{
    /**
     * @see superClass Topping(String nam, double pric, Color colour, Canvas win, double x, double y)
     * default name (Prawn), price (0.06) and colour (Pink)
     * @param win the window where the topping will be drawn
     * @param x specifies where to draw the topping
     * @param y specifies where to draw the topping
     */
    public ToppingPrawn(Canvas w, double x, double y)
    {
        super("Prawn", 0.06, Color.PINK, w, x, y);
    }
    
    
    @Override
    /**
     * Method to draw Prawns on a defined Pizza
     */
     public void draw(double centreX, double centreY)
    {
        window.setForegroundColor(Color.PINK);
        window.fillCircle(centreX+7.5, centreY+4.5, 15);
        window.setForegroundColor(Color.PINK);
        window.fillPolygon(new double[]{centreX+10, centreX+25, centreX+22, centreX+3, centreX+18, centreX+20, centreX+10}, new double[]{centreY-3, centreY+7, centreY+22, centreY+25, centreY+19, centreY+12, centreY+7});
    }
}
