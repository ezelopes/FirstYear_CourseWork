/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

/**
 * Enum to create a Pizza Sauce
 * @author 872640
 */
public enum Sauce {
    /**
     * TOMATO Sauce
     */
    TOMATO("Tomato", 0),
    /**
     * BBQ Sauce
     */
    BBQ("BBQ", 0.5);
    
    private String name;
    private double price;
    
    /**
     * Create a Sauce
     * @param nam name of the chosen Sauce type
     * @param pric price of the chosen Sauce
     */
    Sauce(String nam, double pric){
        this.name = nam;
        this.price = pric;
    }
    
    /**
     * Method to return a String containing the name of the Sauce
     * @return name of the Sauce (Tomato, BBQ)
     */
    public String getSauceName()
    { 
        return name;
    }
    
    /**
     * Method to return a double containing the price of the Sauce
     * @return price of the Sauce (0 for Tomato, 0.5 for BBQ)
     */
    public double getPrice()
    { 
        return price; 
    }
}
