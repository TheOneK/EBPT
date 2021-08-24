package com.cyh.ebptonlinewar.test;


import com.cyh.ebptonlinewar.EbptonlineWarApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@SpringBootTest(classes = EbptonlineWarApplication.class)
@WebAppConfiguration
public class druidTest {
    @Autowired
    private DataSource dataSource;

    @Test
    private void testDruid() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

}
