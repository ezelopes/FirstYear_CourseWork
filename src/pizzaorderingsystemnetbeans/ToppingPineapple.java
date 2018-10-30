/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.awt.*;

/**
 * SubClass of Topping to create Pineapple Toppings
 * @author 872640
 */
public class ToppingPineapple extends Topping {
    /**
     * @see superClass Topping(String nam, double pric, Color colour, Canvas win, double x, double y)
     * default name (Pineapple), price (0.06) and colour (Yellow)
     * @param win the window where the topping will be drawn
     * @param x specifies where to draw the topping
     * @param y specifies where to draw the topping
     */
    public ToppingPineapple(Canvas win, double x, double y)
    {
        super("Pineapple", 0.06, Color.YELLOW, win, x, y);
    }
    
   
    @Override
    /**
     * Method to draw Pineapples on a defined Pizza
     */
    public void draw(double centreX, double centreY)
    {
        for (int i = 0; i < 10; i+=2) 
        {
            if((i/2)%2 == 0)
                window.setForegroundColor(Color.YELLOW);
            else
                window.setForegroundColor(Color.WHITE);
            window.fillPolygon(new double[]{centreX+0+i, centreX+25-i, centreX+22-i, centreX+3+i}, new double[]{centreY+0+i, centreY+0+i, centreY+25-i, centreY+25-i});
        }
    }
}
