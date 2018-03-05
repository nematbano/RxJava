package com.example.rx.recyclerviewwithrxsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private StockDataAdapter stockDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        stockDataAdapter = new StockDataAdapter();

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        stockDataAdapter = new StockDataAdapter();
        recyclerView.setAdapter(stockDataAdapter);
//        Observable.just(Arrays.asList("APPL", "GOOGLE", "TWTR"))
//
//                .subscribe(new Consumer<List<String>>() {
//                    @Override
//                    public void accept(List<String> stockSymbol) {
//                        for(int i=0;i<stockSymbol.size();i++)
//                        stockDataAdapter.add(stockSymbol.get(i));
//                    }
//                });

        Observable.just("APPL", "GOOGLE", "TWTR")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String stockSymbol) {
                        stockDataAdapter.add(stockSymbol);
                    }
                });

    }
}
