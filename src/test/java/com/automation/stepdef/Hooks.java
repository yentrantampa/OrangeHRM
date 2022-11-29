package com.automation.stepdef;

import com.automation.utils.ConfigReader;
//import com.automation.utils.DataBaseUtils;
import com.automation.utils.DriverUtils;
import com.automation.utils.logs.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp(){
        ConfigReader.initProperties();
        Log.info("Init properties initializing");
        DriverUtils.createDriver();
        Log.info("Creating driver");
        //DataBaseUtils.initDatabase();
    }

    @After
    public void quit(){
        DriverUtils.getDriver().quit();
        Log.info("Quitting Driver");
    }
}