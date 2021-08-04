package edu.ib.bonappetit;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * RecipeActivity class deifinition
 */

public class RecipeActivity extends AppCompatActivity {

    /**
     * Overriden method onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        Recipe recipe = (Recipe) getIntent().getSerializableExtra("RecipeExtra");

        TextView name = (TextView) findViewById(R.id.txtRecipeName);
        TextView body = (TextView) findViewById(R.id.txtRecipeInstructions);

        name.setText(recipe.getName());
        body.setMovementMethod(new ScrollingMovementMethod());
        body.setText(recipe.getBody());
    }
}