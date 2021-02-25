package chalkboard.me.focusbirdscore.application.step

import chalkboard.me.focusbirdscore.application.task.SampleTasklet
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SampleTaskConfig(
    private val stepBuilderFactory: StepBuilderFactory,
    private val sampleTasklet: SampleTasklet
) {
    companion object {
        const val SAMPLE_TASK = "sampleTaskStep"
    }

    @Bean(name = [SAMPLE_TASK])
    fun sampleTaskStep(): Step {
        return stepBuilderFactory.get(SAMPLE_TASK)
            .tasklet(sampleTasklet)
            .build()
    }
}
