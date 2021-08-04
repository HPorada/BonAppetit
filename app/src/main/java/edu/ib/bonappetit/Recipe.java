package edu.ib.bonappetit;

import java.io.Serializable;

/**
 * Recipe class definition
 */

public class Recipe implements Serializable, Comparable<Recipe> {

    private String name;
    private String body;

    /**
     * Recipe constructor without parameters
     */
    public Recipe() {
    }

    /**
     * Recipe constructor with paramters
     *
     * @param name name of the recipe
     * @param body body of the recipe (ingredients, measures, instructions)
     */
    public Recipe(String name, String body) {
        this.name = name;
        this.body = body;
    }

    /**
     * Method getName - gets name of the Recipe
     *
     * @return name of the Recipe as String
     */
    public String getName() {
        return name;
    }

    /**
     * Method getBody - gets body of the Recipe
     *
     * @return body of the Recipe as String
     */
    public String getBody() {
        return body;
    }

    /**
     * Overriden method compareTo
     *
     * @param o Recipe object
     * @return -1, 0 or 1, depending on the result of comparison
     */
    @Override
    public int compareTo(Recipe o) {
        int name = this.name.compareTo(o.name);
        return name == 0 ? this.name.compareTo(o.name) : name;
    }
}
