package comsci.adoublelz.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02,
            R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05,
            R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08,
            R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11,
            R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14,
            R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17,
            R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};

    private String[] titleStrings, detailStrings, shortStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intitial View

        listView = (ListView) findViewById(R.id.livTraffic);

        //get value

        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);


        //SubString detailStrings cut the word in detailString for limit 30 char
        shortStrings = new String[detailStrings.length]; //books space in memory String
            for ( int i=0; i < detailStrings.length; i++ ) {
                shortStrings[i] = detailStrings[i].substring(0,29)+"...";

            } //end for

            //create ListView

        MyAdepter myAdepter = new MyAdepter(MainActivity.this, ints, titleStrings, shortStrings );
        listView.setAdapter(myAdepter);

        //Active when click List View link go to detail

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //when click item anywhere It will keep that Position

                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Detail", detailStrings[position]);
                intent.putExtra("Image", ints[position]);
                startActivity(intent);

            }
        });
        Button button = (Button) findViewById(R.id.btnAboutme);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,aboutme.class);
                startActivity(intent);
            }
        });

    }


    /* Main Class onCreate*/

    public void onClickMoreInfo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111"));
        startActivity(intent);

    } /*Main Method onClickMoreInfo*/
} /* Main Class */
