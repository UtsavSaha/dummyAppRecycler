package apps.org.dummyapprecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Group> getAllGroups(){
        List<Team> list1 = new ArrayList<>();
        list1.add(new Team("Russia" , 31));
        list1.add(new Team("Saudi Arabia" , 32));
        list1.add(new Team("Egypt" , 26));
        list1.add(new Team("Uruguay",16));

       Group a = new Group("Group A", list1);

        List<Team> list2 = new ArrayList<>();
        list2.add(new Team("Portugal" , 4));
        list2.add(new Team("Spain" , 8));
        list2.add(new Team("Morocco" , 25));
        list2.add(new Team("Iran",23));

       Group b = new Group("Group B" , list2);

        List<Team> list3 = new ArrayList<>();
        list3.add(new Team("France" , 7));
        list3.add(new Team("Australia" , 24));
        list3.add(new Team("Peru" , 10));
        list3.add(new Team("Denmark",11));

        Group c = new Group("Group C" , list3);


        List<Team> list4 = new ArrayList<>();
        list4.add(new Team("Argentina" , 5));
        list4.add(new Team("Iceland" , 18));
        list4.add(new Team("Croatia" , 17));
        list4.add(new Team("Nigeria",27));

        Group d = new Group("Group D" , list4);


        List<Team> list5= new ArrayList<>();
        list5.add(new Team("Brazil" , 2));
        list5.add(new Team("Switzerland" , 6));
        list5.add(new Team("CostaRica" , 20));
        list5.add(new Team("Serbia",22));

        Group e = new Group("Group E" , list5);


        List<Team> list6 = new ArrayList<>();
        list6.add(new Team("Germany" , 1));
        list6.add(new Team("Mexico" , 14));
        list6.add(new Team("Sweden" , 19));
        list6.add(new Team("South Korea",30));

        Group f = new Group("Group F" , list6);

        List<Team> list7 = new ArrayList<>();
        list7.add(new Team("Belgium" , 3));
        list7.add(new Team("Panama" , 28));
        list7.add(new Team("Tunisia" , 13));
        list7.add(new Team("England",12));

        Group g = new Group("Group G" , list7);

        List<Team> list8 = new ArrayList<>();
        list8.add(new Team("Poland" , 9));
        list8.add(new Team("Senegal" , 21));
        list8.add(new Team("Colombia" , 15));
        list8.add(new Team("Japan",29));

        Group h = new Group("Group H" , list8);

        List<Group> allGroups = new ArrayList<Group>();
        allGroups.add(a);
        allGroups.add(b);
        allGroups.add(c);
        allGroups.add(d);
        allGroups.add(e);
        allGroups.add(f);
        allGroups.add(g);
        allGroups.add(h);
        return allGroups;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView masterRecycleView = findViewById(R.id.master_recycler_view);
        masterRecycleView.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        masterRecycleView.setLayoutManager(layoutManager);
        MasterAdapter adapter = new MasterAdapter(getAllGroups());
        masterRecycleView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
