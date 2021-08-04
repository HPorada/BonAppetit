package edu.ib.bonappetit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * RecipesRecyclerActivity class definition
 */

public class RecipesRecyclerActivity extends AppCompatActivity implements OnItemClickListener {

    ArrayList<Recipe> recipeList;

    /**
     * Overriden method onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_recipes);

        recipeList = MainActivity.recipes;
        Collections.sort(recipeList);

        RecyclerView rvRecipes = findViewById(R.id.rvRecipesList);
        rvRecipes.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new RecipesAdapter(recipeList, this);

        rvRecipes.setLayoutManager(layoutManager);
        rvRecipes.setAdapter(adapter);
    }

    /**
     * Overriden method onClcik
     *
     * @param view
     * @param position position of the clicked item
     */
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("RecipeExtra", recipeList.get(position));
        startActivity(intent);
    }

    /**
     * Method onSearchClick - allows searching a Recipe by name
     *
     * @param view
     */
    public void onSearchClick(View view) {
        EditText edt = (EditText) findViewById(R.id.edtSearch2);

        String search = edt.getText().toString();

        Recipe recipe = new Recipe();

        for (int i = 0; i < recipeList.size(); i++) {
            if (search.equals(recipeList.get(i).getName())) {
                recipe = recipeList.get(i);
                Intent intent = new Intent(this, RecipeActivity.class);
                intent.putExtra("RecipeExtra", recipe);
                startActivity(intent);
            }
        }
    }
}
