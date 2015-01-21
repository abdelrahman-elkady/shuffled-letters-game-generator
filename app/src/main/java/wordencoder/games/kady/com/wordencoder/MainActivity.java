package wordencoder.games.kady.com.wordencoder;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import at.markushi.ui.CircleButton;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.editxt_original_text)
     EditText mOriginalTextEditText ;

    @InjectView(R.id.editxt_encoded_text)
      EditText mEncodedEditText ;

    @InjectView(R.id.btn_encode)
     CircleButton mEncodeCircleButton ;

    @InjectView(R.id.btn_decode)
    CircleButton mDecodeCircleButton ;

    private HashMap<Integer,String> mEncodingTableMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initMap();

        mEncodeCircleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String original = mOriginalTextEditText.getText().toString().toUpperCase();

                StringBuilder encoded = new StringBuilder("");

                String[] originalLetters = original.split("");

                for(String letter : originalLetters) {
                    if(letter.equals(" "))
                        encoded.append(" # ");
                    else {
                        if(getKeyByValue(mEncodingTableMap, letter) == null)
                            continue;
                        encoded.append(getKeyByValue(mEncodingTableMap, letter) + " ");
                    }
                }

                mEncodedEditText.setText(encoded);
            }
        });

        mDecodeCircleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encoded = mEncodedEditText.getText().toString().toUpperCase();
                StringBuilder decoded = new StringBuilder("");

                String[] letters = encoded.split(" ");

                for(String letter : letters) {

                 if(letter.equals("#"))
                     decoded.append(" ");

                    if (!(letter.equals(" ") || !Character.isDigit(letter.charAt(0))))
                     decoded.append(mEncodingTableMap.get(Integer.parseInt(letter)));
                }

                mOriginalTextEditText.setText(decoded.toString().toLowerCase());


            }
        });

    }

    private void initMap() {
        mEncodingTableMap = new HashMap<>();

        mEncodingTableMap.put(24,"ت");

        mEncodingTableMap.put(6,"I");

        mEncodingTableMap.put(27,"ب");

        mEncodingTableMap.put(12,"S");

        mEncodingTableMap.put(43,"ن");

        mEncodingTableMap.put(33,"A");

        mEncodingTableMap.put(21,"خ");

        mEncodingTableMap.put(8,"W");

        mEncodingTableMap.put(36,"M");

        mEncodingTableMap.put(16,"ط");

        mEncodingTableMap.put(44,"B");

        mEncodingTableMap.put(20,"س");

        mEncodingTableMap.put(9,"N");

        mEncodingTableMap.put(1,"ف");

        mEncodingTableMap.put(41,"ا");

        mEncodingTableMap.put(17,"H");

        mEncodingTableMap.put(5,"د");

        mEncodingTableMap.put(25,"T");

        mEncodingTableMap.put(37,"J");

        mEncodingTableMap.put(13,"ذ");

        mEncodingTableMap.put(31,"G");

        mEncodingTableMap.put(2,"ظ");

        mEncodingTableMap.put(22,"C");

        mEncodingTableMap.put(48,"ك");

        mEncodingTableMap.put(11,"ز");

        mEncodingTableMap.put(26,"E");

        mEncodingTableMap.put(10,"ص");

        mEncodingTableMap.put(32,"ق");

        mEncodingTableMap.put(40,"O"); // This is not zero :D

        mEncodingTableMap.put(15,"U");

        mEncodingTableMap.put(4,"ث");

        mEncodingTableMap.put(45,"Q");

        mEncodingTableMap.put(18,"ه");

        mEncodingTableMap.put(38,"X");

        mEncodingTableMap.put(19,"P");

        mEncodingTableMap.put(47,"Y");

        mEncodingTableMap.put(23,"ش");

        mEncodingTableMap.put(39,"D");

        mEncodingTableMap.put(3,"ل");

        mEncodingTableMap.put(34,"Z");

        mEncodingTableMap.put(50,"و");

        mEncodingTableMap.put(28,"غ");

        mEncodingTableMap.put(32,"F");

        mEncodingTableMap.put(34,"ح");

        mEncodingTableMap.put(51,"ع");

        mEncodingTableMap.put(49,"ض");

        mEncodingTableMap.put(35,"م");

        mEncodingTableMap.put(46,"R");

        mEncodingTableMap.put(52,"V");

        mEncodingTableMap.put(14,"L");

        mEncodingTableMap.put(53,"ى");

        mEncodingTableMap.put(54,"ج");

        mEncodingTableMap.put(7,"ر");

        mEncodingTableMap.put(28,"K");

    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}
