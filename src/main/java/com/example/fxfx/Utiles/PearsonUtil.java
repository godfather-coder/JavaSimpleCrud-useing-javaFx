package com.example.fxfx.Utiles;
import com.example.fxfx.DataBase.DB_connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PearsonUtil {
    private static PearsonUtil bu;
    private static final Statement statement = DB_connector.getStatement();

    private PearsonUtil() {
    }

    public static PearsonUtil getInstance() {
        if (bu == null)
            bu = new PearsonUtil();
        return bu;
    }

}
