/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 * Enum to create Pizza Crust
 * @author 872640
 */
public enum Crust {
    /**
     * DEEPPAN Crust
     */
    DEEPPAN("Deep Pan", 0.11),
    /**
     * THINCRUST Crust
     */
    THINCRUST("Thin Crust", 0.08),
    /**
     * STUFFEDCRUST Crust
     */
    STUFFEDCRUST("Stuffed Crust", 0.14);
    
    private String name;
    private double price;
    
    /**
     * Create a Crust
     * @param nam name of the chosen crust type
     * @param pric price of the chosen crust
     */
    Crust(String nam, double pric){
        this.name = nam;
        this.price = pric;
    }
    
    /**
     * Method to return a String containing the name of the Crust
     * @return name of the Crust (Deep Pan, Thin Crust, Stuffed Crust)
     */
    public String getCrustName()
    { 
        return name;
    }
    
    /**
     * Method to return a double containing the price of the Crust
     * @return price of the Crust (0.11 for Deep Pan, 0.08 for Thin Crust, 0.14 for Stuffed Crust)
     */
    public double getPrice()
    { 
        return price;
    }
    
    /**
     * Draw a Crust and the colour depends on the Sauce
     * @param sauce Sauce of the pizza that will change the colour of it
     * @param window Canvas frame where the Crust will be drawn
     * @param X Specifies the X location of the Crust centre
     * @param Y Specifies the Y location of the Crust centre
     */
    public void drawCrust(Sauce sauce, Canvas window, double X, double Y)
    {
        if(sauce.getSauceName()== "Tomato")
            window.setForegroundColor(Color.RED);
        else
            window.setForegroundColor(Color.ORANGE);
        
        window.fillCircle(X, Y, 175);
        window.setForegroundColor(Color.WHITE);
        window.fillCircle(X, Y, 150);
        
    }
}
