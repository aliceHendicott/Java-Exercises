package patt.Coffee;

import java.util.ArrayList;

public class Coffee {
    CoffeeFactory.Type type;
    double cost;
    ArrayList<CoffeeFactory.Ingredient> ingredients;

    public Coffee(ArrayList<CoffeeFactory.Ingredient> ingredients, CoffeeFactory.Type type) {
        this.type = type;

        this.ingredients = ingredients;

        double sum = 0;
        for (CoffeeFactory.Ingredient ingredient : ingredients) {
            if (ingredient == CoffeeFactory.Ingredient.ESPRESSO) {
                sum += CoffeeFactory.Ingredient.ESPRESSO.getCost();
            } else if (ingredient == CoffeeFactory.Ingredient.MILK) {
                sum += CoffeeFactory.Ingredient.MILK.getCost();
            } else if (ingredient == CoffeeFactory.Ingredient.CHOCOLATE) {
                sum += CoffeeFactory.Ingredient.CHOCOLATE.getCost();
            } else {
                sum += 0;
            }
        }
        this.cost = sum;

    }

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        if (this.type.equals(CoffeeFactory.Type.LONG_BLACK)) {
            return CoffeeFactory.Type.LONG_BLACK.getPrice();
        } else if (this.type.equals(CoffeeFactory.Type.FLAT_WHITE)) {
            return CoffeeFactory.Type.FLAT_WHITE.getPrice();
        } else if (this.type.equals(CoffeeFactory.Type.MOCHA)) {
            return CoffeeFactory.Type.MOCHA.getPrice();
        }
        return 0;
    }

    public String listIngredients() {
        String string = "";
        for (CoffeeFactory.Ingredient ingredient : ingredients) {
            string += ingredient.toString();
            string += "\n";
        }
        return string;
    }
}