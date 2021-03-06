package com.lalit.apurva.hindishayari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] fruitNames = {"Sad Shayari","Funny Shayari","Love Shayari",
            "Birthday","Watemellon","Banana"};
    int[] fruitImages = {R.drawable.sad_shayari_img,R.drawable.funny,
            R.drawable.love,R.drawable.birthday_shayari,R.drawable.watermelon,
            R.drawable.banana};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //banner ads load
        AdView mAdView=findViewById(R.id.bannerAd);

        //request ad to admob server
        AdRequest adRequest = new AdRequest.Builder().build();

        //add ad to Adview object
        mAdView.loadAd(adRequest);

        gridView=findViewById(R.id.gridview);

        CustomAdapter customAdapter=new CustomAdapter();

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",String.valueOf(position));
//                intent.putExtra("name",fruitNames[position]);
//                intent.putExtra("image",fruitImages[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return fruitImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v= getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name=v.findViewById(R.id.fruits);
            ImageView image=v.findViewById(R.id.images);

            name.setText(fruitNames[position]);
            image.setImageResource(fruitImages[position]);
            return v;
        }
    }
}
