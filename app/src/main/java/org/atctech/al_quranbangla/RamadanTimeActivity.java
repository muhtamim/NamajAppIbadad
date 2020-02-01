package org.atctech.al_quranbangla;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import org.atctech.al_quranbangla.Fragment.DivisionFragment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RamadanTimeActivity extends AppCompatActivity {

    //    private ArrayList<Constant> arraylist;
//    MyAdaptor adaptor;
//    RecyclerView recyclerView;
    TextView currentDate, currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramadan_time);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
//        getSupportActionBar ().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar ().setCustomView(R.layout.custom_action_bar_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("রমজানের সময়সূচি");
//
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String cdate = df.format(Calendar.getInstance().getTime());
//        DateFormat tf = new SimpleDateFormat("h:mm a");
//        String ctime = tf.format(Calendar.getInstance().getTime());


//        currentTime =findViewById(R.id.idTvTimeHomeRamadan);
//        currentTime.setText(ctime);
        currentDate = findViewById(R.id.idTvDateHomeRamdan);
        currentDate.setText(cdate);
//        recyclerView = findViewById(R.id.ramadanRecyclerView);
//
//        arraylist = new ArrayList<>();
//
//            Constant ramdhan1=new Constant("03:52 am","06:38 pm","17-5-2018");
//            Constant ramdhan2=new Constant("03:52 am","06:39 pm","18-5-2018");
//            Constant ramdhan3=new Constant("03:51 am","06:39 pm","19-5-2018");
//            Constant ramdhan4=new Constant("03:50 am","06:40 pm","20-5-2018");
//            Constant ramdhan5=new Constant("03:50 am","06:40 pm","21-5-2018");
//            Constant ramdhan6=new Constant("03:49 am","06:41 pm","22-5-2018");
//            Constant ramdhan7=new Constant("03:49 am","06:42 pm","23-5-2018");
//            Constant ramdhan8=new Constant("03:48 am","06:42 pm","24-5-2018");
//            Constant ramdhan9=new Constant("03:48 am","06:42 pm","25-5-2018");
//            Constant ramdhan10=new Constant("03:47 am","06:43 pm","26-5-2018");
//            Constant ramdhan11=new Constant("03:47 am","06:43 pm","27-5-2018");
//            Constant ramdhan12=new Constant("03:46 am","06:44 pm","28-5-2018");
//            Constant ramdhan13=new Constant("03:46 am","06:44 pm","29-5-2018");
//            Constant ramdhan14=new Constant("03:46 am","06:45 pm","30-5-2018");
//            Constant ramdhan15=new Constant("03:45 am","06:45 pm","31-5-2018");
//            Constant ramdhan16=new Constant("03:45 am","06:46 pm","01-6-2018");
//            Constant ramdhan17=new Constant("03:45 am","06:46 pm","02-6-2018");
//            Constant ramdhan18=new Constant("03:45 am","06:46 pm","03-6-2018");
//            Constant ramdhan19=new Constant("03:45 am","06:47 pm","04-6-2018");
//            Constant ramdhan20=new Constant("03:45 am","06:47 pm","05-6-2018");
//            Constant ramdhan21=new Constant("03:44 am","06:47 pm","06-6-2018");
//            Constant ramdhan22=new Constant("03:44 am","06:48 pm","07-6-2018");
//            Constant ramdhan23=new Constant("03:44 am","06:48 pm","08-6-2018");
//            Constant ramdhan24=new Constant("03:44 am","06:49 pm","09-6-2018");
//            Constant ramdhan25=new Constant("03:44 am","06:49 pm","10-6-2018");
//            Constant ramdhan26=new Constant("03:44 am","06:50 pm","11-6-2018");
//            Constant ramdhan27=new Constant("03:44 am","06:50 pm","12-6-2018");
//            Constant ramdhan28=new Constant("03:44 am","06:50 pm","13-6-2018");
//            Constant ramdhan29=new Constant("03:44 am","06:50 pm","14-6-2018");
//            Constant ramdhan30=new Constant("03:44 am","06:51 pm","15-6-2018");
//
//
//
//            arraylist.add(ramdhan1);
//            arraylist.add(ramdhan2);
//            arraylist.add(ramdhan3);
//            arraylist.add(ramdhan4);
//            arraylist.add(ramdhan5);
//            arraylist.add(ramdhan6);
//            arraylist.add(ramdhan7);
//            arraylist.add(ramdhan8);
//            arraylist.add(ramdhan9);
//            arraylist.add(ramdhan10);
//            arraylist.add(ramdhan11);
//            arraylist.add(ramdhan12);
//            arraylist.add(ramdhan13);
//            arraylist.add(ramdhan14);
//            arraylist.add(ramdhan15);
//            arraylist.add(ramdhan16);
//            arraylist.add(ramdhan17);
//            arraylist.add(ramdhan18);
//            arraylist.add(ramdhan19);
//            arraylist.add(ramdhan20);
//            arraylist.add(ramdhan21);
//            arraylist.add(ramdhan22);
//            arraylist.add(ramdhan23);
//            arraylist.add(ramdhan24);
//            arraylist.add(ramdhan25);
//            arraylist.add(ramdhan26);
//            arraylist.add(ramdhan27);
//            arraylist.add(ramdhan28);
//            arraylist.add(ramdhan29);
//            arraylist.add(ramdhan30);
//
//
//        adaptor = new MyAdaptor(this,arraylist);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.devider));
//        recyclerView.addItemDecoration(itemDecorator);
//        recyclerView.setAdapter(adaptor);

        android.support.v4.app.FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.division_fragment, DivisionFragment.newInstance())
                .commit();
//

    }


    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        if (count <= 0) {
            finish();
        } else {
            getSupportActionBar().setTitle("রমজানের সময়সূচি");
        }
        super.onBackPressed();
    }

}
