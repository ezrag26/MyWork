package il.co.mywork.crud.filecrud;

import il.co.mywork.crud.filemonitor.FileMonitor;

import java.io.IOException;

public class FileCrudMain {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileMonitor fileMonitor = new FileMonitor("src/il/co/mywork/crud/filecrud", "syslog");
		fileMonitor.startObserving();
		fileMonitor.stopObserving();
	}
}
