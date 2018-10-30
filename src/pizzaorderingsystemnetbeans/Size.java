/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

/**
 * Enum to create Pizza Size
 * @author 872640
 */
public enum Size {
    /**
     * SMALL Size
     */
    SMALL("Small", 5),
    /**
     * MEDIUM Size
     */
    MEDIUM("Medium", 6),
    /**
     * LARGE Size
     */
    LARGE("Large", 7);
    
    private String name;
    private int radius;
    
    /**
     * Create a Size
     * @param nam name of the chosen Size type
     * @param radiu length of the chosen Size
     */
    Size(String nam, int radiu){
        this.name = nam;
        this.radius = radiu;
    }
    
    /**
     * Method to return a String containing the name of the Size
     * @return name of the Size (Small, Medium, Large)
     */
    public String getSizeName()
    { 
        return name;
    }
    
    /**
     * Method to return a int containing the length of the Size
     * @return price of the Size (5 for Small, 6 for Medium, 7 for Large)
     */
    public int getRadius()
    { 
        return radius;
    }
}
