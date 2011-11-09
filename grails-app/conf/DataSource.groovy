dataSource {
    pooled = true
    //driverClassName = "org.h2.Driver"
    //username = "sa"
    //password = ""

	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	
	//run the evictor every 30 minutes and evict any connections older than 30 minutes.
    minEvictableIdleTimeMillis=1800000
    timeBetweenEvictionRunsMillis=1800000
    numTestsPerEvictionRun=3
    //test the connection while its idle, before borrow and return it
    testOnBorrow=true
    testWhileIdle=true
    testOnReturn=true
    validationQuery="SELECT 1"

    
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            // url = "jdbc:h2:devDb"
            url = "jdbc:mysql://localhost/guidelineappDev?useUnicode=yes&characterEncoding=UTF-8"
            username = "guidelineappdev"
			password = "1easy@user"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb"
        }
    }
}
