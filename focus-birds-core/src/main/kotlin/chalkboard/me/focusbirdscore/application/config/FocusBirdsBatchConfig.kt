package chalkboard.me.focusbirdscore.application.config

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock
import java.time.ZoneId
import javax.sql.DataSource

@Configuration
@EnableBatchProcessing
class FocusBirdsBatchConfig : DefaultBatchConfigurer() {

    override fun setDataSource(dataSource: DataSource) {
        // オンメモリ動作
    }

    @Bean
    fun clock(): Clock {
        return Clock.system(ZoneId.of("Asia/Tokyo"))
    }
}
