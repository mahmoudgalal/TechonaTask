package com.mgalal.techonatask;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mgalal.techonatask.adapters.ServerBtnsAdapter;
import com.mgalal.techonatask.model.ServerButton;
import com.mgalal.techonatask.viewmodel.ServerButtonsViewModel;
import com.mgalal.techonatask.viewmodel.ServerButtonsViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ServerBtnsAdapter.OnItemClickedListener {

    private ServerButtonsViewModel viewModel;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ServerBtnsAdapter adapter;

    @Inject
    ServerButtonsViewModelFactory serverButtonsViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TechonaTestApp)getApplication()).getTechonaTestComponentechona().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.buttons_recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        setupRecycler();
        viewModel = ViewModelProviders.of(this,serverButtonsViewModelFactory)
                .get(ServerButtonsViewModel.class);
        viewModel.init();
        viewModel.getData().observe(this, new Observer<List<ServerButton>>() {
            @Override
            public void onChanged(@Nullable List<ServerButton> serverButtons) {
                progressBar.setVisibility(View.GONE);
                adapter.setItems(serverButtons);
                adapter.notifyDataSetChanged();
            }
        });
    }
    private void setupRecycler(){
        adapter =  new ServerBtnsAdapter(this);
        LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(ServerButton item) {
        Toast.makeText(this,"Item:"+item.getName(),Toast.LENGTH_LONG).show();
    }
}
