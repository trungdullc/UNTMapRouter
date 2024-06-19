package com.example.untmaprouter;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;                     // DEBUG
import java.util.*;

public class MapSolution extends AppCompatActivity {
    Button backMap;
    public int src = -1,dest = -1;                // Du's global variable from previous page
    private TextView src3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map_solution);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backMap = findViewById(R.id.backMapButton);
        backMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapSolution.this, Navigation.class);
                startActivity(intent);
                finish();                               // prevents back button
            }
        });

        src3 = findViewById(R.id.src2);

        String receivedSrc = getIntent().getStringExtra("keysrc");
        String receivedDest = getIntent().getStringExtra("keydest");

        // DEBUG Testing setting src by parsing string
        if (receivedSrc.equals("01 Art Building")) src = 1;
        else if (receivedSrc.equals("02 Auditorium")) src = 2;
        else if (receivedSrc.equals("03 Chemistry")) src = 3;
        else if (receivedSrc.equals("04 Curry Hall")) src = 4;
        else if (receivedSrc.equals("05 General Academic Building")) src = 5;
        else if (receivedSrc.equals("06 Hickory Hall")) src = 6;
        else if (receivedSrc.equals("07 Language Building")) src = 7;
        else if (receivedSrc.equals("08 Life Science Complex")) src = 8;
        else if (receivedSrc.equals("09 Marquis Hall")) src = 9;
        else if (receivedSrc.equals("10 Physics Building")) src = 10;
        else if (receivedSrc.equals("11 Radio, TV, Film and Performing Arts")) src = 11;
        else if (receivedSrc.equals("12 Sage Hall")) src = 12;
        else if (receivedSrc.equals("13 Science Research Building")) src = 13;
        else if (receivedSrc.equals("14 Sycamore Hall")) src = 14;
        else if (receivedSrc.equals("15 Terrill Hall")) src = 15;

        // DEBUG Testing setting dest by parsing string
        if (receivedDest.equals("01 Art Building")) dest = 1;
        else if (receivedDest.equals("02 Auditorium")) dest = 2;
        else if (receivedDest.equals("03 Chemistry")) dest = 3;
        else if (receivedDest.equals("04 Curry Hall")) dest = 4;
        else if (receivedDest.equals("05 General Academic Building")) dest = 5;
        else if (receivedDest.equals("06 Hickory Hall")) dest = 6;
        else if (receivedDest.equals("07 Language Building")) dest = 7;
        else if (receivedDest.equals("08 Life Science Complex")) dest = 8;
        else if (receivedDest.equals("09 Marquis Hall")) dest = 9;
        else if (receivedDest.equals("10 Physics Building")) dest = 10;
        else if (receivedDest.equals("11 Radio, TV, Film and Performing Arts")) dest = 11;
        else if (receivedDest.equals("12 Sage Hall")) dest = 12;
        else if (receivedDest.equals("13 Science Research Building")) dest = 13;
        else if (receivedDest.equals("14 Sycamore Hall")) dest = 14;
        else if (receivedDest.equals("15 Terrill Hall")) dest = 15;

        // DEBUG delete later
        System.out.printf("Hello World\n");
        System.out.printf("src: %d\n", src);
        System.out.printf("dest: %d\n", dest);

        // IMPORTANT: Put your code here
        Graph graph = new Graph();

        // Creating nodes (intersections or buildings)
        Node nodeA = new Node("Chemistry Bldg");
        Node nodeB = new Node("Mulbury/Sycamore Intersection");
        Node nodeC = new Node("Science Research");
        Node nodeD = new Node("Mulbury/GAB Intersection");
        Node nodeE = new Node("GAB");

        // Adding nodes to the graph
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        // Adding edges (roads) with weights (lengths in miles) and directions
        graph.addEdge(nodeA, nodeB, 1.2, "east");
        graph.addEdge(nodeB, nodeA, 1.2, "west");

        graph.addEdge(nodeB, nodeC, 2.5, "east");
        graph.addEdge(nodeC, nodeB, 2.5, "west");

        graph.addEdge(nodeC, nodeD, 1.0, "east");
        graph.addEdge(nodeD, nodeC, 1.0, "west");

        graph.addEdge(nodeD, nodeE, 3.0, "south");
        graph.addEdge(nodeE, nodeD, 3.0, "north");


        // Running Dijkstra's algorithm to test
        List<String> path = graph.dijkstra(nodeE, nodeA);

        // Output the directions
        if (path.isEmpty()) {
            // System.out.println("No path found from " + nodeE.getName() + " to " + nodeA.getName());
            src3.setText("No path found from " + nodeE.getName() + " to " + nodeA.getName());
        } else {
            String total = "";
            for (String direction : path) {
                // System.out.println(direction);
                total = total + direction + "\n";
            }
            // System.out.println("Shortest path from " + nodeE.getName() + " to " + nodeA.getName() + ":");
            src3.setText("Shortest path from " + nodeE.getName() + " to " + nodeA.getName() + ":\n" + total);

        }

        // IMPORTANT: Put output of group in here as a string
        // src3.setText("Source: " + receivedSrc + "\nDestination: " + receivedDest + "\nHacker Du was here!!!\nTurn Left in 3 min\nTurn Right in 5 min");
    }
}