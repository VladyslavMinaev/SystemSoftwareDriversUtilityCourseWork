package org.drivers.service;

import org.drivers.Devices;

import java.io.BufferedReader;
import java.io.IOException;

public interface DriverService {

    void getEnumDrivers();

    void runCustomQuery(String query);

    void getConnectedDevices(Devices category);

    void appendNewDriver(String driverPath);

    void deleteDriver(String driverPath);

    default StringBuilder getConsoleTrace(BufferedReader reader) throws IOException {

        String consoleFrame;
        StringBuilder consoleQueryBuilder = new StringBuilder();

        double startTime = System.nanoTime();

        while (true) {
            consoleFrame = reader.readLine();
            consoleQueryBuilder.append(consoleFrame);

            if (consoleFrame == null) {break;}

            System.out.println(consoleFrame);
        }

        System.out.println("\n[Complete time]: " + ((System.nanoTime() - startTime) / 1000000000) + " s.");

        return consoleQueryBuilder;
    }

}
