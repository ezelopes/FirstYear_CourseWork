/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author up872640
 */
public class GetInputs {
    
    private KeyboardInput keyboardInput;
    private ArrayList<String> questions;
    private String[][] answers;
    
    /**
     * Create a GetInputs with default Questions and Answers
     */
    public GetInputs()
    {
        keyboardInput = new KeyboardInput();
        questions = new ArrayList<>(Arrays.asList(new String[]
        {
            "Insert the size of the pizza (Small = 1, Medium = 2, Large = 3): ",
            "Insert the type of the crust (Deep Pan = 1, Thin Crust = 2, Stuffed Crust = 3): ",
            "Would you like BBQ Sauce? (Y/N): ",
            "How many toppings would you like? (0, 1, 2): ",
            "What toppings would you like? (Pineapple = 1, Prawn = 2): "
        }
        ));
        answers = new String[][]
        {
            {"1", "2", "3", "SMALL", "MEDIUM", "LARGE", "S", "M", "L"},
            {"1", "2", "3", "DEEP PAN", "THIN CRUST", "STUFFED CRUST", "D", "T", "S"},
            {"Y", "N", "YES", "NO"},
            {"0", "1", "2"},
            {"1", "2", "PI", "PR", "PINEAPPLE", "PRAWN"}
        };
    }
    
    /**
     * Method to return a String containing a Size chosen by the user, after it has been checked 
     * @return Size that correspond to the User's Input
     */
    public Size getUserSize()
    {
        Size sizePizza = null;
        switch(checkAnswer(0))
        {
            case "1":
            case "S":
            case "SMALL":
                sizePizza = Size.SMALL;
                break;
            case "2":
            case "M":
            case "MEDIUM":
                sizePizza = Size.MEDIUM;
                break;
            case "3":
            case "L":
            case "LARGE":
                sizePizza = Size.LARGE;
                break;
        }  
        return sizePizza;
    }
    
    /**
     * Method to return a String containing a Crust chosen by the user, after it has been checked 
     * @return Crust that correspond to the User's Input
     */
    public Crust getUserCrust()
    {
        Crust crustPizza = null;
        switch(checkAnswer(1))
        {
            case "1":
            case "D":
            case "DEEP PAN":
                crustPizza = Crust.DEEPPAN;
                break;
            case "2":
            case "T":
            case "THIN CRUST":
                crustPizza = Crust.THINCRUST;
                break;
            case "3":
            case "S":
            case "STUFFED CRUST":
                crustPizza = Crust.STUFFEDCRUST;
                break;
            //DO NOT NEED DEFAULT
        } 
        return crustPizza;
    }
    
    /**
     * Method to return a String containing a Sauce chosen by the user, after it has been checked 
     * @return Sauce that correspond to the User's Input
     */
    public Sauce getUserSauce()
    {
        Sauce saucePizza = null;
        switch(checkAnswer(2))
        {
            case "Y":
            case "YES":
                saucePizza = Sauce.BBQ;
                break;
            case "N":
            case "NO":
                saucePizza = Sauce.TOMATO;
                break;
            //DO NOT NEED DEFAULT
        }
        return saucePizza;
    }
    
    /**
     * Method to return a String containing the Amount of Toppings chosen by the user, after it has been checked 
     * @return Amount of Toppings after it has been checked
     */
    public String getUserAmountTopping()
    {
        String amount = checkAnswer(3);
        return amount;
    }
    
    /**
     * Method to return a Topping containing a Prawn or a Pineapple depending on the choice made by the user, after it has been checked 
     * @return Topping that correspond to the User's Input
     */
    public Topping getUserTopping(Canvas canvas, int x, int y)
    {
        Topping topping = null;
        switch(checkAnswer(4))
        {
            case "1":
            case "PI":
            case "PINEAPPLE":
                topping = new ToppingPineapple(canvas, x, y);
                break;
            case "2":
            case "PR":
            case "PRAWN":
                topping = new ToppingPrawn(canvas, x, y);
                break;
        }
        return topping;
    }
    
    /**
     * Method to check the input given by the user. It checks wether the input is contained in the answer list, knowing the question. If it is not valid, feedback is prompted
     * @param index Question and Answer Lists have the same index. Index specifies what list to be checked
     * @return a String containing the user's input
     */
    public String checkAnswer(int index)
    {
        boolean correct = false;
        String answer = null;
        do{
            System.out.println(questions.get(index));
            answer = keyboardInput.getInputString().toUpperCase();
            for(int i = 0; i < answers[index].length; i++)
            {
                if(answers[index][i].equals(answer))
                {
                    correct = true;
                    break;
                }
            }
            if(!correct)
                System.out.println("Invalid Input! Please select from the menu given");  
        }while(!correct);
        return answer;
    }
    
    /**
     * Method that check wether the Pizza index is between 1 and the ArrayList max length
     * @return index of the Pizza selected
     */
    public int selectPizzaByIndex(ArrayList<Pizza> pizzaList)
    {
        int index = -1;
        do{
            System.out.println("Insert the desired index of the Pizza (1 to " + pizzaList.size() + "): ");
            index = keyboardInput.getInputInteger();
            if(index < 1 || index > pizzaList.size())
                System.out.println("Index must be greater than zero and less great than the max index");
        }while(index < 1 || index > pizzaList.size());
        return index-1;
    }
    
    /**
    * Method that check wether the Page index is between 1 and the max page number
    * @return number of the page after input has been checked
    */
    public int selectPage(int numPages)
    {
        int page = -1;
        do{
            System.out.println("Insert the desired index of the Pizza (1 to " + numPages + "): ");
            page = keyboardInput.getInputInteger();
            if(page < 1 || page > numPages)
                System.out.println("Index must be greater than zero and less great than the max index");
        }while(page < 1 || page > numPages);
        return page-1;
    }
}
