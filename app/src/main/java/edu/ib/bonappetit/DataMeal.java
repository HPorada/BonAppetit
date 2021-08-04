package edu.ib.bonappetit;

import java.util.ArrayList;

/**
 * DataMeal class definition
 */

public class DataMeal {
    private ArrayList<Meal> meals;

    /**
     * Method getMeals - gets list of Meals
     *
     * @return ArrayList of Meal objects
     */
    public ArrayList<Meal> getMeals() {
        return meals;
    }

    /**
     * Method setMeals - sets list of Meals
     *
     * @param meals ArrayList of Meal objects
     */
    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
