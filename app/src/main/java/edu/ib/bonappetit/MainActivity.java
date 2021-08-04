package edu.ib.bonappetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * MainActivity class definition
 */

public class MainActivity extends AppCompatActivity {

    final static ArrayList<Meal> meals = new ArrayList<>();
    static Meal randomMeal;
    private JSONObject jObject;
    final static ArrayList<Recipe> recipes = new ArrayList<>();

    /**
     * Overriden method onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMealList();

        ImageView randomRecipeImage = (ImageView) findViewById(R.id.imgRandomMeal);
        TextView randomRecipeName = (TextView) findViewById(R.id.txtRandomName);

        String url = "https://www.themealdb.com/api/json/v1/1/random.php";

        RequestQueue queue = Volley.newRequestQueue(this);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response ->
        {
            DataMeal data = gson.fromJson(response, DataMeal.class);
            randomMeal = data.getMeals().get(0);
            randomRecipeName.setText(randomMeal.getStrMeal());
            Picasso.get()
                    .load(randomMeal.getStrMealThumb())
                    .into(randomRecipeImage);
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                randomRecipeName.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }

    /**
     * Method onImageClick - handles user's activity of clicking on the image
     * Starts MealActivity
     *
     * @param view
     */
    public void onImageClick(View view) {
        Intent intent = new Intent(this, MealActivity.class);
        intent.putExtra("MealExtra", randomMeal);
        startActivity(intent);
    }

    /**
     * Method onRandomMoreClick - handles user's activity of clicking on Check the Recipe button
     * Starts MealActivity
     *
     * @param view
     */
    public void onRandomMoreClick(View view) {
        Intent intent = new Intent(this, MealActivity.class);
        intent.putExtra("MealExtra", randomMeal);
        startActivity(intent);
    }

    /**
     * Method onAllMealsClick - handles user's activity of clicking on Show All Recipes button
     * Starts MealsRecyclerActivity
     *
     * @param view
     */
    public void onAllMealsClick(View view) {
        Intent intent = new Intent(this, MealsRecyclerActivity.class);
        startActivity(intent);
    }

    /**
     * Method onAddClick - handles user's activity of clicking Add New Recipe button
     * Starts AddActivity
     *
     * @param view
     */
    public void onAddClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    /**
     * Method onViewClick - handles user's activity of clicking Show My Recipes button
     * Starts RecipesRecyclerActivity
     *
     * @param view
     */
    public void onViewClick(View view) {
        createRecipeList();

        Intent intent = new Intent(this, RecipesRecyclerActivity.class);
        startActivity(intent);
    }

    /**
     * Method createMealList - creates full list of meals available in API (www.themealdb.com)
     */
    public void createMealList() {
        meals.clear();

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for (String s : alphabet) {
            String url = "https://www.themealdb.com/api/json/v1/1/search.php?f=" + s;

            RequestQueue queue = Volley.newRequestQueue(this);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response ->
            {
                try {
                    if (!response.equals("{\"meals\":null}")) {
                        jObject = new JSONObject(response);
                        JSONArray jsonArray = jObject.getJSONArray("meals");
                        for (int j = 0; j < jsonArray.length(); j++) {
                            JSONObject x = jsonArray.getJSONObject(j);
                            Meal meal = gson.fromJson(x.toString(), Meal.class);

                            meals.add(meal);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            );
            queue.add(stringRequest);
        }
    }

    /**
     * Method createRecipeList - create full list of recipes stored in the device's memory
     */
    public void createRecipeList() {
        recipes.clear();
        File file = getExternalFilesDir(AddActivity.FOLDERNAME);
        File[] fileListing = file.listFiles();
        if (fileListing != null) {
            for (int i = 0; i < fileListing.length; i++) {
                StringBuilder str = new StringBuilder();
                try (BufferedReader bufr = new BufferedReader(new FileReader(fileListing[i]))) {
                    String fileName = fileListing[i].getName();
                    String text;
                    while ((text = bufr.readLine()) != null) {
                        str.append(text);
                    }
                    Recipe recipe = new Recipe(fileName, str.toString());
                    recipes.add(recipe);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "File not found.", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Something went wrong. Try again.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}