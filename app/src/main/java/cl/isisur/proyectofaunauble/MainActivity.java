package cl.isisur.proyectofaunauble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] modelUrls = {
            "https://sketchfab.com/models/b529efcc9f8c451cbeae6458124ff462/embed",
            "https://sketchfab.com/models/8242c1a560e149858844abdd8dd869f9/embed",
            "https://sketchfab.com/models/c1f647a0c8d04f14b43e23ba292ca72f/embed",
            "https://sketchfab.com/models/215b317cabfa42c48fad08d8b9a8fb8d/embed",
            "https://sketchfab.com/models/fb255e4232d14734aac4d93ed2980160/embed"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up click listeners for each image
        findViewById(R.id.imageHuemul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadModel(modelUrls[0]);
            }
        });

        findViewById(R.id.imagePuma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadModel(modelUrls[1]);
            }
        });

        findViewById(R.id.imageSeaWolf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadModel(modelUrls[2]);
            }
        });

        findViewById(R.id.imageFox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadModel(modelUrls[3]);
            }
        });

        findViewById(R.id.imageBuhoReal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadModel(modelUrls[4]);
            }
        });
    }

    private void loadModel(String url) {
        Intent intent = new Intent(MainActivity.this, Vizualizacion.class);
        intent.putExtra("modelUrl", url);
        startActivity(intent);
    }
}
