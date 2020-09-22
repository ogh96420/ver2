package com.example.ver1.ui.home.Shop;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.viewpager.widget.ViewPager;
        import com.example.ver1.R;
        import com.example.ver1.ui.home.Shop.Adapter.ShopPagerAdapter;
        import com.example.ver1.ui.more.ChatActivity;
        import com.google.android.material.tabs.TabLayout;

public class ShopinfoActivity extends AppCompatActivity {

    private ShopPagerAdapter fragmentPagerAdapter;
    private Button btn, btn1;
    private View v;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopinfo);

        ViewPager viewPager = findViewById(R.id.tab_shopvp);
        fragmentPagerAdapter = new ShopPagerAdapter(getSupportFragmentManager());


        TabLayout tabLayout = findViewById(R.id.tab_shopinfo);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");
        TextView textviewname = (TextView)findViewById(R.id.textView7);
        textviewname.setText(Name);
        String Area = intent.getStringExtra("Area");
        TextView textviewarea = (TextView)findViewById(R.id.textView8);
        textviewarea.setText(Area);
        String Menu = intent.getStringExtra("Menu");
        TextView textviewmenu = (TextView)findViewById(R.id.textView9);
        textviewmenu.setText(Menu);


        btn1=findViewById(R.id.btn_counseling);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ShopinfoActivity.this, ChatActivity.class);
                startActivity(in);
            }

        });

        btn=findViewById(R.id.btn_reservation);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01040961004"));
                startActivity(intent);
            }

        });

    }
}
