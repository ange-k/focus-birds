package chalkboard.me.focusbirdscore.application.task

import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Service

@Service
@StepScope
class SampleTasklet : Tasklet {

    companion object {
        private val log = LoggerFactory.getLogger(SampleTasklet::class.java)
    }

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        log.info("hello world")
        return RepeatStatus.FINISHED
    }
}
