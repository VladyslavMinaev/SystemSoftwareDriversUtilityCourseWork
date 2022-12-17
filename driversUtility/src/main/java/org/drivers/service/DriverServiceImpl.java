package org.drivers.service;

import org.drivers.Devices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DriverServiceImpl implements DriverService {

    private static ProcessBuilder commandsExecutor;

    @Override
    public void getEnumDrivers() {
        try {
            commandsExecutor = new ProcessBuilder(
                    "powershell.exe", "chcp 861 | pnputil /enum-drivers");

            commandsExecutor.redirectErrorStream(true);

            Process p = commandsExecutor.start();

            BufferedReader consoleLinesReader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            getConsoleTrace(consoleLinesReader);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    @Override
    public void runCustomQuery(String query) {
        try {
            commandsExecutor = new ProcessBuilder(
                    "powershell.exe", "chcp 861 | " + query);

            commandsExecutor.redirectErrorStream(true);

            Process p = commandsExecutor.start();

            BufferedReader consoleLinesReader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            getConsoleTrace(consoleLinesReader);

        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    @Override
    public void getConnectedDevices(Devices category) {

        try {
            commandsExecutor = new ProcessBuilder(
                    "powershell.exe",
                    "chcp 861 | pnputil /enum-devices /class " + category.getEnumType() + " /connected");

            commandsExecutor.redirectErrorStream(true);

            Process p = commandsExecutor.start();

            BufferedReader consoleLinesReader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            getConsoleTrace(consoleLinesReader);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }


    }

    @Override
    public void appendNewDriver(String driverPath) {
        try {
            commandsExecutor = new ProcessBuilder(
                    "powershell.exe", "chcp 861 | pnputil /add-driver '" + driverPath + "' /install");

            commandsExecutor.redirectErrorStream(true);

            Process p = commandsExecutor.start();

            BufferedReader consoleLinesReader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            getConsoleTrace(consoleLinesReader);

        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    @Override
    public void deleteDriver(String driverPath) {
        try {
            commandsExecutor = new ProcessBuilder(
                    "powershell.exe", "chcp 861 | pnputil /delete-driver '" + driverPath + "' /uninstall");

            commandsExecutor.redirectErrorStream(true);

            Process p = commandsExecutor.start();

            BufferedReader consoleLinesReader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            getConsoleTrace(consoleLinesReader);

        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }
}
