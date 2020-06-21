package il.co.mywork.crud.filecrud;

import il.co.mywork.crud.Crud;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileCrudTest {

	@Test
	public void test() throws IOException {
		Crud<Integer, String> crud = new FileCrud("./src/il/co/mywork/crud/filecrud/syslog_backup.txt");
		assertEquals(1,crud.create("Hello"));
		assertEquals(2,crud.create("Something else"));
		assertEquals(3,crud.create("Last thing"));
	}

}