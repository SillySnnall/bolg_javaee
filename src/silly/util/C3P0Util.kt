package silly.util

import com.mchange.v2.c3p0.ComboPooledDataSource

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException

object C3P0Util {
    // 获得c3p0连接池对象
    private val ds = ComboPooledDataSource()

    /**
     * 获得数据库连接对象
     *
     * @return
     * @throws SQLException
     */
    val connection: Connection
        @Throws(SQLException::class)
        get() = ds.connection

    /**
     * 获得c3p0连接池对象
     *
     * @return
     */
    val dataSource: DataSource
        get() = ds
}
