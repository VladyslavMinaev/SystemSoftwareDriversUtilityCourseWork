package org.drivers;

import org.drivers.service.DriverService;
import org.drivers.service.DriverServiceImpl;

public class Main {
    public static void main(String[] args) {

        DriverService drivers =
                new DriverServiceImpl();

        drivers.getEnumDrivers();

        //Вивести список усіх наявних драйверів пристроїв відповідної категорії (Оголошені у enum Devices)
        drivers.getConnectedDevices(Devices.VIDEOCARD);

        //Встановлення (додавання) драйвера. Необхідно вказати шлях до файлу-драйвера з розширенням INF.

        drivers.appendNewDriver(
                "C:\\Users\\Fuutarou_Uesugi\\Desktop\\SPZ\\driversUtility\\drive\\btmaux.inf"
        );

        //Видалення драйвера. Необхідно вказати шлях до файлу-драйвера з розширенням INF.

        drivers.deleteDriver(
                "C:\\Users\\Fuutarou_Uesugi\\Desktop\\SPZ\\driversUtility\\drive\\btmaux.inf"
        );

        //Вручну виконати кастомну команду (вивести список усіх наявних драйверів пристрою)
        drivers.runCustomQuery("pnputil /enum-devices");
    }
}
