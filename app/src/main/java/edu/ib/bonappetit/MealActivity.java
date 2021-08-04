package edu.ib.bonappetit;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

/**
 * MealActivity class definition
 */

public class MealActivity extends AppCompatActivity {

    /**
     * Overriden method onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        Intent intent = getIntent();
        Meal meal = (Meal) getIntent().getSerializableExtra("MealExtra");

        TextView name = (TextView) findViewById(R.id.txtMealName);
        ImageView image = (ImageView) findViewById(R.id.imgRecipeImage);
        TextView instructions = (TextView) findViewById(R.id.txtMealInstructions);

        name.setText(meal.getStrMeal());
        Picasso.get()
                .load(meal.getStrMealThumb())
                .resize(250, 250)
                .into(image);
        instructions.setMovementMethod(new ScrollingMovementMethod());
        instructions.setText(meal.toString());
    }
}
