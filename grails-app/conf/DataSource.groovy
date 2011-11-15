dataSource {
    pooled = true
    //driverClassName = "org.h2.Driver"
    //username = "sa"
    //password = ""

	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	
	// Other database parameters..
    properties {
       maxActive = 50
       maxIdle = 25
       minIdle = 5
       initialSize = 5
       minEvictableIdleTimeMillis = 1800000
       timeBetweenEvictionRunsMillis = 1800000
       maxWait = 10000
    }
    
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
            url = "jdbc:mysql://localhost/guidelineappdev?useUnicode=yes&characterEncoding=UTF-8"
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
            // url = "jdbc:h2:prodDb"
            url = "jdbc:mysql://localhost/guidelineappdev?useUnicode=yes&characterEncoding=UTF-8"
            username = "guidelineappdev"
			password = "1easy@user"
        }
    }
}
