package edu.ib.bonappetit;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Meal class definition
 */

public class Meal implements Serializable, Comparable<Meal> {

    private String idMeal;
    private String strMeal;
    private String strDrinkAlternate;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;

    //Ingredients - maximum number of ingredients provided by API is 20
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strIngredient16;
    private String strIngredient17;
    private String strIngredient18;
    private String strIngredient19;
    private String strIngredient20;

    //Measures for Ingredients
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;

    private String strSource;
    private String dateModified;

    /**
     * Meal constructor without parameters
     */
    public Meal() {
    }

    /**
     * Meal constructor with parameters
     *
     * @param idMeal
     * @param strMeal
     * @param strDrinkAlternate
     * @param strCategory
     * @param strArea
     * @param strInstructions
     * @param strMealThumb
     * @param strTags
     * @param strYoutube
     * @param strIngredient1
     * @param strIngredient2
     * @param strIngredient3
     * @param strIngredient4
     * @param strIngredient5
     * @param strIngredient6
     * @param strIngredient7
     * @param strIngredient8
     * @param strIngredient9
     * @param strIngredient10
     * @param strIngredient11
     * @param strIngredient12
     * @param strIngredient13
     * @param strIngredient14
     * @param strIngredient15
     * @param strIngredient16
     * @param strIngredient17
     * @param strIngredient18
     * @param strIngredient19
     * @param strIngredient20
     * @param strMeasure1
     * @param strMeasure2
     * @param strMeasure3
     * @param strMeasure4
     * @param strMeasure5
     * @param strMeasure6
     * @param strMeasure7
     * @param strMeasure8
     * @param strMeasure9
     * @param strMeasure10
     * @param strMeasure11
     * @param strMeasure12
     * @param strMeasure13
     * @param strMeasure14
     * @param strMeasure15
     * @param strMeasure16
     * @param strMeasure17
     * @param strMeasure18
     * @param strMeasure19
     * @param strMeasure20
     * @param strSource
     * @param dateModified
     */
    public Meal(String idMeal, String strMeal, String strDrinkAlternate, String strCategory, String strArea, String strInstructions, String strMealThumb, String strTags, String strYoutube, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strIngredient16, String strIngredient17, String strIngredient18, String strIngredient19, String strIngredient20, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16, String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20, String strSource, String dateModified) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strIngredient16 = strIngredient16;
        this.strIngredient17 = strIngredient17;
        this.strIngredient18 = strIngredient18;
        this.strIngredient19 = strIngredient19;
        this.strIngredient20 = strIngredient20;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strMeasure16 = strMeasure16;
        this.strMeasure17 = strMeasure17;
        this.strMeasure18 = strMeasure18;
        this.strMeasure19 = strMeasure19;
        this.strMeasure20 = strMeasure20;
        this.strSource = strSource;
        this.dateModified = dateModified;
    }

    /**
     * Method getStrMeal - gets the strMeal (name of the recipe) parameter of Meal
     *
     * @return strMeal as String
     */
    public String getStrMeal() {
        return strMeal;
    }

    /**
     * Method getStrMealThumb - gets the strMealThumb (url to the image of meal) parameter of Meal
     *
     * @return strMealThumb as String
     */
    public String getStrMealThumb() {
        return strMealThumb;
    }

    /**
     * Overriden method toString
     *
     * @return String with ingredients, measures and instruction of Meal
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Ingredients: \n");

        if (strIngredient1 != null && !strIngredient1.isEmpty()) {
            str.append("\t - \t").append(strIngredient1).append(", ").append(strMeasure1).append("\n");
        }
        if (strIngredient2 != null && !strIngredient2.isEmpty()) {
            str.append("\t - \t").append(strIngredient2).append(", ").append(strMeasure2).append("\n");
        }
        if (strIngredient3 != null && !strIngredient3.isEmpty()) {
            str.append("\t - \t").append(strIngredient3).append(", ").append(strMeasure3).append("\n");
        }
        if (strIngredient4 != null && !strIngredient4.isEmpty()) {
            str.append("\t - \t").append(strIngredient4).append(", ").append(strMeasure4).append("\n");
        }
        if (strIngredient5 != null && !strIngredient5.isEmpty()) {
            str.append("\t - \t").append(strIngredient5).append(", ").append(strMeasure5).append("\n");
        }
        if (strIngredient6 != null && !strIngredient6.isEmpty()) {
            str.append("\t - \t").append(strIngredient6).append(", ").append(strMeasure6).append("\n");
        }
        if (strIngredient7 != null && !strIngredient7.isEmpty()) {
            str.append("\t - \t").append(strIngredient7).append(", ").append(strMeasure7).append("\n");
        }
        if (strIngredient8 != null && !strIngredient8.isEmpty()) {
            str.append("\t - \t").append(strIngredient8).append(", ").append(strMeasure8).append("\n");
        }
        if (strIngredient9 != null && !strIngredient9.isEmpty()) {
            str.append("\t - \t").append(strIngredient9).append(", ").append(strMeasure9).append("\n");
        }
        if (strIngredient10 != null && !strIngredient10.isEmpty()) {
            str.append("\t - \t").append(strIngredient10).append(", ").append(strMeasure10).append("\n");
        }
        if (strIngredient11 != null && !strIngredient11.isEmpty()) {
            str.append("\t - \t").append(strIngredient11).append(", ").append(strMeasure11).append("\n");
        }
        if (strIngredient12 != null && !strIngredient12.isEmpty()) {
            str.append("\t - \t").append(strIngredient12).append(", ").append(strMeasure12).append("\n");
        }
        if (strIngredient13 != null && !strIngredient13.isEmpty()) {
            str.append("\t - \t").append(strIngredient13).append(", ").append(strMeasure13).append("\n");
        }
        if (strIngredient14 != null && !strIngredient14.isEmpty()) {
            str.append("\t - \t").append(strIngredient14).append(", ").append(strMeasure14).append("\n");
        }
        if (strIngredient15 != null && !strIngredient15.isEmpty()) {
            str.append("\t - \t").append(strIngredient15).append(", ").append(strMeasure15).append("\n");
        }
        if (strIngredient16 != null && !strIngredient16.isEmpty()) {
            str.append("\t - \t").append(strIngredient16).append(", ").append(strMeasure16).append("\n");
        }
        if (strIngredient17 != null && !strIngredient17.isEmpty()) {
            str.append("\t - \t").append(strIngredient17).append(", ").append(strMeasure17).append("\n");
        }
        if (strIngredient18 != null && !strIngredient18.isEmpty()) {
            str.append("\t - \t").append(strIngredient18).append(", ").append(strMeasure18).append("\n");
        }
        if (strIngredient19 != null && !strIngredient19.isEmpty()) {
            str.append("\t - \t").append(strIngredient19).append(", ").append(strMeasure19).append("\n");
        }
        if (strIngredient20 != null && !strIngredient20.isEmpty()) {
            str.append("\t - \t").append(strIngredient20).append(", ").append(strMeasure20).append("\n");
        }

        str.append("\n");
        str.append("Instructions: \n");
        str.append(strInstructions);

        return str.toString();
    }

    /**
     * Overriden meathod compareTo
     *
     * @param o Meal object
     * @return -1, 0 or 1, depending on the result of comparison
     */
    @Override
    public int compareTo(Meal o) {
        int name = this.strMeal.compareTo(o.strMeal);
        return name == 0 ? this.strMeal.compareTo(o.strMeal) : name;
    }
}
