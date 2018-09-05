package silly.base

import org.apache.commons.dbutils.QueryRunner
import silly.util.C3P0Util

open class BaseDao {

   fun getQueryRunner(): QueryRunner {
       return QueryRunner(C3P0Util.dataSource)
   }
}