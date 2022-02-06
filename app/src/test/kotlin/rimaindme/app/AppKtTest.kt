package rimaindme.app

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.platform.commons.logging.LoggerFactory
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.containers.MySQLContainerProvider
import org.testcontainers.containers.output.Slf4jLogConsumer
import org.testcontainers.utility.DockerImageName

class MysqlContainer : MySQLContainer<MysqlContainer>(
    DockerImageName.parse("mysql:8.0.28")
)
class AppKtTest : FunSpec({

    val logger = org.slf4j.LoggerFactory.getLogger(javaClass)
    val container = MysqlContainer().withLogConsumer(Slf4jLogConsumer(logger))
    beforeSpec {
        container.start()
    }
    afterSpec {
        container.stop()
    }

    test("test") {
        1 shouldBe 1
    }

})
