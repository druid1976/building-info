package pl.put.poznan.buildinginfo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class BuildingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void openBrowser() {
        String url = "http://localhost:8080/buildings";
        try {
            if (isWindows()) {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start " + url});
            } else if (isMac()) {
                Runtime.getRuntime().exec(new String[]{"open", url});
            } else if (isUnix()) {
                Runtime.getRuntime().exec(new String[]{"xdg-open", url});
            } else {
                System.err.println("Unsupported OS");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    private static boolean isMac() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    private static boolean isUnix() {
        return System.getProperty("os.name").toLowerCase().contains("nix") ||
                System.getProperty("os.name").toLowerCase().contains("nux") ||
                System.getProperty("os.name").toLowerCase().contains("aix");
    }
}
