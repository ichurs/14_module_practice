package Package1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Monitor> monitors = getMonitors();

        // Создаем Map (ключ - производитель, значение - список мониторов) для группировки
        // Группируем по проиизводителям
        Map<Producer, List<Monitor>> producerListMap = monitors.stream()
                .collect(Collectors.groupingBy(Monitor::getProducer));

        // Выводим на экран значения, содержащиеся в Map - группированные по производителям списки
        System.out.println("Список мониторов, группированный по производителям:");
        producerListMap.forEach(((producer, monitors1) -> {
            System.out.println("Производитель: " + producer);
            monitors1.forEach(System.out::println);
        }));

        // Находим минимальное значение, среди предварительно отфильтрованных
        System.out.println("\nНаименее дорогой монитор с диагональю больше 22\":");
        monitors.stream()
                .filter(monitor -> monitor.getScreenSize() >= 22.0)
                .min(Comparator.comparing(Monitor::getPrice))
                .ifPresent((System.out::println));
    }

    // метод для вывода мониторов
    private static List<Monitor> getMonitors() {
        return List.of(
                new Monitor(Producer.BENQ, "BL2283", 21.5, 8530),
                new Monitor(Producer.BENQ, "GL2480", 24.0, 9340),
                new Monitor(Producer.BENQ, "EW2480", 23.8, 10150),
                new Monitor(Producer.BENQ, "EW2780Q", 27.0, 24670),
                new Monitor(Producer.BENQ, "EX3501R", 35.0, 46990),
                new Monitor(Producer.DELL, "E1715S", 17.0, 8390),
                new Monitor(Producer.DELL, "U2422H", 23.8, 19990),
                new Monitor(Producer.DELL, "U2722DE", 27.0, 42490),
                new Monitor(Producer.DELL, "U3419W", 34.0, 82990),
                new Monitor(Producer.DELL, "U3818DW", 37.5, 101990),
                new Monitor(Producer.ACER, "V226HQLbid", 21.5, 8430),
                new Monitor(Producer.ACER, "K242HQLbid", 23.6, 8990),
                new Monitor(Producer.ACER, "K242HLDbid", 24.0, 9840),
                new Monitor(Producer.ACER, "K272HLEbid", 27.0, 11750),
                new Monitor(Producer.ACER, "Z301Cbmiphzx", 30.0, 60990),
                new Monitor(Producer.ACER, "Z301Cbmiphzx", 30.0, 60990),
                new Monitor(Producer.PHILIPS, "223V5LSB2", 21.5, 8400),
                new Monitor(Producer.PHILIPS, "246E9QSB", 23.8, 9120),
                new Monitor(Producer.PHILIPS, "271E1SCA", 27.0, 13210),
                new Monitor(Producer.PHILIPS, "322E1C", 31.5, 14990),
                new Monitor(Producer.PHILIPS, "326M6VJRMB", 31.5, 47060)

                );
    }
}
