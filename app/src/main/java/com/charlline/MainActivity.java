package com.charlline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.charlline.adapter.LineAdapter;
import com.charlline.chart.AverageTemperatureChart;
import com.charlline.chart.BudgetDoughnutChart;
import com.charlline.chart.BudgetPieChart;
import com.charlline.chart.ProjectStatusChart;
import com.charlline.chart.SalesBarChart;
import com.charlline.chart.SalesComparisonChart;
import com.charlline.chart.SalesGrowthChart;
import com.charlline.chart.SalesStackedBarChart;
import com.charlline.chart.ScatterChart;
import com.charlline.chart.SensorValuesChart;
import com.charlline.chart.TemperatureChart;
import com.charlline.chart.TrigonometricFunctionsChart;
import com.charlline.chart.WeightDialChart;
import com.charlline.listener.IChart;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private LineAdapter adapter;
    private ListView listView;
    private IChart[] mCharts = new IChart[]{new AverageTemperatureChart(),new SalesStackedBarChart(),new SalesBarChart()
    ,new TrigonometricFunctionsChart(),new ScatterChart(),new SalesComparisonChart(),new ProjectStatusChart(),new SalesGrowthChart()
    ,new BudgetPieChart(),new BudgetDoughnutChart(),new TemperatureChart(),new WeightDialChart(),new SensorValuesChart()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new LineAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = mCharts[position].execute(this);
        startActivity(intent);
    }
}
