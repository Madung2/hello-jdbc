package hello.jdbc.connection;
//커넥션 상수

import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;

//상수로 만든거기 때문에 객체 생성을 막아둠. 그래서 abstract
public abstract class ConnectionConst {
    public static final String URL ="jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME ="sa";
    public static final String PASSWORD ="";
}



