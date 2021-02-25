package chalkboard.me.focusbirdscore.application.job

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class SampleTaskJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val sampleTaskStep: Step
) {

    companion object {
        const val SAMPLE_JOB = "sampleJob"
    }

    @Bean(name = [SAMPLE_JOB])
    fun sampleJob(): Job {
        return jobBuilderFactory.get(SAMPLE_JOB)
            .incrementer(RunIdIncrementer())
            .start(sampleTaskStep)
            .build()
    }
}
