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
            "https://sketchfab.com/models/fb255e4232d14734aac4d93ed2980160/embed",
            "https://sketchfab.com/models/90ba3e274ec248d78f23b1beb5da5b08/embed",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up click listeners for each image
        setImageClickListener(R.id.imageHuemul, modelUrls[0]);
        setImageClickListener(R.id.imagePuma, modelUrls[1]);
        setImageClickListener(R.id.imageSeaWolf, modelUrls[2]);
        setImageClickListener(R.id.imageFox, modelUrls[3]);
        setImageClickListener(R.id.imageBuhoReal, modelUrls[4]);
        setImageClickListener(R.id.imageCondor, modelUrls[5]);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Inicio.class);
                startActivity(intent);
            }
        });

    }

    private void setImageClickListener(int imageViewId, final String url) {
        findViewById(imageViewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadModel(url);
            }
        });

    }

    private void loadModel(String url) {
        Intent intent = new Intent(MainActivity.this, Vizualizacion.class);
        intent.putExtra("modelUrl", url);
        startActivity(intent);
    }
}
