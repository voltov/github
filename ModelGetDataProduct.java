package com.voltov.catalogcreatorsandbox.database.opencart.model.getdata;

import ModelGetData.ModelGetDataBase;

import java.sql.Connection;

/**
 * Knows how to retrieve product data
 */
public class ModelGetDataProduct extends ModelGetDataBase {

    public ModelGetDataProduct(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return "tomori_product";
    }
}
