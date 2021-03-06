package com.example.parsabanaei.tictactoe;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView Tv1, Tv2, Tv3, Tv4, Tv5, Tv6, Tv7, Tv8, Tv9;
    char x = 'X', o = 'O';
    char[] arr = new char[9];
    boolean c0 = false, c1 = false, c2 = false, c3 = false, c4 = false, c5 = false, c6 = false, c7 = false, c8 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();


    }


    private void initial() {
        Tv1 = findViewById(R.id.TextView1);
        Tv2 = findViewById(R.id.TextView2);
        Tv3 = findViewById(R.id.TextView3);
        Tv4 = findViewById(R.id.TextView4);
        Tv5 = findViewById(R.id.TextView5);
        Tv6 = findViewById(R.id.TextView6);
        Tv7 = findViewById(R.id.TextView7);
        Tv8 = findViewById(R.id.TextView8);
        Tv9 = findViewById(R.id.TextView9);

        Tv1.setOnClickListener(new TextViewClickHandler());
        Tv2.setOnClickListener(new TextViewClickHandler());
        Tv3.setOnClickListener(new TextViewClickHandler());
        Tv4.setOnClickListener(new TextViewClickHandler());
        Tv5.setOnClickListener(new TextViewClickHandler());
        Tv6.setOnClickListener(new TextViewClickHandler());
        Tv7.setOnClickListener(new TextViewClickHandler());
        Tv8.setOnClickListener(new TextViewClickHandler());
        Tv9.setOnClickListener(new TextViewClickHandler());
    }


    private class TextViewClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v)
        {
            setText(v);
            setEnabled(false);
            if (!checkResultForX())
            {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        condition();
                        checkResultForO();
                        setEnabled(true);

                    }
                }, 500);

            }

        }
    }


    private int countOfEmptyCells() {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (!(arr[i] == x || arr[i] == o)) {
                count++;
            }

        }

        return count;
    }


    private int[] cellsOfX() // cells of x that filled
    {
        int count_Of_Array_Length = 0;

        for (int i = 0; i < 9; i++) {
            if (arr[i] == x) {
                // count of x in arr for arrx length
                ++count_Of_Array_Length;
            }
        }

        int[] arrx = new int[count_Of_Array_Length];
        int j = 0;

        for (int i = 0; i < 9; i++) {
            if (arr[i] == x) {
                arrx[j++] = i;
            }

        }

        return arrx;
    }


    private int[] cellsOfO() // cells of o that filled
    {
        int count_Of_Array_Length = 0;

        for (int i = 0; i < 9; i++) {
            if (arr[i] == o) {
                // count of o in arr for arro length
                ++count_Of_Array_Length;
            }
        }

        int[] arro = new int[count_Of_Array_Length];
        int j = 0;

        for (int i = 0; i < 9; i++) {
            if (arr[i] == o) {
                arro[j++] = i;
            }

        }

        return arro;
    }


    private void condition()
    {

        if(!suggestionOnOSituation())
        {
            suggestionOnXSituation();
        }

    }

    private void suggestionOnXSituation()
    {
        int[] arrx = cellsOfX();

        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;


        for (int i = 0; i < arrx.length; i++) {
            switch (arrx[i]) {
                case 0:
                    c0 = true;
                    break;


                case 1:
                    c1 = true;
                    break;


                case 2:
                    c2 = true;
                    break;


                case 3:
                    c3 = true;
                    break;


                case 4:
                    c4 = true;
                    break;


                case 5:
                    c5 = true;
                    break;


                case 6:
                    c6 = true;
                    break;


                case 7:
                    c7 = true;
                    break;


                case 8:
                    c8 = true;
                    break;
            }

        }
        int cellO = returnOCell();
        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;

        if (cellO == -1) {
            setToRandomCell();
        } else if (arr[cellO] == '\u0000') {
            setText(cellO);
        }
    }

    private boolean suggestionOnOSituation()
    {
        boolean result=false;

        int[] arro = cellsOfO();

        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;


        for (int i = 0; i < arro.length; i++) {
            switch (arro[i]) {
                case 0:
                    c0 = true;
                    break;


                case 1:
                    c1 = true;
                    break;


                case 2:
                    c2 = true;
                    break;


                case 3:
                    c3 = true;
                    break;


                case 4:
                    c4 = true;
                    break;


                case 5:
                    c5 = true;
                    break;


                case 6:
                    c6 = true;
                    break;


                case 7:
                    c7 = true;
                    break;


                case 8:
                    c8 = true;
                    break;
            }

        }

        int cellO = returnOCell();
        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;

        if (cellO == -1)
        {
            result=false;
        }
        else if (arr[cellO] == '\u0000')
        {
            setText(cellO);
            result=true;
        }

        return result;
    }

    private void setToRandomCell() {

        int[] emptyCells = new int[countOfEmptyCells()];
        int j = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[i] == '\u0000') {
                emptyCells[j++] = i;
            }

        }

        Random random = new Random();
        int r = random.nextInt(emptyCells.length);

        setText(emptyCells[r]);
    }


    private int returnOCell() {
        int cell = -1;


        if (c0 && c2) {
            if (arr[1] == '\u0000') {
                cell = 1;
            }
        }

        if (c0 && c1) {

            if (arr[2] == '\u0000') {
                cell = 2;
            }
        }

        if (c1 && c2) {

            if (arr[0] == '\u0000') {
                cell = 0;
            }
        }

        if (c0 && c3) {

            if (arr[6] == '\u0000') {
                cell = 6;
            }
        }

        if (c0 && c6) {

            if (arr[3] == '\u0000') {
                cell = 3;
            }
        }

        if (c6 && c3) {

            if (arr[0] == '\u0000') {
                cell = 0;
            }
        }

        if (c0 && c4) {

            if (arr[8] == '\u0000') {
                cell = 8;
            }
        }

        if (c0 && c8) {

            if (arr[4] == '\u0000') {
                cell = 4;
            }
        }

        if (c4 && c8) {

            if (arr[0] == '\u0000') {
                cell = 0;
            }
        }

        if (c1 && c4) {

            if (arr[7] == '\u0000') {
                cell = 7;
            }
        }

        if (c7 && c4) {

            if (arr[1] == '\u0000') {
                cell = 1;
            }
        }

        if (c1 && c7) {

            if (arr[4] == '\u0000') {
                cell = 4;
            }
        }

        if (c2 && c5) {

            if (arr[8] == '\u0000') {
                cell = 8;
            }
        }

        if (c2 && c8) {

            if (arr[5] == '\u0000') {
                cell = 5;
            }
        }

        if (c5 && c8) {

            if (arr[2] == '\u0000') {
                cell = 2;
            }
        }

        if (c2 && c4) {

            if (arr[6] == '\u0000') {
                cell = 6;
            }
        }

        if (c2 && c6) {

            if (arr[4] == '\u0000') {
                cell = 4;
            }
        }

        if (c4 && c6) {

            if (arr[2] == '\u0000') {
                cell = 2;
            }
        }

        if (c3 && c4) {

            if (arr[5] == '\u0000') {
                cell = 5;
            }
        }

        if (c3 && c5) {

            if (arr[4] == '\u0000') {
                cell = 4;
            }
        }

        if (c5 && c4) {

            if (arr[3] == '\u0000') {
                cell = 3;
            }
        }

        if (c6 && c7) {

            if (arr[8] == '\u0000') {
                cell = 8;
            }
        }

        if (c6 && c8) {

            if (arr[7] == '\u0000') {
                cell = 7;
            }
        }

        if (c7 && c8) {

            if (arr[6] == '\u0000') {
                cell = 6;
            }
        }


        return cell;
    }


    private void setText(View v) {
        TextView textView = (TextView) v;
        int id = v.getId();

        textView.setEnabled(false);
        textView.setText(String.valueOf(x));
        textView.setTextColor(getResources().getColor(R.color.x_color));


        switch (id) {
            case R.id.TextView1:
                arr[0] = x;
                break;


            case R.id.TextView2:
                arr[1] = x;
                break;


            case R.id.TextView3:
                arr[2] = x;
                break;


            case R.id.TextView4:
                arr[3] = x;
                break;


            case R.id.TextView5:
                arr[4] = x;
                break;


            case R.id.TextView6:
                arr[5] = x;
                break;


            case R.id.TextView7:
                arr[6] = x;
                break;


            case R.id.TextView8:
                arr[7] = x;
                break;


            case R.id.TextView9:
                arr[8] = x;
                break;
        }

    }


    private void setText(int cellIndex) {

        arr[cellIndex] = o;

        switch (cellIndex) {
            case 0:

                Tv1.setEnabled(false);
                Tv1.setText(String.valueOf(o));
                Tv1.setTextColor(getResources().getColor(R.color.o_color));

                break;


            case 1:
                Tv2.setEnabled(false);
                Tv2.setText(String.valueOf(o));
                Tv2.setTextColor(getResources().getColor(R.color.o_color));
                break;


            case 2:

                Tv3.setEnabled(false);
                Tv3.setText(String.valueOf(o));
                Tv3.setTextColor(getResources().getColor(R.color.o_color));

                break;


            case 3:
                Tv4.setEnabled(false);
                Tv4.setText(String.valueOf(o));
                Tv4.setTextColor(getResources().getColor(R.color.o_color));
                break;


            case 4:
                Tv5.setEnabled(false);
                Tv5.setText(String.valueOf(o));
                Tv5.setTextColor(getResources().getColor(R.color.o_color));
                break;


            case 5:
                Tv6.setEnabled(false);
                Tv6.setText(String.valueOf(o));
                Tv6.setTextColor(getResources().getColor(R.color.o_color));
                break;


            case 6:
                Tv7.setEnabled(false);
                Tv7.setText(String.valueOf(o));
                Tv7.setTextColor(getResources().getColor(R.color.o_color));
                break;


            case 7:
                Tv8.setEnabled(false);
                Tv8.setText(String.valueOf(o));
                Tv8.setTextColor(getResources().getColor(R.color.o_color));
                break;


            case 8:
                Tv9.setEnabled(false);
                Tv9.setText(String.valueOf(o));
                Tv9.setTextColor(getResources().getColor(R.color.o_color));
                break;
        }

    }


    private boolean checkResultForX() {

        int[] arrx = cellsOfX();

        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;


        for (int i = 0; i < arrx.length; i++) {
            switch (arrx[i]) {
                case 0:
                    c0 = true;
                    break;


                case 1:
                    c1 = true;
                    break;


                case 2:
                    c2 = true;
                    break;


                case 3:
                    c3 = true;
                    break;


                case 4:
                    c4 = true;
                    break;


                case 5:
                    c5 = true;
                    break;


                case 6:
                    c6 = true;
                    break;


                case 7:
                    c7 = true;
                    break;


                case 8:
                    c8 = true;
                    break;
            }
        }

        return checkWhoWon(x);


    }


    private void checkResultForO() {

        int[] arro = cellsOfO();

        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;


        for (int i = 0; i < arro.length; i++) {
            switch (arro[i]) {
                case 0:
                    c0 = true;
                    break;


                case 1:
                    c1 = true;
                    break;


                case 2:
                    c2 = true;
                    break;


                case 3:
                    c3 = true;
                    break;


                case 4:
                    c4 = true;
                    break;


                case 5:
                    c5 = true;
                    break;


                case 6:
                    c6 = true;
                    break;


                case 7:
                    c7 = true;
                    break;


                case 8:
                    c8 = true;
                    break;
            }
        }

        checkWhoWon(o);


    }


    private boolean checkWhoWon(char c) {
        boolean result = false;
        boolean draw = true;
        boolean makedialog = false;
        int count_Of_Array_Length = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[i] != '\u0000') {
                ++count_Of_Array_Length;
            }
        }

        if (c0 && c2 && c1) {
            draw = false;
            makedialog = true;
        }

        if (c0 && c1 && c2) {
            draw = false;
            makedialog = true;
        }

        if (c1 && c2 && c0) {
            draw = false;
            makedialog = true;
        }

        if (c0 && c3 && c6) {
            draw = false;
            makedialog = true;
        }

        if (c0 && c6 && c3) {
            draw = false;
            makedialog = true;
        }

        if (c6 && c3 && c0) {
            draw = false;
            makedialog = true;
        }

        if (c0 && c4 && c8) {
            draw = false;
            makedialog = true;
        }

        if (c0 && c8 && c4) {
            draw = false;
            makedialog = true;
        }

        if (c4 && c8 && c0) {
            draw = false;
            makedialog = true;
        }

        if (c1 && c4 && c7) {
            draw = false;
            makedialog = true;
        }

        if (c7 && c4 && c1) {
            draw = false;
            makedialog = true;
        }

        if (c1 && c7 && c4) {
            draw = false;
            makedialog = true;
        }

        if (c2 && c5 && c8) {
            draw = false;
            makedialog = true;
        }

        if (c2 && c8 && c5) {
            draw = false;
            makedialog = true;
        }

        if (c5 && c8 && c2) {
            draw = false;
            makedialog = true;
        }

        if (c2 && c4 && c6) {
            draw = false;
            makedialog = true;
        }

        if (c2 && c6 && c4) {
            draw = false;
            makedialog = true;
        }

        if (c4 && c6 && c2) {
            draw = false;
            makedialog = true;
        }

        if (c3 && c4 && c5) {
            draw = false;
            makedialog = true;
        }

        if (c3 && c5 && c4) {
            draw = false;
            makedialog = true;
        }

        if (c5 && c4 && c3) {
            draw = false;
            makedialog = true;
        }

        if (c6 && c7 && c8) {
            draw = false;
            makedialog = true;
        }

        if (c6 && c8 && c7) {
            draw = false;
            makedialog = true;
        }

        if (c7 && c8 && c6) {
            draw = false;
            makedialog = true;
        }


        if (c == x && count_Of_Array_Length == 9 && draw) {
            // draw
            result = true;
            makeDialog('d');
        }

        if (makedialog) {
            result = true;
            makeDialog(c);
        }

        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;

        return result;
    }


    private void makeDialog(char c) {
        AlertDialog.Builder alertBilder = new AlertDialog.Builder(MainActivity.this);
        View activityDialog = getLayoutInflater().inflate(R.layout.message_dialog, null);

        TextView tv_message = activityDialog.findViewById(R.id.tv_message_dialog);
        Button btn_again = activityDialog.findViewById(R.id.btn_message_dialog);

        alertBilder.setView(activityDialog);
        final AlertDialog dialog = alertBilder.create();
        try {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        } catch (Exception e) {

        }
        dialog.setCancelable(false);

        if (c == x) {
            tv_message.setText(R.string.win);
        } else if (c == o) {
            tv_message.setText(R.string.lose);
        } else {
            // draw
            tv_message.setText("Draw!");
        }

        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                dialog.dismiss();
            }
        });


        dialog.show();
    }


    private void reset() {
        Tv1.setEnabled(true);
        Tv2.setEnabled(true);
        Tv3.setEnabled(true);
        Tv4.setEnabled(true);
        Tv5.setEnabled(true);
        Tv6.setEnabled(true);
        Tv7.setEnabled(true);
        Tv8.setEnabled(true);
        Tv9.setEnabled(true);


        Tv1.setText("");
        Tv2.setText("");
        Tv3.setText("");
        Tv4.setText("");
        Tv5.setText("");
        Tv6.setText("");
        Tv7.setText("");
        Tv8.setText("");
        Tv9.setText("");

        c0 = false;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;

        for (int i = 0; i < 9; i++) {
            arr[i] = '\u0000';
        }

    }

    private void setEnabled(boolean f)
    {
        if(f)
        {
            for (int i = 0; i < 9; i++) {
                if(arr[i] == '\u0000')
                {
                    switch (i)
                    {
                        case 0:
                            Tv1.setEnabled(f);
                            break;


                        case 1:
                            Tv2.setEnabled(f);
                            break;


                        case 2:
                            Tv3.setEnabled(f);
                            break;


                        case 3:
                            Tv4.setEnabled(f);
                            break;


                        case 4:
                            Tv5.setEnabled(f);
                            break;


                        case 5:
                            Tv6.setEnabled(f);
                            break;


                        case 6:
                            Tv7.setEnabled(f);
                            break;


                        case 7:
                            Tv8.setEnabled(f);
                            break;


                        case 8:
                            Tv9.setEnabled(f);
                            break;
                    }
                }
            }
        }
        else {
            Tv1.setEnabled(f);
            Tv2.setEnabled(f);
            Tv3.setEnabled(f);
            Tv4.setEnabled(f);
            Tv5.setEnabled(f);
            Tv6.setEnabled(f);
            Tv7.setEnabled(f);
            Tv8.setEnabled(f);
            Tv9.setEnabled(f);
        }
    }

}
