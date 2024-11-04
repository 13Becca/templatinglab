import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _ingredientName;
    private double _ingredientQuantity;
    public SolidIngredient(String name, double quantity){
        _ingredientName = name;
        _ingredientQuantity = quantity;
    }
    public String getName(){
        return _ingredientName;
    }
    public double getQuantity(){
        return _ingredientQuantity;
    }
}
class LiquidIngredient implements Ingredient{
    private String _ingredientName;
    private double _ingredientQuantity;
    public LiquidIngredient(String name, double quantity){
        _ingredientName = name;
        _ingredientQuantity = quantity;
    }
    public String getName(){
        return _ingredientName;
    }
    public double getQuantity(){
        return _ingredientQuantity;
    }
}
//    extends and not implements
//    class Recipe is not implementing the INgredient interface, rather, the extends word indicates a
//    constraint for the type variable/ parameter
class Recipe<T extends Ingredient>{
    private String _recipeName;
    private String _instructions;
    private ArrayList <T> _ingredients;

    //      would not pass in array list here because then you have an aggregation relationship
//      where someone else owns the ingredients
    public Recipe(String name, String instructions){
        _recipeName = name;
        _instructions = instructions;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T ingredient){
        _ingredients.add(ingredient);
    }
    public void print(){
        System.out.println("Recipe Name: " + _recipeName);
        System.out.println("Instruction: " + _instructions);
        System.out.println("Ingredients:");
        for (Ingredient ingredient: _ingredients){
            System.out.println("-" + ingredient.getName() + "---->" + ingredient.getQuantity());
        }
    }
}

public class Main {
    public static String enterRecipeInstructions(Scanner scan){
        System.out.println("Enter Recipe Instructions");
        String instructions = scan.nextLine();
        return instructions;
    }
    public static String enterRecipeName(Scanner scan){
        System.out.println("Enter Recipe Name");
        String name = scan.nextLine();
        return name;
    }
//        inclass example for addIngredient method
//    cant call any function at null string, so null string, try catch would catch that, add in after
    public static void addIngredient(Recipe<Ingredient>recipe, Scanner scan) {
        System.out.println("is it solid or liquid?");
//            if hit enter with null string, runtime error calling null string, so try catch would catch
        char type = scan.nextLine().charAt(0);
        System.out.println("Enter ingredient name");
        String name = scan.nextLine();
        System.out.println("enter the quantity");
//            could get runtime below if not valid double 50.505.50, or not a double so try catch would
//            help
        double quantity = Double.parseDouble(scan.nextLine());
//            creating interface variable that is okay, to create a variable whos data type is interface
//            but cannot instantiate the two things, data type is interface, it will point to either solid
//            or liquid ingredient
        Ingredient ingredient;
        if (type == 's')
            ingredient = new SolidIngredient(name, quantity);
        else
            ingredient = new LiquidIngredient(name, quantity);
        recipe.addIngredient(ingredient);
    }

    public static void displayMenu() {
        System.out.println("Pick an Option");
        System.out.println("1. Add Ingredient\n2. Print List of Ingredients\n3. Quit");

    }

    public static int pickOption(){
        Scanner scan = new Scanner(System.in);
        displayMenu();
        int option = 0;
        try{
            option = Integer.valueOf(scan.nextLine());
        } catch (NumberFormatException e){
            System.out.println("invalid entry" + e.getMessage());
        }
        return option;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String recipeName = enterRecipeName(scan);
        String recipeInstructions = enterRecipeInstructions(scan);
        Recipe recipe = new Recipe<Ingredient>(recipeName, recipeInstructions);
        int option = pickOption();
        while (option !=3){
            if (option == 1){
                addIngredient(recipe, scan);
                option = pickOption();
            } else if (option == 2) {
                recipe.print();
                option = pickOption();
            }
        }
    }
}