package lk.ijse.D24.util;


import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Notification {
    public static void notification(String text){
        Notification.create()
                .title("D24 HOSTEL\n\n")
                //.graphic(new ImageView(image))
                .text(text).
                darkStyle()
                .hideAfter(Duration.seconds(5))
                .show();

    }

    private static Notifications create() {
        return null;
    }


}
