
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Max Roe
 * @version 04/12/2020
 */
public class StockApp
{
    public static final char CLEAR_CODE = '\u000c';
    public static final String QUIT = "quit";
    public static final String ADD = "add";
    public static final String PRINT_ALL = "printall";
    public static final String SEARCH = "search";
    public static final String SELL = "sell";
    public static final String DELIVER = "deliver";
    public static final String STOCK = "stock";
    public static final String REMOVE = "remove";
    // Use to get user input
    private InputReader input = new InputReader();
    
    private StockManager manager = new StockManager();
    
    private StockDemo demo = new StockDemo(manager);
    
    
    /**
     * This line of code runs the program.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = input.getString().toLowerCase();
            if(choice.equals(QUIT))
                finished = true;
            else    
                executeMenuChoice(choice);
        }
    }
    
    /**
     * This will run all the functions by typing the work.
     */
    private void executeMenuChoice(String choice)
    {
        if(choice.equals(ADD))
        {
            addProduct();
        }
        else if(choice.equals(PRINT_ALL))
        {
            manager.printAllProducts();
            String value = input.getString();
        }
        else if(choice.equals(SEARCH))
        {
            searchProduct();
        }
        else if(choice.equals(SELL))
        {
            sellProduct();
        }
        else if (choice.equals(DELIVER))
        {
            deliverProduct();
        }
        else if (choice.equals(STOCK))
        {
            lowStock();
        }
        else if (choice.equals(REMOVE))
        {
            remove();
        }
    }
    
    /**
     * Code to add a product.
     */
    private void addProduct()
    {
        System.out.println("Adding new product\n");
        
        System.out.println("Please enter the product ID");
        String value = input.getString();
        int id = Integer.parseInt(value);
        
        System.out.println("Please enter the name of the product");
        String name = input.getString();
        
        Product product = new Product(id, name);
        manager.addProduct(product);
        
        System.out.println("\n You have added the following product" + product);
        System.out.println();
    }
    
    /**
     * This will search for a product by specific word 
     * from the name of the product.
     */
    public void searchProduct()
    {
        System.out.println("Search for a product by name\n");
        
        System.out.println("Please enter the name of the product\n");
        String word = input.getString();
        
        manager.searchProduct(word);
    }
    
    /**
     * Code to sell a product.
     */
    public void sellProduct()
    {
        System.out.println("Sell a product\n");
           
        System.out.println("Please enter the product's ID");
        String value = input.getString();
        int id = Integer.parseInt(value);
        
        System.out.println("Enter the amount you would like to sell");
        String number = input.getString();
        int amount = Integer.parseInt(number);
        
        manager.sellProduct(id, amount);
    }
    
    /**
     * Code to deliver a product.
     */
    public void deliverProduct()
    {
        System.out.println("Deliver a product\n");
        
        System.out.println("Enter the product ID");
        String value = input.getString();
        int id = Integer.parseInt(value);
        
        System.out.println("Enter the amount you would like to deliver");
        String number = input.getString();
        int amount = Integer.parseInt(number);
        
        manager.deliverProduct(id, amount);
    }
    
    /**
     * A code to show all the stock that is low.
     */
    public void lowStock()
    {       
        manager.printLowStock();
    }
    
    /**
     * A code to remove a product
     */
    public void remove()
    {
        System.out.println("Remove Product...\n");

        System.out.println("Enter product ID");
        String value = input.getString();
        int id = Integer.parseInt(value);

        manager.removeProduct(id);
    }
    
    /**
     * Print out a menu of operation choices.
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Sell:       Sell a product");
        System.out.println("    Search:     Search for a product");
        System.out.println("    Deliver:    Deliver a product");
        System.out.println("    Remove:     Remove a product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name.
     */
    private void printHeading()
    {
        //System.out.println(CLEAR_CODE);
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("      App05: by Max Roe");
        System.out.println("******************************");
    }
    
}
