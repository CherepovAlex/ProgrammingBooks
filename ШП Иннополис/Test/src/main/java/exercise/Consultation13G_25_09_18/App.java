package exercise.Consultation13G_25_09_18;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class SystemMonitor {
    public void printSystemStats() {
        SystemInfo si = new SystemInfo();
        CentralProcessor cpu = si.getHardware().getProcessor();
        GlobalMemory ram = si.getHardware().getMemory();

        double cpuload = cpu.getSystemCpuLoad(1000) * 100;

        long availableBytes = ram.getAvailable();
        long totalBytes = ram.getTotal();

        double availableGB = availableBytes / (1024.0 * 1024.0 * 1024.0);
        double totalGB = totalBytes / (1024.0 * 1024.0 * 1024.0);
        double usedGB = totalGB - availableGB;

        System.out.printf("CPU Load: %.2f%%%n", cpuload);
        System.out.printf("RAM Usage: %.2f / %.2f GB (Available: %.2f GB)%n", usedGB, totalGB, availableGB);
    }
}

class ExcelReport {
    public static void generateReport() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("System Report");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Metric");
        headerRow.createCell(1).setCellValue("Value (GB or %)");
        headerRow.createCell(2).setCellValue("Time");

        SystemInfo si = new SystemInfo();
        CentralProcessor cpu = si.getHardware().getProcessor();
        GlobalMemory ram = si.getHardware().getMemory();

        double cpuLoadPercent = cpu.getSystemCpuLoad(1000) * 100;

        long availableBytes = ram.getAvailable();

        double availableGB = ram.getAvailable() / (1024.0 * 1024.0 * 1024.0);
        double totalGB = ram.getTotal() / (1024.0 * 1024.0 * 1024.0);
        double usedGB = totalGB - availableGB;

        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("CPU Load");
        dataRow.createCell(1).setCellValue(round(cpuLoadPercent, 2));
        dataRow.createCell(2).setCellValue(getCurrentTimestamp());

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("RAM Available (GB)");
        dataRow2.createCell(1).setCellValue(round(availableGB, 2));
        dataRow2.createCell(2).setCellValue(getCurrentTimestamp());

        Row dataRow3 = sheet.createRow(3);
        dataRow3.createCell(0).setCellValue("RAM Used (GB)");
        dataRow3.createCell(1).setCellValue(round(usedGB, 2));
        dataRow3.createCell(2).setCellValue(getCurrentTimestamp());

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Александр\\Downloads\\system_report.xlsx")) {
            workbook.write(fos);
            System.out.println("File written");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                workbook.close();
            } catch (IOException ignored) {
                System.out.println(ignored.getMessage());
            }
        }
    }

    private static String getCurrentTimestamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}

public class App {
    public static void main(String[] args) {
        SystemMonitor monitor = new SystemMonitor();
        monitor.printSystemStats();

        ExcelReport.generateReport();
    }
}
