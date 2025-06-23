package kr.ac.kopo.preferencevoting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("커비 배경 선호도 투표");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final int voteCount[] = new int[9];
        for (int i =0 ; i<voteCount.length; i++){
            voteCount[i] = 0;
        }

        ImageView imgv[] = new ImageView[9];
        int imgvId[] = {R.id.k1, R.id.k2, R.id.k3, R.id.k4, R.id.k5, R.id.k6, R.id.k7, R.id.k8, R.id.k9};
        final String imgName[] = {"커비의 다양한 능력1", "커비의 다양한 능력2", "춤추는 커비", "커비의 뒷모습", "날아가는 커비",
                "커비의 모자 콜렉션", "졸린 커비", "비오는 날의 커비", "디디디 대왕"};

        for (int i = 0; i < imgv.length; i++) {
            final int index;
            index = i;
            imgv[index] = findViewById(imgvId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총 " + voteCount[index] + "표", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }}