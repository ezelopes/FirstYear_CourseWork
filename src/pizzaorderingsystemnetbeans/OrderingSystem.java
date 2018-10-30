package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderingSystem 
{
    private Canvas canvas;
    private ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
    private KeyboardInput keyboardInput = new KeyboardInput();
    private GetInputs getInputs = new GetInputs();
    private int x = 0;
    private int y = 0;
    private int numPages = (int)Math.ceil(pizzaList.size()/6.0);
    
    public OrderingSystem()
    {
        canvas = new Canvas("Pizza Ordering", 900, 650);         
    }
    
    /**
     * Method to draw the default lines of the grid on the page
     */
    public void drawOrderScreen()
    {
        canvas.setForegroundColor(Color.BLACK);
        // vertical dividers
        canvas.drawLine(300, 0, 300, 600);
        canvas.drawLine(600, 0, 600, 600);
        
        // halfway divider
        canvas.drawLine(0, 300, 900, 300);
        
        // total price line
        canvas.drawLine(0, 600, 900, 600);
        canvas.setFontSize(25);
        canvas.drawString("Total Price of the Order: £0.00", 10, 640);
        
    }
    
    /**
     * Method to start asking users all the inputs needed for creating a pizza
     */
    public void startOrdering()
    {
        String answer;
        System.out.println("WELCOME TO MY ORDERING SYSTEM"); /*OVERVIEW OF THE CHOICES IN SYSTEM OUT PRINT*/
        System.out.println("YOU WILL BE ASKED FEW QUESTION REGARDING YOUR ORDER");
        System.out.println("THIS SYSTEM IS ABLE TO UNDERSTAND DIFFERENT INPUTS YOU WILL TYPE");
        System.out.println("LET'S START!");
        do{
            Pizza pizza1 = null;
            Size size = getInputs.getUserSize();
            Crust typeCrust = getInputs.getUserCrust();
            Sauce sauce = getInputs.getUserSauce();
            String amountToppings = getInputs.getUserAmountTopping();
            
            switch (amountToppings) {
                case "0":
                    pizza1 = new Pizza(canvas, x, y, size, typeCrust, sauce); 
                    pizzaList.add(pizza1);
                    break;
                case "1":
                    Topping toppingOne = getInputs.getUserTopping(canvas, x, y);
                    pizza1 = new Pizza(canvas, x, y, size, typeCrust, sauce, toppingOne);
                    pizzaList.add(pizza1);
                    break;
                case "2":
                    Topping toppingOneTwo = getInputs.getUserTopping(canvas, x, y);
                    Topping toppingTwoTwo = getInputs.getUserTopping(canvas, x, y);
                    pizza1 = new Pizza(canvas, x, y, size, typeCrust, sauce, toppingOneTwo, toppingTwoTwo);
                    pizzaList.add(pizza1);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            
            numPages = (int)Math.ceil(pizzaList.size()/6.0);
            reDrawPizzas(numPages-1);
            drawTotPrice();
            System.out.println("Would you like to order another pizza? (YES / Any Other Button): ");
            answer = keyboardInput.getInputString().toUpperCase();
            increaseXY();
        }
        while(answer.equals("Y") || answer.equals("YES"));
        
        editListPizza();
    }
    
    /**
     * Method to edit the order that the user has just done
     */
    public void editListPizza()
    {
        //changePage(); //return to first
        String answer = "";
        boolean quit = false;
        do
        {
            System.out.println("PLEASE CHOOSE FROM THE FOLLOWING MENU");
            System.out.println("1. Edit a Pizza");
            System.out.println("2. Delete a Pizza");
            System.out.println("3. Print Information of a Pizza");
            System.out.println("4. Navigate the pages");
            System.out.println("Any other button to finish the Order");
            answer = keyboardInput.getInputString().toUpperCase();
            
            switch(answer)
            {
                case "1":
                    editPizza();
                    reDrawPizzas(0);
                    break;
                case "2":
                    pizzaList.remove(getInputs.selectPizzaByIndex(pizzaList));
                    numPages = (int)Math.ceil(pizzaList.size()/6.0);
                    reDrawPizzas(0);
                    break;
                case "3":
                    pizzaList.get(getInputs.selectPizzaByIndex(pizzaList)).printInfoPizza();
                    break;
                case "4": 
                    int numPage = getInputs.selectPage(numPages);
                    reDrawPizzas(numPage);
                    break;
                case "5": 
                    break;
                default:
                    quit = true;
                    break;
            }
            
        }while(!quit); //FIX IT
        System.out.println("THANK YOU FOR ORDERING WITH THIS SYSTEM! PIZZAS WILL BE DELIVERED SOON");
        System.out.println("ANY OTHER INPUT WILL NOT BE CONSIDERED");
    }
    
    /**
     * Method to increase X and Y in order to draw Pizzas in the correct place
     */
    public void increaseXY()
    {
        if(x < 600)
            x += 300;
        else if(y == 0)
        {
            x = 0;
            y = 300;
        }
        else /*CREATE NEW PAGE*/
        {
            x = 0;
            y = 0;
            drawOrderScreen();
            drawTotPrice();
        }
    }
    
    
    /**
     * Method to display the total price that the user would pay for the order
     */
    public void drawTotPrice()
    {
        double totPrice = 0;
        for(Pizza p1: pizzaList)
        {
            totPrice += p1.getPizzaPrice();
        } 
        DecimalFormat value = new DecimalFormat("#.##"); //FORMATTING THE TOTAL PRICE
        canvas.setForegroundColor(Color.WHITE); //ERASE STRING DOES NOT WORK
        canvas.fillRectangle(0, 605, 900, 50);
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(25);
        canvas.drawString("Total Price of the Order: £" + value.format(totPrice), 10, 640);
    }
    
    /**
     * Method to clean the screen and redraw in a given page all the pizzas after editing
     * @param numPage define what page (so what pizzas) will be drawn
     */
    public void reDrawPizzas(int numPage)
    {
        numPage *= 6;
        canvas.erase();
        drawOrderScreen();
        drawTotPrice();
        x = 0;
        y = 0;
        for(Pizza p1: pizzaList)
        {
            p1.setX(x);
            p1.setY(y);
            //CHECK WETHER THE CURRENT PIZZA IS BETWEEN 0-5 OR 6-11 OR 12-17 ETC.
            if(pizzaList.indexOf(p1) >= numPage && pizzaList.indexOf(p1) < numPage+6)
                p1.displayPizza(pizzaList.indexOf(p1) + 1);
            increaseXY();
        } 
    }
    
    /**
     * Method to Edit a specific Pizza
     */
    public void editPizza()
    {        
        int selectedIndex = getInputs.selectPizzaByIndex(pizzaList);
        pizzaList.get(selectedIndex).setSize(getInputs.getUserSize());
        pizzaList.get(selectedIndex).setCrustType(getInputs.getUserCrust());
        pizzaList.get(selectedIndex).setSauce(getInputs.getUserSauce());
        String amountToppings = getInputs.getUserAmountTopping();
        switch(amountToppings)
        {
            //DELETE PREVIOUS TOPPING
            case "0":
                pizzaList.get(selectedIndex).setTopping(null, "1");
                pizzaList.get(selectedIndex).setTopping(null, "2");
                break;
            //DELETE PREVIOUS SECOND TOPPING AND SET/ADD THE NEW FIRST TOPPING
            case "1":
                pizzaList.get(selectedIndex).setTopping(getInputs.getUserTopping(canvas, x, y), "1");
                pizzaList.get(selectedIndex).setTopping(null, "2");
                break;
            //SET/ADD THE NEW TOPPINGS
            case "2":
                pizzaList.get(selectedIndex).setTopping(getInputs.getUserTopping(canvas, x, y), "1");
                pizzaList.get(selectedIndex).setTopping(getInputs.getUserTopping(canvas, x, y), "2");
                break;
        }
    }
    
    
    /**
     * Method to run a Simulation, default pizzas have been added to the list
     */
    public void runSimulation()
    {
        Topping t1;
        Topping t2;
        Pizza p1;
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        t2 = new ToppingPrawn(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1, t2);
        pizzaList.add(p1);
        increaseXY();
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        t2 = new ToppingPrawn(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1, t2);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        t2 = new ToppingPrawn(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1, t2);
        pizzaList.add(p1);
        increaseXY();
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        t2 = new ToppingPrawn(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1, t2);
        pizzaList.add(p1);
        increaseXY();
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        t2 = new ToppingPrawn(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1, t2);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        t2 = new ToppingPrawn(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1, t2);
        pizzaList.add(p1);
        increaseXY();
        t1 = new ToppingPineapple(canvas, x, y);
        t2 = new ToppingPrawn(canvas, x, y);
        p1 = new Pizza(canvas, x, y, Size.MEDIUM, Crust.DEEPPAN, Sauce.TOMATO, t1, t2);
        pizzaList.add(p1);
        increaseXY();
        
        numPages = (int)Math.ceil(pizzaList.size()/6.0);
        reDrawPizzas(numPages-1);
        editListPizza();
    }
}
