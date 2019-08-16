package ru.job4j.tictactoy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int cnt = 1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Switch sw;
    Button[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = findViewById(R.id.switch1);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);

        arr = new Button[]{b1, b2, b3, b4, b5, b6, b7, b8, b9};

        b1.setOnClickListener(view -> {
            b1.setText(genFig());
            autoStep();
            checkWin();
        });

        b2.setOnClickListener(view -> {
            b2.setText(genFig());
            autoStep();
            checkWin();
        });

        b3.setOnClickListener(view -> {
            b3.setText(genFig());
            autoStep();
            checkWin();
        });

        b4.setOnClickListener(view -> {
            b4.setText(genFig());
            autoStep();
            checkWin();
        });

        b5.setOnClickListener(view -> {
            b5.setText(genFig());
            autoStep();
            checkWin();
        });

        b6.setOnClickListener(view -> {
            b6.setText(genFig());
            autoStep();
            checkWin();
        });

        b7.setOnClickListener(view -> {
            b7.setText(genFig());
            autoStep();
            checkWin();
        });

        b8.setOnClickListener(view -> {
            b8.setText(genFig());
            autoStep();
            checkWin();
        });

        b9.setOnClickListener(view -> {
            b9.setText(genFig());
            autoStep();
            checkWin();
        });

    }

    /**
     * метод генерирует "X" или "O" по очереди
     * @return "X" или "O"
     */
    public String genFig() {
        String res = cnt % 2 != 0 ? "X" : "O";
        cnt++;
        return res;
    }

    /**
     * Предполагалось, что метод при включенном выключателе, после хода человека
     * будет находить первую свободную клетку и делать туда ход и завершаться
     */
    public void autoStep() {
        if(sw.isChecked()) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].getText() == null) {
                    arr[i].setText(genFig());
                    break;
                }
            }
        }
    }

    /**
     * Педполагалось, что метод будет проверять выигрышные позиции
     * 2 диагонали, 3 ветикали и 3 горизонтали
     */
    public void checkWin() {
        if (   (b1.getText() == b5.getText() && b5.getText() == b9.getText())
            || (b7.getText() == b5.getText() && b5.getText() == b3.getText())

            || (b1.getText() == b2.getText() && b2.getText() == b3.getText())
            || (b4.getText() == b5.getText() && b5.getText() == b6.getText())
            || (b7.getText() == b8.getText() && b8.getText() == b9.getText())

            || (b1.getText() == b4.getText() && b4.getText() == b7.getText())
            || (b2.getText() == b5.getText() && b5.getText() == b8.getText())
            || (b3.getText() == b6.getText() && b6.getText() == b9.getText())

        ) {
            Toast.makeText(
                    this, "win",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putString("b1", String.valueOf(b1.getText()));
        state.putString("b2", String.valueOf(b2.getText()));
        state.putString("b3", String.valueOf(b3.getText()));
        state.putString("b4", String.valueOf(b4.getText()));
        state.putString("b5", String.valueOf(b5.getText()));
        state.putString("b6", String.valueOf(b6.getText()));
        state.putString("b7", String.valueOf(b7.getText()));
        state.putString("b8", String.valueOf(b8.getText()));
        state.putString("b9", String.valueOf(b9.getText()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        b1.setText(state.getString("b1"));
        b2.setText(state.getString("b2"));
        b3.setText(state.getString("b3"));
        b4.setText(state.getString("b4"));
        b5.setText(state.getString("b5"));
        b6.setText(state.getString("b6"));
        b7.setText(state.getString("b7"));
        b8.setText(state.getString("b8"));
        b9.setText(state.getString("b9"));
    }
}
