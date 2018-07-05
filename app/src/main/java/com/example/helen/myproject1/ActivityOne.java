package com.example.helen.myproject1;


//import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    // Переменные, необходимые для сохранения состояния приложения между переключениями


    // Переменная для записи лога LogCat
    private final static String TAG = "Lab-ActivityOne";

    // Счетчики состояний.

    // СДЕЛАТЬ:
    // Создайте переменные счетчиков
    // mCreate, mRestart, mStart и mResume.
    // В них мы будем сохранять количество вызовов функций onCreate(), onRestart(),
    // onStart() и onResume(). Не объявляйте их static.
    //Как вы думаете, почему нельзя использовать static?

    //Для подсчета вызовов мы будем наращивать значение каждой переменной при вызове
    //соответствующего метода.

    private int mCreate;
    private int mRestart;
    private int mStart;
    private int mResume;


    // СДЕЛАТЬ:
    //Создайте переменные для каждого элемента TextView.
    //Назовите их mTvCreate, mTvRestart, mTvStart, mTvResume.
    //С их помощью мы будем показывать наши счетчики на экране.

    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvStart;
    private TextView mTvResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        // СДЕЛАТЬ: Свяжите TextView с соответствующими переменными.
        // Получить доступ к TextView можно вызовом метода findViewById()
        // Пример: textView1 = (TextView) findViewById(R.id.textView1);

        mTvCreate = findViewById(R.id.create);
        mTvRestart = findViewById(R.id.restart);
        mTvStart = findViewById(R.id.start);
        mTvResume = findViewById(R.id.resume);

        final String message = "Сообщение из MainActivity";

        //Кнопка, вызывающая вторую Activity

        Button launchActivityTwoButton = findViewById(R.id.bLaunchActivityTwo);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // СДЕЛАТЬ:
                // Нужно запустить Activity Two
                // с помощью метода Context startActivity()

                // Создайте Intent, определяющий, какая Activity будет запущена
                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);

                intent.putExtra("message text", message);

                // Запустите Activity с помощью созданного intent
                startActivity(intent);
            }
        });

        // Было ли сохранено предыдущее состояние?
        if (savedInstanceState != null) {

            // СДЕЛАТЬ:
            // Восстановить значения счетчиков из сохраненного состояния
            // Понадобится всего 4 строки кода, по одной на каждую переменную счетчиков.
            mCreate = savedInstanceState.getInt(MyConstants.CREATE_KEY);
            mRestart = savedInstanceState.getInt(MyConstants.RESTART_KEY);
            mStart = savedInstanceState.getInt(MyConstants.START_KEY);
            mResume = savedInstanceState.getInt(MyConstants.RESUME_KEY);
        }

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onCreate()");

        // СДЕЛАТЬ:
        // Обновить соответствующие переменные счетчиков.
        // Обновить изображение на экране с помощью приведенного ниже метода displayCounts()
        mCreate++;
        displayCounts();
    }

    // Нужные переопределения

    @Override
    public void onStart() {
        super.onStart();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onStart()");

        // СДЕЛАТЬ:
        // Обновить соответствующую переменную счетчика
        // Обновить изображение на экране
        mStart++;
        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onResume()");

        // СДЕЛАТЬ:
        // Обновить соответствующую переменную счетчика
        // Обновить изображение на экране
        mResume++;
        displayCounts();
    }

    @Override
    public void onPause() {
        super.onPause();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onStop()");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onRestart()");

        // СДЕЛАТЬ:
        // Обновить соответствующую переменную счетчика
        // Обновить изображение на экране
        mRestart++;
        displayCounts();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onDestroy()");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // СДЕЛАТЬ:
        // Сохранить информацию о состоянии приложения с помощью пар "ключ-значение"
        // 4 строки кода, по одной для каждой переменной счетчика
        savedInstanceState.putInt (MyConstants.CREATE_KEY, mCreate);
        savedInstanceState.putInt (MyConstants.RESTART_KEY, mRestart);
        savedInstanceState.putInt(MyConstants.START_KEY, mStart);
        savedInstanceState.putInt(MyConstants.RESUME_KEY, mResume);

    }

    // Обновляем выведенные на экран счетчики
    // Предполагается, что ранее были заданы предложенные имена
    // для переменных счетчиков и элементов TextView

    public void displayCounts() {

        mTvCreate.setText(getString(R.string.oncreate_calls) + mCreate);
        mTvStart.setText(getString(R.string.onstart_calls) + mStart);
        mTvResume.setText(getString(R.string.onresume_calls) + mResume);
        mTvRestart.setText(getString(R.string.onrestart_calls) + mRestart);

    }
}
