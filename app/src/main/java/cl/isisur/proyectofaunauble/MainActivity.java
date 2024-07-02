package cl.isisur.proyectofaunauble;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private ListView listView;
    private Button toggleButton;
    private boolean isListViewVisible = false;

    private String[] modelNames = {
            "Huemul",
            "Puma",
            "Sea Wolf",
            "Fox",
            "Buho Real"
    };

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

        webView = findViewById(R.id.webview);
        listView = findViewById(R.id.listView);
        toggleButton = findViewById(R.id.toggleButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, modelNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadModel(modelUrls[position]);
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isListViewVisible) {
                    listView.setVisibility(View.GONE);
                    isListViewVisible = false;
                } else {
                    listView.setVisibility(View.VISIBLE);
                    isListViewVisible = true;
                }
            }
        });
    }

    private void loadModel(String url) {
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
