package com.voltov.catalogcreatorsandbox.ui;

import com.voltov.catalogcreatorsandbox.database.ConnectorBase;
import com.voltov.catalogcreatorsandbox.database.opencart.model.getdata.ModelGetDataProduct;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Main program window
 */
public class MainWindow extends JFrame {

    private final JPanel panel;

    public MainWindow() {
        // set basic window properties
        setTitle("Catalog Creator Sandbox");
        setSize(1280, 720);
        setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // main panel that holds all ui elements
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        ConnectorBase connectorBase = new ConnectorBase();
        if (connectorBase.openConnection()) {
            ModelGetDataProduct modelGetDataProduct = new ModelGetDataProduct(connectorBase.getConnection());
            modelGetDataProduct.refreshData();
            ResultSet resultSet = modelGetDataProduct.getResultSet();
            StringBuilder stringBuilder = new StringBuilder();

            try {
                modelGetDataProduct.first();
                int i = 1;
                while (modelGetDataProduct.next()) {
                    for (int j = 1; j < modelGetDataProduct.getColumnCount() + 1; j++) {
                        stringBuilder.append(modelGetDataProduct.getValueAt(i, j)).append("|");
                    }
                    System.out.println(stringBuilder.toString());
                    textArea.append(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                    i++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
