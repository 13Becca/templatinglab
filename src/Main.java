import java.util.ArrayList;

public class Main {
    interface Ingredient{
        String getName();
        int getQuantity();
    }
    class SolidIngredient implements Ingredient{
        private String _ingredientName;
        private int _ingredientQuantity;
        public SolidIngredient(String name, int quantity){
            _ingredientName = name;
            _ingredientQuantity = quantity;
        }
        public String getName(){
            return _ingredientName;
        }
        public int getQuantity(){
            return _ingredientQuantity;
        }
    }
    class LiquidIngredient implements Ingredient{
        private String _ingredientName;
        private int _ingredientQuantity;
        public LiquidIngredient(String name, int quantity){
            _ingredientName = name;
            _ingredientQuantity = quantity;
        }
        public String getName(){
            return _ingredientName;
        }
        public int getQuantity(){
            return _ingredientQuantity;
        }
    }
    class Recipe<T extends Ingredient>{
        private String _recipeName;
        private String _instructions;
        private ArrayList <T> _ingredients;
        public Recipe(String name, String instructions, ArrayList<T> ingredients){
            _recipeName = name;
            _instructions = instructions;
            _ingredients = ingredients;
        }
        public void addIngredient(){

        }
    }
    public static void main(String[] args) {

    }
}