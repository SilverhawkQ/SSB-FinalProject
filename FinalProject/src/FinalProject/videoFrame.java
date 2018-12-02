package FinalProject;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class videoFrame {

    public void init(String url) {
        NativeInterface.open();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Video");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(getVideo(url), BorderLayout.CENTER);
                frame.setSize(400, 300);
                frame.setVisible(true);

            }
        });

        NativeInterface.runEventPump();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }

    public static JPanel getVideo(String url) {
        JPanel wbPanel = new JPanel(new BorderLayout());
        JWebBrowser wb = new JWebBrowser();
        wbPanel.add(wb, BorderLayout.CENTER);
        wb.setBarsVisible(false);
        wb.navigate(url);

        return wbPanel;
    }
}
