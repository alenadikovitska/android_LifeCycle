package com.example.helen.myproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    // Используйте эти переменные как ключи при сохранении состояния приложения

    // Переменная для записи лога LogCat
    private final static String TAG = "Lab-ActivityTwo";

    // Счетчики состояний

    // СДЕЛАТЬ:
    // Создайте переменные
    // mCreate, mRestart, mStart and mResume для подсчета
    // вызовов onCreate(), onRestart(), onStart() и
    // onResume(). Не объявляйте их static.

    //Для подсчета вызовов мы будем наращивать значение каждой переменной при вызове
    //соответствующего метода.

    private int mCreate;
    private int mRestart;
    private int mStart;
    private int mResume;


    // СДЕЛАТЬ:
    //Создайте переменные для каждого элемента TextView,
    //с помощью которых мы будем показывать наши счетчики на экране.
    //Назовите их mTvCreate, mTvRestart, mTvStart, mTvResume.

    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvStart;
    private TextView mTvResume;
    private TextView tvMessageTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // СДЕЛАТЬ: Свяжите TextView с соответствующими переменными.
        // Получить доступ к TextView можно вызовом метода findViewById()
        // Пример: textView1 = (TextView) findViewById(R.id.textView1);

        mTvCreate = findViewById(R.id.create);
        mTvRestart = findViewById(R.id.restart);
        mTvStart = findViewById(R.id.start);
        mTvResume = findViewById(R.id.resume);
        tvMessageTitle = findViewById(R.id.tvMessageTitle);

        String incomeMessage = getIntent().getExtras().getString("message text");
        tvMessageTitle.setText(incomeMessage);


        Button closeButton = findViewById(R.id.bClose);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // СДЕЛАТЬ:
                // Эта функция должна закрыть Activity Two
                //с помощью метода Context finish()
                finish();


            }
        });

        // Было ли сохранено предыдущее состояние?
        if (savedInstanceState != null) {

            // СДЕЛАТЬ:
            // Восстановить значения счетчиков из сохраненного состояния
            // 4 строки кода, по одной для каждой переменной счетчика

            mCreate = savedInstanceState.getInt(MyConstants.CREATE_KEY);
            mRestart = savedInstanceState.getInt(MyConstants.RESTART_KEY);
            mStart = savedInstanceState.getInt(MyConstants.START_KEY);
            mResume = savedInstanceState.getInt(MyConstants.RESUME_KEY);
        }

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onCreate() ");

        // СДЕЛАТЬ:
        // Обновить значение соответствующей переменной
        // Обновить изображение на экране с помощью метода displayCounts()
        mCreate++;
        displayCounts();

    }

    // Lifecycle callback methods overrides

    @Override
    public void onStart() {
        super.onStart();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onStart() ");

        // СДЕЛАТЬ:
        // Обновить значение соответствующей переменной
        // Обновить изображение на экране
        mStart++;
        displayCounts();

    }

    @Override
    public void onResume() {
        super.onResume();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onResume() ");

        // СДЕЛАТЬ:
        // Обновить значение соответствующей переменной
        // Обновить изображение на экране
        mResume++;
        displayCounts();

    }

    @Override
    public void onPause() {
        super.onPause();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onPause() ");
    }

    @Override
    public void onStop() {
        super.onStop();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onStop() ");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onRestart() ");

        // СДЕЛАТЬ:
        // Обновить значение соответствующей переменной
        // Обновить изображение на экране
        mRestart++;
        displayCounts();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Создаем сообщение в LogCat
        Log.i(TAG, "Вошли в метод onDestroy() ");
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


