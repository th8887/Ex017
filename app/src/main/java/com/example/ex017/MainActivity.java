package com.example.ex017;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener {
    Spinner lands;
    ListView countries;
    TextView secCity,amount,lang,song;

    String [][] names= new String[4][7];
    String [][] facts = new String[28][4];
    int op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lands=(Spinner) findViewById(R.id.lands);
        countries=(ListView)findViewById(R.id.countries);
        secCity=(TextView)findViewById(R.id.secCity);
        amount=(TextView)findViewById(R.id.amount);
        lang=(TextView)findViewById(R.id.lang);
        song=(TextView) findViewById(R.id.song);

        fillMatrix(names,facts);

        lands.setOnItemSelectedListener(this);

        ArrayAdapter<String> lan= new ArrayAdapter<String>(this,R.layout.
                support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.landc));

        lands.setAdapter(lan);

        countries.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        countries.setOnItemClickListener(this);
    }

    private void fillMatrix(String[][] names,String [][] facts) {
        names[0][0]="Brazil";names[0][1]="Canada";names[0][2]="Mexico";names[0][3]="Argentina";names[0][4]="Peru";names[0][5]="Bahamas";names[0][6]="Barbados";//America
        names[1][0]="Nigeria";names[1][1]="Egypt";names[1][2]="Ethiopia";names[1][3]="Tanzania";names[1][4]="Uganda";names[1][5]="Morocco";names[1][6]="Zimbabwe";//Africa
        names[2][0]="France";names[2][1]="Italy";names[2][2]="Germany";names[2][3]="Spain";names[2][4]="United Kingdom";names[2][5]="Russia";names[2][6]="Greece";//Europe
        names[3][0]="China";names[3][1]="Japan";names[3][2]="Thailand";names[3][3]="Turkey";names[3][4]="Nepal";names[3][5]="Sri Lanka";names[3][6]="Georgia";//Asia
        //America
        facts[0][0]="Brasilia";facts[0][1]="210,147,12";facts[0][2]="Portuguese";facts[0][3]="Hino Nacional Brasileiro";
        facts[1][0]="Ottawa";facts[1][1]="38,005,238";facts[1][2]="English or French";facts[1][3]="O Canada";
        facts[2][0]="Mexico City";facts[2][1]="128,649,565";facts[2][2]="Spanish";facts[2][3]="Himno Nacional Mexicano";
        facts[3][0]="Buenos Aires";facts[3][1]="44,938,712";facts[3][2]="Spanish";facts[3][3]="Himno Nacional Argentino";
        facts[4][0]="Lima";facts[4][1]=" 32,824,358";facts[4][2]="Spanish";facts[4][3]="Himno Nacional del Perú";
        facts[5][0]="Nassau";facts[5][1]="385,637";facts[5][2]="English";facts[5][3]="March On, Bahamaland";
        facts[6][0]="Bridgetown";facts[6][1]="287,025";facts[6][2]="English";facts[6][3]="In Plenty and In Time of Need";
        //Africa
        facts[7][0]="Abuja";facts[7][1]="206,630,269";facts[7][2]="English";facts[7][3]="Arise, O Compatriots";
        facts[8][0]="Cairo";facts[8][1]=" 100,075,480";facts[8][2]="Arabic";facts[8][3]="Bilady, Bilady, Bilady";
        facts[9][0]="Addis Ababa";facts[9][1]="109,224,414";facts[9][2]="Amharic";facts[9][3]="March Forward, Dear Mother Ethiopia";
        facts[10][0]="Dodoma";facts[10][1]="56,313,438";facts[10][2]="Swahili or English or Arabic";facts[10][3]="God Bless Africa";
        facts[11][0]="Kampala";facts[11][1]="42,729,036";facts[11][2]="English or Swahili";facts[11][3]="Oh Uganda, Land of Beauty";
        facts[12][0]="Rabat";facts[12][1]="36,472,000";facts[12][2]="Arabic or Berber";facts[12][3]="Cherifian Anthem";
        facts[13][0]="Harare";facts[13][1]="14,215,809";facts[13][2]="English";facts[13][3]="Blessed be the land of Zimbabwe";
        //Europe
        facts[14][0]="Paris";facts[14][1]="67,081,000";facts[14][2]="French";facts[14][3]="La Marseillaise";
        facts[15][0]="Rome";facts[15][1]="60,317,116";facts[15][2]="Italian";facts[15][3]="The Song of the Italians";
        facts[16][0]="Berlin";facts[16][1]=" 83,166,711";facts[16][2]="German";facts[16][3]="Song of Germany";
        facts[17][0]="Madrid";facts[17][1]="47,431,256";facts[17][2]="Spanish";facts[17][3]="Royal March";
        facts[18][0]="London";facts[18][1]="67,886,004";facts[18][2]="English";facts[18][3]="God Save the Queen";
        facts[19][0]="Moscow";facts[19][1]="146,748,590";facts[19][2]="Russian";facts[19][3]="State Anthem of the Russian Federation";
        facts[20][0]="Athens";facts[20][1]="10,724,599";facts[20][2]="Greek";facts[20][3]="Hymn to Liberty";
        //Asia
        facts[21][0]="Beijing";facts[21][1]="1,400,050,000";facts[21][2]="Standard Chinese";facts[21][3]="March of the Volunteers";
        facts[22][0]="Tokyo";facts[22][1]="125,960,00";facts[22][2]="Japanese";facts[22][3]="His Imperial Majesty's Reign";
        facts[23][0]="Bangkok";facts[23][1]="69,758,935";facts[23][2]="Thai";facts[23][3]="Thai National Anthem";
        facts[24][0]="Ankara";facts[24][1]="83,154,997";facts[24][2]="Turkish";facts[24][3]="The Independence March";
        facts[25][0]="Kathmandu";facts[25][1]="28,095,714";facts[25][2]="Nepali";facts[25][3]="Made of Hundreds of Flowers";
        facts[26][0]="Sri Jayawardenepura Kotte and Colombo";facts[26][1]="21,803,000";facts[26][2]="Sinhala or Tamil";facts[26][3]="Mother Sri Lanka";
        facts[27][0]="Tbilisi";facts[27][1]="3,716,858 ";facts[27][2]="Georgian or Abkhazian";facts[27][3]="Freedom";

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        ArrayAdapter<String> country=new ArrayAdapter<String>(this,R.layout.
                support_simple_spinner_dropdown_item,names[pos]);
        countries.setAdapter(country);

        op=pos;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        secCity.setText("second city="+facts[op*7+pos][0]);
        amount.setText("amount of people="+facts[op*7+pos][1]);
        lang.setText("language="+facts[op*7+pos][2]);
        song.setText("national song="+facts[op*7+pos][3]);
    }
}