package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.lang.Math;

/**
 * Class to represent a single pizza.
 * @author 872640
 */
public class Pizza 
{
    private Canvas canvas;
    private double centreX;
    private double centreY;
    private Size size;
    private Crust crustType;
    private Sauce sauce;
    private Topping toppingOne = null;
    private Topping toppingTwo = null;
    
    /**
     * Constructor for pizza.
     * @param win the window to draw the pizza on
     * @param startX the top-left x coordinate for the section of screen to draw pizza on
     * @param startY the top-left y coordinate for the section of screen to draw pizza on
     * @param siz the size of the pizza
     * @param crus the type of the crust of the pizza
     * @param sauc wether the sauce is BBQ
     */
    public Pizza(Canvas win, double startX, double startY, Size siz, Crust crus, Sauce sauc)
    {        
        canvas = win;
        centreX = startX+150;
        centreY = startY+150;
        size = siz;
        crustType = crus;
        sauce = sauc;
    }
    
    /**
     * 
     * @param toppingone Topping chosen by the User to be drawn on the Pizza
     */
    public Pizza(Canvas win, double startX, double startY, Size siz, Crust crus, Sauce sauc, Topping toppingone)
    {        
        canvas = win;
        centreX = startX + 150;
        centreY = startY + 150;
        size = siz;
        crustType = crus;
        sauce = sauc;
        toppingOne = toppingone;
    }
    
    /**
     * 
     * @param toppingone First Topping chosen by the User to be drawn on the Pizza
     * @param toppingtwo Second Topping chosen by the User to be drawn on the Pizza
     */
    public Pizza(Canvas win, double startX, double startY, Size siz, Crust crus, Sauce sauc, Topping toppingone, Topping toppingtwo)
    {        
        canvas = win;
        centreX = startX+150;
        centreY = startY+150;
        size = siz;
        crustType = crus;
        sauce = sauc;
        toppingOne = toppingone;
        toppingTwo = toppingtwo;
    }
    
    /**
     * Method to calculate and return a double containing the price of the Pizza
     * @return The price of the Pizza
     */
    public double getPizzaPrice()
    {
        double totPrice = totPrice = this.crustType.getPrice() * Math.PI * Math.pow(this.size.getRadius(), 2) + this.sauce.getPrice();
        if(toppingOne != null)
            totPrice += 5*toppingOne.getPrice();
            if(toppingTwo != null)
                totPrice += 4*toppingTwo.getPrice();
        return totPrice;
    }
    
    /**
     * Method to get the X of the Pizza Centre
     * @return the centre X of the Pizza
     */
    public double getX()
    {
        return centreX;
    }
    
    /**
     * Method to change the X of the Pizza Centre
     */
    public void setX(int newX)
    {
        this.centreX = newX+150;
    }
    
    /**
     * Method to get the Y of the Pizza Centre
     * @return the centre Y of the Pizza 
     */
    public double getY()
    {
        return centreY;
    }
    
    /**
     * Method to change the X of the Pizza Centre
     */
    public void setY(int newY)
    {
        this.centreY = newY+150;
    }
    
    /**
     * Method to return the size of the pizza
     * @return size
     */
    public String getSize()
    {
        return size.getSizeName();
    }
    
    /**
     * Method to update the Size of the Pizza
     * @param newSize user's new Input
     */
    public void setSize(Size newSize)
    {
        this.size = newSize;
    }
    
    /**
     * Method to return the type of the pizza
     * @return CrustType
     */
    public String getCrustType()
    {
        return crustType.getCrustName();
    }
    
    /**
     * Method to update the Crust of the Pizza
     * @param newCrust user's new Input
     */
    public void setCrustType(Crust newCrust)
    {
        this.crustType = newCrust;
    }
    
    /**
     * Method to return the sauce of the pizza
     * @return sauce
     */
    public String getSauce()
    {
        return sauce.getSauceName();
    }
    
    /**
     * Method to update the Sauce of the Pizza
     * @param newSauce user's new Input
     */
    public void setSauce(Sauce newSauce)
    {
        this.sauce = newSauce;
    }
    
    /**
     * Method to return the first topping of the pizza
     * @return firts topping
     */
    public Topping getToppingOne()
    {
        return toppingOne;
    }
    
    /**
     * Method to return the second topping of the pizza
     * @return second topping
     */
    public Topping getToppingTwo()
    {
        return toppingTwo;
    }
    
    /**
     * Method to update the first or second Topping of the Pizza, depending on the parametre firstSecond
     * @param newTopping user's new Input
     * @param firstSecond choose which Topping will be changed
     */
    public void setTopping(Topping newTopping, String firstSecond)
    {
        if(firstSecond == "1")
            this.toppingOne = newTopping;
        else if(firstSecond == "2")
            this.toppingTwo = newTopping;
            
    }
    
    /**
     * Method to display the pizza information on the screen.
     */
    public void displayPizza(int index)
    {
        drawPizza();
        drawTopLine(index);
        drawBottomLine();
        drawToppings();
    }
    
    /**
     * Method to display the pizza on the screen.
     */
    private void drawPizza()
    {
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(centreX, centreY, 200);
        this.crustType.drawCrust(sauce, canvas, centreX, centreY);
    }
    
    /**
     * Method to display the toppings on the screen
     */
    private void drawToppings()
    {
        if (this.toppingOne != null){
            double topLeftX = centreX - 50;
            double topLeftY = centreY - 50;
            for(int y = 0; y < 3; y++)
            {
                for(int x = 0; x < 3; x++)
                {
                    if((x%2 == 0 && y%2 == 0) || (x%2 == 1 && y%2 == 1))
                        this.toppingOne.draw(topLeftX + x*40, topLeftY + y*40); 
                    else if (this.toppingTwo != null)
                        this.toppingTwo.draw(topLeftX + x*40, topLeftY + y*40);
                }
            }
        }
    }
    
    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen. 
     * This method will display the pizza number and size at the top of the 
     * screen (once completed)
     */
    private void drawTopLine(int index)
    {
        String topLine = "Pizza " + index + " (" + getSize() + ")";
                
        double stringX = centreX-140;
        double stringY = centreY-115;
        
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(topLine, stringX, stringY);
    }
    
    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen.  
     * This method will display the type of crust and sauce ordered (once 
     * completed)
     */
    private void drawBottomLine()
    {
        String bottomLine = "Crust: " + getCrustType() + ", " + getSauce() + " Sauce";
                
        double stringX = centreX-140;
        double stringY = centreY+140;
        
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(bottomLine, stringX, stringY);
    }
    
    /**
     * Method to Print the information of a Pizza
     */
    public void printInfoPizza()
    {
        System.out.println("X: " + getX());
        System.out.println("Y: " + getY());
        System.out.println("Size: " + getSize());
        System.out.println("Crust Type: " + getCrustType());
        System.out.println("Sauce: " + getSauce());
        if(this.toppingOne != null)
            System.out.println("Topping One: " + getToppingOne().getName());
            if(this.toppingTwo != null)
                System.out.println("Topping Two: " + getToppingTwo().getName());
        System.out.print("Total Price: ");
        System.out.printf("%.2f", getPizzaPrice());
        System.out.println("");
        System.out.println("");
        
    }
}


 